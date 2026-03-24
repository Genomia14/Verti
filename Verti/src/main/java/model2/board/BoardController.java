package model2.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import User.UserDTO;
import board.BoardDAO;
import board.BoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.JSFunction;

@Controller
public class BoardController {

    @Autowired
    private BoardDAO dao;

    @GetMapping("/")
    public String home() {
        return "redirect:/Index.jsp";
    }

    @GetMapping({"/list.do", "/mvcboard/list.do"})
    public String list(@RequestParam(value = "searchWord", required = false) String searchWord, Model model) {
        if (searchWord == null || searchWord.trim().isEmpty()) {
            searchWord = " ";
        }
        
        List<BoardDTO> boardLists = dao.selectList(searchWord);
        model.addAttribute("boardLists", boardLists);
        
        int totalCount = dao.selectCount(searchWord);
        model.addAttribute("totalCount", totalCount);

        if (totalCount == 0) {
            model.addAttribute("noResultsMessage", "게시물이 없습니다.");
        }

        return "list";
    }

    @GetMapping("/login.do")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login.do")
    public void loginSubmit(@RequestParam("id") String id, 
                            @RequestParam("password") String password,
                            HttpSession session, 
                            HttpServletResponse resp) {
        UserDTO user = dao.getUserById(id);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("loginUser", user);
            try {
                resp.sendRedirect("Index.jsp");
            } catch (Exception e) {}
        } else {
            JSFunction.alertLocation(resp, "아이디 또는 비밀번호가 잘못되었습니다.", "login.jsp");
        }
    }

    @GetMapping("/logout.do")
    public void logout(HttpSession session, HttpServletResponse resp) throws Exception {
        session.invalidate();
        resp.sendRedirect("login.jsp");
    }

    @GetMapping("/write.do")
    public String writeForm() {
        return "write";
    }

    @PostMapping("/write.do")
    public String writeSubmit(@RequestParam("title") String title,
                              @RequestParam("id") String id,
                              @RequestParam("content") String content,
                              HttpSession session,
                              HttpServletRequest request) {
        BoardDTO dto = new BoardDTO();
        dto.setTitle(title);
        dto.setContent(content);
        dto.setId(id);
        
        int result = dao.insertWrite(dto);
        if (result > 0) {
            session.setAttribute("alertMessage", "문의가 완료되었습니다.");
            return "redirect:/Index.jsp";
        } else {
            request.setAttribute("alertMessage", "작성에 실패하였습니다.");
            return "write";
        }
    }

    @GetMapping("/register.do")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register.do")
    public void registerSubmit(@RequestParam("id") String id,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam("passwordCheck") String passwordCheck,
                               @RequestParam("name") String name,
                               @RequestParam("phone") String phone,
                               HttpServletResponse resp) {
        if (!password.equals(passwordCheck)) {
            JSFunction.alertBack(resp, "비밀번호가 일치하지 않습니다.");
            return;
        }

        UserDTO user = new UserDTO(id, email, password, name, phone);
        int result = dao.insertUser(user);

        if (result == 1) {
            JSFunction.alertLocation(resp, "회원가입이 성공적으로 완료되었습니다.", "login.jsp");
        } else {
            JSFunction.alertLocation(resp, "회원가입 실패, 다시 시도해 주세요.", "register.jsp");
        }
    }
}
