package verti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@ComponentScan(basePackages = {"verti", "User", "board", "common", "model2", "utils"})
public class VertiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VertiApplication.class, args);
    }
}

@Component
class DatabaseInitializer implements ApplicationRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) {
        // 테이블 자동 생성 (없을 때만)
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS verti_user (" +
                "id VARCHAR(50) PRIMARY KEY, " +
                "email VARCHAR(100) NOT NULL, " +
                "password VARCHAR(255) NOT NULL, " +
                "name VARCHAR(50) NOT NULL, " +
                "phone VARCHAR(20))");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS verti_board (" +
                "num INT AUTO_INCREMENT PRIMARY KEY, " +
                "title VARCHAR(200) NOT NULL, " +
                "content TEXT, " +
                "id VARCHAR(50) NOT NULL, " +
                "postdate DATETIME DEFAULT CURRENT_TIMESTAMP, " +
                "visitcount INT DEFAULT 0, " +
                "FOREIGN KEY (id) REFERENCES verti_user(id) ON DELETE CASCADE)");

        // 회원이 0명이면 최초 더미 데이터 자동 삽입
        Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM verti_user", Integer.class);
        if (count != null && count == 0) {
            System.out.println("초기 데이터가 비어있어 더미 데이터를 자동 생성합니다...");
            jdbcTemplate.execute("INSERT INTO verti_user (id, email, password, name, phone) VALUES " +
                    "('musthave', 'musthave@verti.com', '1234', '머스트해브', '010-1111-2222'), " +
                    "('zeta', 'zeta@verti.com', '1234', '제타', '010-3333-4444'), " +
                    "('admin', 'admin@verti.com', '1234', '관리자', '010-9999-9999')");

            jdbcTemplate.execute("INSERT INTO verti_board (title, content, id, visitcount, postdate) VALUES " +
                    "('첫 번째 가입 인사드립니다!', '안녕하세요 잘 부탁드립니다~ 테스트용 텍스트입니다.', 'musthave', 12, NOW()), " +
                    "('Verti 게시판 너무 깔끔하네요.', 'Spring Boot 기반으로 엄청 빠르고 좋습니다.', 'zeta', 5, NOW()), " +
                    "('공지사항: 홈페이지 개편 안내', '오라클에서 MariaDB로 DB가 마이그레이션 되었습니다. 감사합니다.', 'admin', 99, NOW()), " +
                    "('안녕하세요 제타입니다', '저는 더미 유저입니다.', 'zeta', 0, NOW())");
        }
    }
}
