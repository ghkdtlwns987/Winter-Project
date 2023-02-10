package com.LinkT.MH.Mapper.user;

import com.LinkT.MH.entity.user.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper {
    public UserVO LoginCheck(UserVO vo);
    public void Join(UserVO vo);
    public void Update(UserVO vo);
    public UserVO LoadUser(String id);
    public void DeleteUser(String id);
    public int overlappedID(String id);
    public void updatePW(UserVO vo);
    public UserVO getUserAccount(String id);
    public UserVO Login(UserVO vo);
}

