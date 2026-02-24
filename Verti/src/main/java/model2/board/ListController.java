package model2.board;

import java.io.IOException;
import java.util.List;

import board.BoardDAO;
import board.BoardDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/list.do")
public class ListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 검색어가 null인 경우 빈 문자열로 처리
        String searchWord = request.getParameter("searchWord");

        // 검색어가 공백인 경우, 게시물이 없다고 처리
        if (searchWord == null || searchWord.trim().isEmpty()) {
            searchWord = " ";  // 공백을 입력하면 빈 결과를 반환하도록 설정
        }

        BoardDAO dao = new BoardDAO();
        
        // 게시물 목록 조회
        List<BoardDTO> boardLists = dao.selectList(searchWord);
        
        // 조회된 게시물 리스트를 request에 저장
        request.setAttribute("boardLists", boardLists);
        																																	
        // 게시물 수 계산
        int totalCount = dao.selectCount(searchWord);
        request.setAttribute("totalCount", totalCount);

        // 게시물이 없으면 게시물 없음 메시지를 추가
        if (totalCount == 0) {
            request.setAttribute("noResultsMessage", "게시물이 없습니다.");
        }

        // 게시물 목록을 표시할 JSP로 포워딩
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
