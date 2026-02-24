package model2.board;

import java.io.IOException;

import board.BoardDAO;
import board.BoardDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/write.do")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("write.jsp").forward(req, resp);
  }
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String title = request.getParameter("title");
		String id = request.getParameter("id");
		String content = request.getParameter("content");

		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setId(id);
		
		BoardDAO dao = new BoardDAO();
		int result = dao.insertWrite(dto);

		HttpSession session = request.getSession();
		if (result > 0) {
			// 성공 시
			session.setAttribute("alertMessage", "문의가 완료되었습니다.");
			response.sendRedirect("Index.jsp");
		} else {
			// 실패 시
			request.setAttribute("alertMessage", "작성에 실패하였습니다.");
			request.getRequestDispatcher("write.jsp").forward(request, response);
		}
	}
}
