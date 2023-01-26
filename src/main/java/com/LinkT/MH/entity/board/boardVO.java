package com.LinkT.MH.entity.board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class boardVO {
    private int board_idx; //게시물 인덱스
    private String board_title; // 게시물 제목
    private String board_content; // 게시물 내용
    private String id; // 게시물 작성자 아이디
}