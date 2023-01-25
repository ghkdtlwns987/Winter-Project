package com.LinkT.MH.entity.user;
import lombok.*;

/*
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
*/
@Getter
@Setter
public class JoinVO {
    private String id;
    private String pw;
    private String pw_check;
    private String name;
}