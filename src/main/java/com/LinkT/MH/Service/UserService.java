package com.LinkT.MH.Service;

import com.LinkT.MH.Mapper.user.userMapper;
import com.LinkT.MH.entity.user.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService  {
    @Autowired
    private userMapper userMapper;

    // 회원가입 시 저장시간을 넣어줄 DateTime형
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);


    @Transactional
    public void JoinUser(UserVO userVO){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userVO.setUserPw(passwordEncoder.encode(userVO.getPassword()));
        userVO.setUserAuth("USER");
        userVO.setAppendDate(localTime);
        userVO.setUpdateDate(localTime);
        userMapper.Join(userVO);
    }

    @Transactional
    public void Join(UserVO userVO){
        userVO.setUserPw(userVO.getPw());
        userVO.setUserAuth("USER");
        userVO.setAppendDate(localTime);
        userVO.setUpdateDate(localTime);
        userMapper.Join(userVO);
    }

    @Transactional
    public UserVO Login(UserVO userVO){
        UserVO user = userMapper.Login(userVO);
        return user;
    }

    @Transactional
    public void UserDelete(String id){
        userMapper.DeleteUser(id);
    }

    @Transactional
    public UserVO LoginCheck(String id){
        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
        UserVO userVO = userMapper.getUserAccount(id);
        if (userVO == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
        return userVO;
    }
    @Transactional
    public UserVO LoadUser(String id){
        UserVO vo = userMapper.LoadUser(id);
        return vo;
    }
    @Transactional
    public void Update(UserVO vo)
    {
        userMapper.Update(vo);
    }

    @Transactional
    public void updatePW(UserVO userVO){        // 비밀번호 변경
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userVO.setUserPw(passwordEncoder.encode(userVO.getPassword()));
        userVO.setUserAuth("USER");
        userVO.setAppendDate(localTime);
        userVO.setUpdateDate(localTime);
        userMapper.updatePW(userVO);
    }

    @Transactional
    public int overlappedID(String id){
        System.out.println(id);
        int result = userMapper.overlappedID(id);
        return result;
    }

}