package com.LinkT.MH.Controller;

import com.LinkT.MH.Mapper.user.userMapper;
import com.LinkT.MH.entity.user.JoinVO;
import com.LinkT.MH.entity.user.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// data를 저장하거나 업데이트 하려면 객체를 저장해야 함.
// 근데 객체를 생성해주는게 Annotation에서 RequiredArgsConstructor이다.

@Controller
public class userController {
    @Inject
    private userMapper mapper;
    private HttpSession session;

    private String message="";

    @RequestMapping("/")
    public String home() {
        return "home";
    }


    @RequestMapping("FindPasswordForm.do")
    public String FindPasswordForm(){
        return "user/UpdatePW";
    }
    @RequestMapping("/UpdatePW.do")
    public String FindPassword(JoinVO vo){
        mapper.updatePW(vo);
        return "home";
    }
    // 회원가입 메소드
    @RequestMapping("/Join.do")
    public String Join(JoinVO vo, Model model) {
        if (!vo.getPw().equals(vo.getPw_check())) {
            message = "비밀번호가 서로 다릅니다.";
            model.addAttribute("message", message);
            model.addAttribute("linkUrl", "JoinForm.do");
            return "user/JoinF";
        }
        mapper.Join(vo);
        message = "회원가입에 성공했습니다.";
        model.addAttribute("message", message);
        model.addAttribute("linkUrl", "LoginForm.do");
        return "user/JoinS";
    }

    // 회원 정보 삭제
    @RequestMapping("Delete.do")
    public String Delete(Model model, HttpSession session){
        String id = (String)session.getAttribute("id");
        mapper.DeleteUser(id);
        session.invalidate();
        message = "회원 정보가 삭제되었습니다.";
        model.addAttribute("message", message);
        model.addAttribute("linkUrl", "/");
        return "user/DeleteS";
    }

    // 비동기 처리에서 아이디 검증하는 메소드
    @ResponseBody // 값 변환을 위해 꼭 필요함
    @RequestMapping("checkID.do") // 아이디 중복확인을 위한 값으로 따로 매핑
    public int checkID(UserVO vo) throws Exception{
        int result = mapper.overlappedID(vo); // 중복확인한 값을 int로 받음
        return result;
    }
    
    // 로그아웃 메소드
    @RequestMapping("Logout.do")
    public String Logout(HttpSession session){
        session.invalidate();
        return "home";
    }
    
    // 로그인 메소드
    @RequestMapping("Login.do")
    public String Login(UserVO vo, Model model, HttpServletRequest request) {
        UserVO user = mapper.LoginCheck(vo);
        if (user == null) {
            message = "id나 pw를 찾을 수 없습니다.";
            model.addAttribute("message", message);
            model.addAttribute("linkUrl", "LoginForm.do");
            if(session != null) {
                session.setAttribute("id", null);
                session.setAttribute("name", null);
            }
            return "user/LoginF";
        }
        String id = user.getId();
        String name = user.getName();
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        session.setAttribute("name", name);
        message = name + "님 환영합니다.";
        System.out.println(message);
        model.addAttribute("message", message);
        model.addAttribute("linkUrl", "/");
        return "user/LoginS";
    }

    // 회원정보 수정 메소드
    @RequestMapping("/Update.do")
    public String Update(UserVO vo, Model model){
        message = "회원정보가 수정되었습니다.";
        mapper.Update(vo);
        model.addAttribute("message", message);
        model.addAttribute("linkUrl", "/");
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
    @RequestMapping("/UpdateForm.do")
    public String UpdateForm(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("id");
        System.out.println(id);
        UserVO vo = mapper.LoadUser(id);
        System.out.println(vo);
        System.out.println("Model VO");
        model.addAttribute("userVO", vo);
        return "user/UpdateForm";
    }
}
