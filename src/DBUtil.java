import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBUtil {
	// 드라이버 정보
	String driver = "com.mysql.cj.jdbc.Driver";
	// dbms 주소p
	String url = "jdbc:mysql://localhost:3306/t1?serverTimezone=UTC";
	// 사용자 계정
	String user = "sbsst";
	// 사용자 비밀번호
	String pass = "sbs123414";

	Connection conn = null;

	public PreparedStatement getPrepareStatement(String sql, Object[] params) throws SQLException {

		PreparedStatement pstmt = null;
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);

		// instanceof를 사용하면 문자열을 쪼갤 필요가 없음
		for (int i = 0; i < params.length; i++) {
			if (params[i] instanceof Integer) {
				pstmt.setInt(i + 1, (int) params[i]);
			} else {
				pstmt.setString(i + 1, (String) params[i]);
			}
		}

		return pstmt;
	}

	// Object... params -> 가변인자? -> class + RowMapper에서 이 기능 사용
	public ArrayList<Article> getRows(String sql, Object... params) {

		if (params.length != 0 && params[0] instanceof Object[]) {
			params = (Object[]) params[0];
		}
		ArrayList<Article> articles = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = getPrepareStatement(sql, params);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String title = rs.getString("title");
				int id = rs.getInt("id");
				String body = rs.getString("body");
				String nickname = rs.getString("nickname");
				int hit = rs.getInt("hit");

				Article article = new Article();
				article.setTitle(title);
				article.setBody(body);
				article.setNickname(nickname);
				article.setId(id);
				article.setHit(hit);

				articles.add(article);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}

		return articles;
	}

	public ArrayList<Reply> getReplyRows(String sql, Object... params) {

		if (params.length != 0 && params[0] instanceof Object[]) {
			params = (Object[]) params[0];
		}
		ArrayList<Reply> Reply = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = getPrepareStatement(sql, params);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int parentId = rs.getInt("parentId");
				int id = rs.getInt("id");
				String body = rs.getString("body");
				String nickname = rs.getString("nickname");
				String regDate = rs.getString("regDate");

				Reply reply = new Reply();
				reply.setBody(body);
				reply.setNickname(nickname);
				reply.setId(id);
				reply.setRegDate(regDate);

				Reply.add(reply);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}

		return Reply;
	}

	public Article getRow(String sql, Object... params) {
		return getRows(sql, params).get(0);
	}

	public int updateQuery(String sql, Object... params) {
		if (params.length != 0 && params[0] instanceof Object[]) {
			params = (Object[]) params[0];
		}

		int rst = 0;
		PreparedStatement pstmt = null;

		try {
			System.out.println(sql);
			pstmt = getPrepareStatement(sql, params);
			rst = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
		System.out.println(rst);
		return rst;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {

		try {
			if (rs != null) {
				rs.close();
			}
			close(pstmt, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(PreparedStatement pstmt, Connection conn) {

		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
