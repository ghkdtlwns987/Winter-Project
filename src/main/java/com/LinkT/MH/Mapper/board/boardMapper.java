package com.LinkT.MH.Mapper.board;

import com.LinkT.MH.entity.board.boardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface boardMapper {

    /* 글 작성 버튼 클릭  */
    public void boardWrite(boardVO vo);

    /* 게시물 리스트 불러오기 */
    public List<boardVO> boardList();

    /* 게시물 리스트에서 한 게시물 클릭시 불러오기 */
    public boardVO boardDetail(int idx);

    /* 글 수정 */
    public void boardUpdate(boardVO vo);

    /* 글 삭제 */
    public void boardDelete(int board_idx);
}
