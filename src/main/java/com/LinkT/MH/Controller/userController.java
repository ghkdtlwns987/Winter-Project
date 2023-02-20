package com.LinkT.MH.Controller;

import com.LinkT.MH.Mapper.user.userMapper;
import com.LinkT.MH.Service.UserService;
import com.LinkT.MH.entity.user.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// data를 저장하거나 업데이트 하려면 객체를 저장해야 함.
// 근데 객체를 생성해주는게 Annotation에서 RequiredArgsConstructor이다.

@Controller
@RequiredArgsConstructor
public class userController {
    private final UserService userService;
    private final userMapper userMapper;
    private HttpSession session;

    private String message="";

    @RequestMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping("FindPasswordForm.do")
    public String FindPasswordForm(){
        return "User/UpdatePW";
    }

    @PostMapping("/UpdatePW.do")
    public String FindPassword(UserVO vo){
        userService.updatePW(vo);
        return "home";
    }
    // 회원가입 메소드
    @GetMapping("/Join.do")
    public String Join(UserVO vo) {
        //userService.JoinUser(vo);
        userService.Join(vo);
        return "redirect:/LoginForm.do";
    }

    @GetMapping("/JoinForm.do")
    public String JoinForm(){
        return "User/JoinForm";
    }
    @GetMapping("/LoginForm.do")
    public String LoginForm(){
        return "User/LoginForm";
    }

    // 회원 정보 삭제
    @RequestMapping("Delete.do")
    public String Delete(Model model, HttpSession session){
        String id = (String)session.getAttribute("id");
        userService.UserDelete(id);
        session.invalidate();
        return "home";
    }

    // 비동기 처리에서 아이디 검증하는 메소드
    @ResponseBody
    @GetMapping("checkID.do") // 아이디 중복확인을 위한 값으로 따로 매핑
    public int checkID(String id) throws Exception{
        int result = userService.overlappedID(id); // 중복확인한 값을 int로 받음
        return result;
    }

    // 회원정보 수정 메소드
    @RequestMapping("/Update.do")
    public String Update(UserVO vo, Model model){
        userService.Update(vo);
        return "User/UpdateS";
    }

    // Profile 페이지 이동
    @RequestMapping("/Profile.do")
    public String Profile() {

        return "User/Profile";
    }

    // 회원정보 수정 Form
    @GetMapping("/UpdateForm.do")
    public String UpdateForm(Model model, Authentication authentication){
        UserVO userVO = (UserVO) authentication.getPrincipal();  //userDetail 객체를 가져옴
        UserVO vo = userService.LoadUser(userVO.getId());
        model.addAttribute("userVO", vo);
        return "User/UpdateForm";
    }

    @GetMapping("/User_Access")
    public String userAccess(Model model, Authentication authentication) {
        //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
        UserVO userVO = (UserVO) authentication.getPrincipal();  //userDetail 객체를 가져옴
        model.addAttribute("info", userVO.getUserName()+ "님 안녕하세요");      //유저 아이디
        return "/home";
    }
}
