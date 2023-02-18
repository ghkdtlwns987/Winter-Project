package com.LinkT.MH.entity.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class commentVO {
    private int cmt_idx; // 댓글 인덱스
    private int board_idx; // 댓글이 달린 게시물
    private String id; // 댓글 작성자
    private String cmt_content; // 댓글 내용
    private String append_date;  // 작성 날짜 
}
