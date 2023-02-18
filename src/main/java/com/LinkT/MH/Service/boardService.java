package com.LinkT.MH.Service;

import com.LinkT.MH.Mapper.board.boardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor

public class boardService {

    @Autowired
    private boardMapper boardMapper;

    // 회원가입 시 저장시간을 넣어줄 DateTime형
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);



}
