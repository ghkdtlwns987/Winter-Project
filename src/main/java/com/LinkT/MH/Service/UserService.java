package com.LinkT.MH.Service;

import com.LinkT.MH.Mapper.user.userMapper;
import com.LinkT.MH.entity.user.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    userMapper userMapper;

    // 회원가입 시 저장시간을 넣어줄 DateTime형
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);


    @Transactional
    public void JoinUser(UserVO userVO){
        System.out.println("JoinUser");
        System.out.println(userVO.getUserName());
        System.out.println(userVO.getName());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userVO.setUserPw(passwordEncoder.encode(userVO.getPassword()));
        userVO.setUserAuth("USER");
        userVO.setAppendDate(localTime);
        userVO.setUpdateDate(localTime);
        userMapper.Join(userVO);
    }
}