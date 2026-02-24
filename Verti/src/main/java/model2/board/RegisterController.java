package model2.board;

import java.io.IOException;

import User.UserDTO;
import board.BoardDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JSFunction;

@WebServlet("/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		BoardDAO dao = new BoardDAO();
		
		// 폼에서 입력된 값들 받아오기
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String passwordCheck = req.getParameter("passwordCheck");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");

		if (!password.equals(passwordCheck)) {
			JSFunction.alertBack(resp, "비밀번호가 일치하지 않습니다.");
			return;
		}

		UserDTO user = new UserDTO(id, email, password, name, phone);

		int result = dao.insertUser(user);
		dao.close();

		if (result == 1) {
			// 회원가입 성공, 로그인 페이지로 리디렉션
			JSFunction.alertLocation(resp, "회원가입이 성공적으로 완료되었습니다.", "../login.jsp");
		} else {
			// 회원가입 실패, 실패 페이지로 리디렉션
			JSFunction.alertLocation(resp, "회원가입 실패, 다시 시도해 주세요.", "../register.jsp");
		}
	}
}