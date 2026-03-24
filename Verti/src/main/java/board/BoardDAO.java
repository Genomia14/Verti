package board;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import User.UserDTO;

@Repository
public class BoardDAO {

    private final JdbcTemplate jdbcTemplate;

    public BoardDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<BoardDTO> boardRowMapper() {
        return (rs, rowNum) -> {
            BoardDTO dto = new BoardDTO();
            dto.setNum(rs.getString("num"));
            dto.setTitle(rs.getString("title"));
            dto.setContent(rs.getString("content"));
            dto.setId(rs.getString("id"));
            dto.setPostdate(rs.getDate("postdate"));
            dto.setVisitcount(rs.getString("visitcount"));
            return dto;
        };
    }

    private RowMapper<UserDTO> userRowMapper() {
        return (rs, rowNum) -> new UserDTO(
            rs.getString("id"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getString("name"),
            rs.getString("phone")
        );
    }

    public int selectCount(String searchWord) {
        String query = "SELECT count(*) FROM verti_board ";
        if (searchWord != null && !searchWord.trim().isEmpty() && !searchWord.trim().equals(" ")) {
            query += " WHERE title LIKE ? OR content LIKE ?";
            return jdbcTemplate.queryForObject(query, Integer.class, "%" + searchWord + "%", "%" + searchWord + "%");
        }
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public List<BoardDTO> selectList(String searchWord) {
        String query = "SELECT B.num, B.title, B.content, B.id, B.postdate, B.visitcount " +
                       "FROM verti_board B " +
                       "LEFT JOIN verti_user M ON B.id = M.id";

        if (searchWord != null && !searchWord.trim().isEmpty() && !searchWord.trim().equals(" ")) {
            query += " WHERE B.title LIKE ? OR B.content LIKE ? ORDER BY B.num DESC";
            return jdbcTemplate.query(query, boardRowMapper(), "%" + searchWord + "%", "%" + searchWord + "%");
        }
        
        query += " ORDER BY B.num DESC";
        return jdbcTemplate.query(query, boardRowMapper());
    }

    public List<BoardDTO> selectListPage(Map<String, Object> map) {
        String query = "SELECT * FROM verti_board";
        
        String searchWord = (String) map.get("searchWord");
        if (searchWord != null && !searchWord.equals("")) {
            query += " WHERE title LIKE ? OR content LIKE ?";
            query += " ORDER BY num DESC LIMIT ? OFFSET ?";
            int pageSize = (int) map.get("pageSize");
            int offset = ((int) map.get("pageNum") - 1) * pageSize;
            return jdbcTemplate.query(query, boardRowMapper(), "%" + searchWord + "%", "%" + searchWord + "%", pageSize, offset);
        }

        query += " ORDER BY num DESC LIMIT ? OFFSET ?";
        int pageSize = (int) map.get("pageSize");
        int offset = ((int) map.get("pageNum") - 1) * pageSize;
        return jdbcTemplate.query(query, boardRowMapper(), pageSize, offset);
    }

    public int insertWrite(BoardDTO dto) {
        String query = "INSERT INTO verti_board (title, content, id, visitcount, postdate) VALUES (?, ?, ?, 0, NOW())";
        return jdbcTemplate.update(query, dto.getTitle(), dto.getContent(), dto.getId());
    }

    public BoardDTO selectView(String num) {
        String query = "SELECT * FROM verti_board WHERE num=?";
        List<BoardDTO> results = jdbcTemplate.query(query, boardRowMapper(), num);
        return results.isEmpty() ? null : results.get(0);
    }

    public void updateVisitCount(String num) {
        String query = "UPDATE verti_board SET visitcount = visitcount + 1 WHERE num = ?";
        jdbcTemplate.update(query, num);
    }

    public int updateEdit(BoardDTO dto) {
        String query = "UPDATE verti_board SET title = ?, content = ? WHERE num = ?";
        return jdbcTemplate.update(query, dto.getTitle(), dto.getContent(), dto.getNum());
    }

    public int deleteBoard(String num) {
        String sql = "DELETE FROM verti_board WHERE num=?";
        return jdbcTemplate.update(sql, num);
    }

    public int insertUser(UserDTO user) {
        String query = "INSERT INTO verti_user (id, email, password, name, phone) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query, user.getId(), user.getEmail(), user.getPassword(), user.getName(), user.getPhone());
    }

    public UserDTO getUserById(String id) {
        String query = "SELECT id, email, password, name, phone FROM verti_user WHERE id = ?";
        List<UserDTO> results = jdbcTemplate.query(query, userRowMapper(), id);
        return results.isEmpty() ? null : results.get(0);
    }
}
