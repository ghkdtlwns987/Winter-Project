package com.LinkT.MH.entity.user;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

/*
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
*/
@Data
public class UserVO {
    private int userNo;
    private String id;
    private String pw;
    private String name;
    private String auth;
    private String appendDate;
    private String updateDate;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.auth));
    }

    public void setUserAuth(String auth){
        this.auth = auth;
    }
    public void setUserPw(String pw){
        this.pw = pw;
    }
    public String getPassword() {
        return this.pw;
    }

    // 시큐리티의 userName
    // -> 따라서 얘는 인증할 때 id를 봄
    public String getUsername() {
        return this.id;
    }

    // Vo의 userName !
    public String getUserName(){
        return this.name;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}