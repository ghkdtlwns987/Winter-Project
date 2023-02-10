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
        return "user/UpdatePW";
    }
    @GetMapping("/UpdatePW.do")
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
        System.out.println(id);
        int result = userService.overlappedID(id); // 중복확인한 값을 int로 받음
        return result;
    }
    
    // 로그아웃 메소드
    @RequestMapping("Logout.do")
    public String Logout(HttpSession session){
        session.invalidate();
        return "home";
    }
    
    // 로그인 메소드
    @GetMapping("Login.do")
    //public String Login(Authentication authentication, Model model, HttpServletRequest request) {
    public String Login(UserVO vo, Model model, HttpServletRequest request){
        //UserVO user = userService.LoginCheck(vo);
        //UserVO userVO = (UserVO) authentication.getPrincipal();  //userDetail 객체를 가져옴
        UserVO userVO = userService.Login(vo);
        if (userVO == null) {
            message = "id나 pw를 찾을 수 없습니다.";
            model.addAttribute("message", message);
            model.addAttribute("linkUrl", "LoginForm.do");
            if(session != null) {
                session.setAttribute("id", null);
                session.setAttribute("name", null);
            }
            return "user/LoginF";
        }
        message = userVO.getId() + "님 로그인을 환영합니다.";
        model.addAttribute("message", message);
        model.addAttribute("linkUrl", "/");
        System.out.println("DEBUG");
        String id = userVO.getId();
        System.out.println(id);
        String name = userVO.getName();
        System.out.println(name);
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        session.setAttribute("name", name);
        return "user/LoginS";
    }

    // 회원정보 수정 메소드
    @RequestMapping("/Update.do")
    public String Update(UserVO vo, Model model){
        userService.Update(vo);
        return "user/UpdateS";
    }

    // 로그인 되지 않았다면 Not Login으로 이동
    @RequestMapping("/NotLogin.do")
    public String NotLogin() {
        return "NotLogin";
    }

    // Profile 페이지 이동
    @RequestMapping("/Profile.do")
    public String Profile() {

        return "user/Profile";
    }

    // 로그인 Form
    @RequestMapping("/LoginForm.do")
    public String LoginForm() {
        return "user/LoginForm";
    }

    // 회원가입 Form
    @RequestMapping("/JoinForm.do")
    public String JoinForm() {
        return "user/JoinForm";
    }

    // 회원정보 수정 Form
    @GetMapping("/UpdateForm.do")
    public String UpdateForm(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("id");
        UserVO vo = userService.LoadUser(id);
        model.addAttribute("userVO", vo);
        return "user/UpdateForm";
    }
}
