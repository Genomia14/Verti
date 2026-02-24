package board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import User.UserDTO;
import common.DBConnPool;

public class BoardDAO extends DBConnPool {
	public int selectCount(String searchWord) {
		int totalCount = 0;
		try {
			String query = "SELECT count(*) FROM verti_board ";

			// 검색어가 있을 경우에만 WHERE 조건을 추가
			if (searchWord != null && !searchWord.trim().isEmpty() && !searchWord.trim().equals(" ")) {
				query += " WHERE title LIKE ? OR content LIKE ?";
			}

			psmt = con.prepareStatement(query);
			// 검색어가 있을 경우에만 파라미터 설정
			if (searchWord != null && !searchWord.trim().isEmpty() && !searchWord.trim().equals(" ")) {
				psmt.setString(1, "%" + searchWord + "%");
				psmt.setString(2, "%" + searchWord + "%");
			}

			rs = psmt.executeQuery();
			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}

	public List<BoardDTO> selectList(String searchWord) {
    List<BoardDTO> bbs = new Vector<>();
    try {
        // LEFT JOIN을 사용하여 verti_user에 작성자가 없더라도 게시물 정보를 가져올 수 있게 수정
        String query = "SELECT B.num, B.title, B.content, B.id, B.postdate, B.visitcount " +
                       "FROM verti_board B " +
                       "LEFT JOIN verti_user M ON B.id = M.id";  // 'id'를 기준으로 JOIN

        // 검색어가 있을 경우에만 WHERE 조건을 추가
        if (searchWord != null && !searchWord.trim().isEmpty() && !searchWord.trim().equals(" ")) {
            query += " WHERE B.title LIKE ? OR B.content LIKE ?";
        }

        query += " ORDER BY B.num DESC";  // 게시물을 번호 내림차순으로 정렬

        psmt = con.prepareStatement(query);

        // 검색어가 있을 경우에만 파라미터 설정
        if (searchWord != null && !searchWord.trim().isEmpty()) {
            psmt.setString(1, "%" + searchWord + "%");
            psmt.setString(2, "%" + searchWord + "%");
        }

        rs = psmt.executeQuery();
        while (rs.next()) {
            BoardDTO dto = new BoardDTO();
            dto.setNum(rs.getString("num"));
            dto.setTitle(rs.getString("title"));
            dto.setContent(rs.getString("content"));
            dto.setId(rs.getString("id"));  // 작성자의 id 설정
            dto.setPostdate(rs.getDate("postdate"));
            dto.setVisitcount(rs.getString("visitcount"));
            bbs.add(dto);
        }

    } catch (Exception e) {
        System.out.println("게시물 조회 중 예외 발생");
        e.printStackTrace();
    }
    return bbs;
}


	public List<BoardDTO> selectListPage(Map<String, Object> map) {
		List<BoardDTO> dtoList = new ArrayList<>();

		String query = "SELECT * FROM verti_board";

		if (map.get("searchWord") != null && !map.get("searchWord").equals("")) {
			query += " WHERE title " + " LIKE '%" + map.get("searchWord") + "%'" + " OR content " + " LIKE '%"
					+ map.get("searchWord") + "%'";
		}

		query += " ORDER BY num DESC" + " OFFSET (? - 1) * ? ROWS" + " FETCH NEXT ? ROWS ONLY";

		try {
			psmt = con.prepareStatement(query);

			int idx = 1;

			psmt.setInt(idx++, (int) map.get("pageNum"));
			psmt.setInt(idx++, (int) map.get("pageSize"));
			psmt.setInt(idx++, (int) map.get("pageSize"));

			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));
				dtoList.add(dto);
			}
		} catch (Exception e) {
			System.out.println("공지사항 목록 조회 중 예외 발생");
			e.printStackTrace();
		}

		return dtoList;
	}

	public int insertWrite(BoardDTO dto) {
		int result = 0;
		try {
			String query = "INSERT INTO verti_board (num, title, content, id, visitcount, postdate) "
					+ "VALUES (SEQ_VERTI_BOARD_NUM.NEXTVAL, ?, ?, ?, 0, sysdate)";

			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());

			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	public BoardDTO selectView(String num) {
		BoardDTO dto = new BoardDTO();
		String query = "SELECT * FROM verti_board WHERE num=?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));
			}

		} catch (Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}

		return dto;
	}


	public void updateVisitCount(String num) {
		try {
			String query = "UPDATE verti_board SET visitcount = visitcount + 1 WHERE num = ?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("조회수 증가 중 예외 발생");
			e.printStackTrace();
		}
	}


	public int updateEdit(BoardDTO dto) {
		int result = 0;
		try {
			String query = "UPDATE verti_board SET " + " title = ? , content = ? " + " WHERE num = ? ";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getNum());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	public int deleteBoard(String num) {
    int result = 0;
    String sql = "DELETE FROM verti_board WHERE num=?";

    try {
        psmt = con.prepareStatement(sql);
        psmt.setString(1, num);
        result = psmt.executeUpdate();
    } catch (Exception e) {
        System.out.println("게시글 삭제 중 예외 발생");
        e.printStackTrace();
    }
    return result;
}

	public int insertUser(UserDTO user) {
		int result = 0;
		String query = "INSERT INTO verti_user (id, email, password, name, phone) VALUES (?, ?, ?, ?, ?)";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getEmail());
			psmt.setString(3, user.getPassword());
			psmt.setString(4, user.getName());
			psmt.setString(5, user.getPhone());

			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("회원가입 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	public UserDTO getUserById(String id) {
		UserDTO user = null;
		String query = "Select id, email, password, name, phone FROM verti_user WHERE id = ?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				user = new UserDTO(rs.getString("id"), rs.getString("email"), rs.getString("password"), rs.getString("name"),
						rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
}
