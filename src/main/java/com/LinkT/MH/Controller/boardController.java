package com.LinkT.MH.Controller;

import com.LinkT.MH.Mapper.board.boardMapper;
import com.LinkT.MH.Service.boardService;
import com.LinkT.MH.entity.board.boardVO;
import com.LinkT.MH.entity.user.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class boardController {

    @Inject
    private boardMapper mapper;
    private boardService boardService;
    private HttpSession session;


    /* 현재 로그인한 아이디 받아오기 */
    public void loginId(){

    }

    /* 댓글 불러오기 */

    /* 댓글 작성 */

    /* 댓글 삭제 */


    /* 글 작성 페이지로 이동 */
    @RequestMapping("/boardWritePage.do")
    public String boardWritePage(Model model, Authentication authentication) {

        UserVO userVO = (UserVO) authentication.getPrincipal();  //userDetail 객체를 가져옴
        model.addAttribute("id", userVO.getId());      //유저 아이디

        return "board/boardWrite";
    }

    /* 글 등록 버튼 눌렀을때 실행되는 메소드 */
    @RequestMapping("/boardWriteForm.do")
    public String boardWriteForm(boardVO vo){
        mapper.boardWrite(vo);
        return "redirect:/boardList.do";
    }

    /* 게시글 목록 */
    @RequestMapping("/boardList.do")
    public String boardList(Model model){

        List<boardVO> vo = mapper.boardList();
        model.addAttribute("vo", vo);

        return "board/boardList";
    }

    /* 게시판 상세보기 */
    @RequestMapping("/boardDetail.do")
    public String boardDetail(int board_idx, Model model, Authentication authentication){

        UserVO userVO = (UserVO) authentication.getPrincipal();  //userDetail 객체를 가져옴
        model.addAttribute("id", userVO.getId());      //유저 아이디

        // 사용자가 게시판 리스트에서 게시물 하나를 클릭하면 해당 게시물의 인덱스가 컨트롤러로 넘어옴
        // 받아온 idx값을 이용해서 그 idx의 게시물 정보(행)을 불러오기
        boardVO vo = mapper.boardDetail(board_idx);
        model.addAttribute("vo", vo);

        return "board/boardDetail";
    }

    /* 게시글 수정 페이지 */
    @RequestMapping("boardUpdate.do")
    public String boardUpdate(int board_idx, Model model){

        // 사용자가 게시물 수정 페이지로 들어오면
        // 자신이 썼던 글 제목, 글 내용이 들어와 있어야 사용하기 편하다
        // =select
        boardVO vo = mapper.boardDetail(board_idx);
        model.addAttribute("vo", vo);


        return "board/boardUpdate";
    }

    /* 글 수정 버튼 눌렀을때 실행되는 메소드 */
    @RequestMapping("/boardUpdateForm.do")
    public String boardUpdateForm(boardVO vo, Model model){

        mapper.boardUpdate(vo);
        int board_idx = vo.getBoard_idx();
        String url = "redirect:/boardDetail.do?board_idx=" + board_idx;

        return url;
    }

    /* 게시글 삭제 */
    @RequestMapping("/boardDelete.do")
    public String boardDelete(int board_idx){

        mapper.boardDelete(board_idx);

        return "redirect:/boardList.do";
    }

}
