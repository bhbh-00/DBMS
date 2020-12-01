
public class Delete {
	// 아래 내용을 DBUtil에서 관리
//	// 드라이버 정보
//	String driver = "com.mysql.cj.jdbc.Driver";
//	// dbms 주소
//	String url = "jdbc:mysql://localhost:3306/t1?serverTimezone=UTC";
//	// 사용자 계정
//	String user = "sbsst";
//	// 사용자 비밀번호
//	String pass = "sbs123414";
//
//	// 공유 변수
//	Connection conn = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//
//	public Connection getConnection() {
//		
//		ArrayList<Article> articles = new ArrayList<>();
//
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, pass);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
//
//	public ArrayList<Article> getRows(String sql) {
//		ArrayList<Article> articles = null;
//
//		try {
//			conn = getConnection();
//
//			pstmt = conn.prepareStatement(sql); // PreparedStatment 통해서 sql 세팅
//
//			rs = pstmt.executeQuery(); // 조회 결과가 있는 경우
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//		}
//
//		return articles;
//	}
//
//	public void setData(String sql) {
//
//	}
//
//	
//	
//	
//	
//	
//
//	public ArrayList<Article> getArticles() {
//
//		ArrayList<Article> articles = new ArrayList<>();
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			Class.forName(driver);
//
//			conn = DriverManager.getConnection(url, user, pass);
//
//			String sql = "SELECT * FROM article";
//			pstmt = conn.prepareStatement(sql); // PreparedStatment 통해서 sql 세팅
//
//			rs = pstmt.executeQuery(); // 조회 결과가 있는 경우
//			// pstmt.executeUpdate(); // 조회 결과가 없는 경우
//
//			while (rs.next()) {
//				String title = rs.getString("title");
//				int id = rs.getInt("id");
//				String body = rs.getString("body");
//				String nickname = rs.getString("nickname");
//				int hit = rs.getInt("hit");
//
//				Article article = new Article();
//				article.setTitle(title);
//				article.setBody(body);
//				article.setNickname(nickname);
//				article.setId(id);
//				article.setHit(hit);
//
//				articles.add(article);
//
//			}
//
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		} catch (ClassNotFoundException e2) {
//			// DBMS 선택 -> 담당자(Connection) 부여받음
//			e2.printStackTrace();
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return articles;
//	}
//
//	public void addArticle(String title, String body) {
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			Class.forName(driver);
//
//			conn = DriverManager.getConnection(url, user, pass);
//
//			String sql2 = " INSERT INTO article SET title = ?, `body` = ?, nickname = '홍길동', hit = 10";
//			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
//
//			pstmt2.setString(1, title);
//			pstmt2.setString(2, body);
//			pstmt2.executeUpdate();
//
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		} catch (ClassNotFoundException e2) {
//			// DBMS 선택 -> 담당자(Connection) 부여받음
//			e2.printStackTrace();
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public Article getArticleById(int id) {
//
//		Article article = new Article();
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			Class.forName(driver);
//
//			conn = DriverManager.getConnection(url, user, pass);
//
//			String sql2 = "select * from article where id = ?";
//			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
//			pstmt2.setInt(1, id);
//
//			rs = pstmt2.executeQuery();
//
//			if (rs.next()) {
//				String title = rs.getString("title");
//				article.setTitle(title);
//			}
//
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		} catch (ClassNotFoundException e2) {
//			// DBMS 선택 -> 담당자(Connection) 부여받음
//			e2.printStackTrace();
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return article;
//	}
//
//	public void updateArticle(int id, String title, String body) {
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null; // 조회 결과가 있을 때만 사용
////
////		/*
////		 * Scanner sc = new Scanner(System.in);
////		 * 
////		 * int a = sc.nextInt(); System.out.println("Hello world!" + a);
////		 * 
////		 * => 숫자만 입력 받을 수 있음. 개발자 입장에서는 숫자로 입력 받는 것을 알 수 있지만 사용자 입장에서는 그렇지 못하기 때문에 오류가
////		 * 발생할 수 있음 그렇기 때문에 예외처리 할 수 있는 장치를 해둔다. try { int a = sc.nextInt(); } catch
////		 * (예외) { } 도움말에서 try / catch 처리를 해주는 장치가 있음
////		 */
//
//		try {
//
//			Class.forName(driver);
//
//			conn = DriverManager.getConnection(url, user, pass);
//
//			String sql = "UPDATE article SET title = ?, `body` = ? WHERE id = ?";
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setString(1, title);
//			pstmt.setString(2, body);
//			pstmt.setInt(3, id);
//
//			pstmt.executeUpdate();
//
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		} catch (ClassNotFoundException e2) {
//			// DBMS 선택 -> 담당자(Connection) 부여받음
//			e2.printStackTrace();
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public void deleteArticle(int id) {
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			Class.forName(driver);
//
//			conn = DriverManager.getConnection(url, user, pass);
//
//			String sql = "delete from article WHERE id = ?";
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setInt(1, id);
//
//			pstmt.executeUpdate();
//
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		} catch (ClassNotFoundException e2) {
//			// DBMS 선택 -> 담당자(Connection) 부여받음
//			e2.printStackTrace();
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}

//	public ArrayList<Article> getArticles() {
//
//		ArrayList<Article> articles = new ArrayList<>();
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null; 
//
//		try {
//
//			Class.forName(driver);
//
//			conn = DriverManager.getConnection(url, user, pass);
//
//			String sql = "SELECT * FROM article";
//			pstmt = conn.prepareStatement(sql); // PreparedStatment 통해서 sql 세팅
//
//			rs = pstmt.executeQuery(); // 조회 결과가 있는 경우
//			// pstmt.executeUpdate(); // 조회 결과가 없는 경우
//
//			while (rs.next()) {
//				String title = rs.getString("title");
//				int id = rs.getInt("id");
//				String body = rs.getString("body");
//				String nickname = rs.getString("nickname");
//				int hit = rs.getInt("hit");
//
//				Article article = new Article();
//
//				article.setTitle(title);
//				article.setBody(body);
//				article.setNickname(nickname);
//				article.setId(id);
//				article.setHit(hit);
//
//				articles.add(article);
//
//			}
//
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//			// printStackTrace(); => 특별하게 출력할 내용이 없다면 사용
//		} catch (ClassNotFoundException e2) {
//			// DBMS 선택 -> 담당자(Connection) 부여받음
//			e2.printStackTrace();
//		} finally {
//			try {
//				// 모두 다 각자 처리 되어야하기 때문에 else if를 사용하지않는다.
//				if (rs != null) {
//					rs.close();
//				}
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//				// 자원해제 - 예외처리가 끝나면 close();를 해줘야함
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return articles;
//	}
//	
//	public ArrayList<Article> AddArticleslist() {
//		
//		ArrayList<Article> articles = new ArrayList<>();
//		
//		Connection conn = null;
//
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, pass);
//			
//			String sql2 = " INSERT INTO article SET title = ?, `body` = ?, nickname = '홍길동', hit = 10";
//			
//			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		} catch (SQLException e2) {
//			e2.printStackTrace();
//		}
//		
//		return articles;
//	}
	
//	ArticleDao articleDao = new ArticleDao();
//
//	Scanner sc = new Scanner(System.in);
//
//	while (true) {
//		System.out.println("명령어를 입력해주세요 : ");
//		String cmd = sc.nextLine();
//
//		if (cmd.equals("list")) {
//
//			ArrayList<Article> articles = articleDao.getArticles();
//
//			for (int i = 0; i < articles.size(); i++) {
//				System.out.println("제목 : " + articles.get(i).getTitle());
//			}
//
//			/*
//			 * 리팩토링 전
//			 * 
//			 * String sql = "SELECT * FROM article"; PreparedStatement pstmt =
//			 * conn.prepareStatement(sql); // PreparedStatment 통해서 sql 세팅 ResultSet rs =
//			 * pstmt.executeQuery(); // 조회 결과가 있는 경우 // pstmt.executeUpdate(); // 조회 결과가 없는
//			 * 경우 while (rs.next()) { String title = rs.getString("title"); int id =
//			 * rs.getInt("id"); String body = rs.getString("body"); String nickname =
//			 * rs.getString("nickname"); int hit = rs.getInt("hit"); System.out.println(id +
//			 * " " + title + " " + body + " " + nickname + " " + hit); }
//			 */
//
//		}
//
//		else if (cmd.equals("add")) {
//			
//			Article a = new Article(); 
//			
//			System.out.print("제목 : ");
//			String title = sc.nextLine();
//			a.setTitle(title);
//			System.out.print("내용 : ");
//			String body = sc.nextLine();
//			a.setBody(body);
//			
//			ArrayList<Article> articles = articleDao.AddArticleslist();
//
//			articles.setString(1, title);
//			articles.setString(2, body);
//			articles.executeUpdate();
//		}
////		else if (cmd.equals("update")) {
////			System.out.print("번호 : ");
////			int id = Integer.parseInt(sc.nextLine());
////
////			String sql2 = "select * from article where id = ?";
////			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
////			pstmt2.setInt(1, id);
////
////			ResultSet rs = pstmt2.executeQuery();
////
////			if (rs.next()) {
////
////				String sql = "UPDATE article SET title = ?, `body` = ? WHERE id = ?";
////				PreparedStatement pstmt = conn.prepareStatement(sql);
////				System.out.print("제목 : ");
////				String title = sc.nextLine();
////				System.out.print("내용 : ");
////				String body = sc.nextLine();
////
////				pstmt.setString(1, title);
////				pstmt.setString(2, body);
////				pstmt.setInt(3, id);
////
////				pstmt.executeUpdate();
////			} else {
////				System.out.println("없는 게시물입니다.");
////			}
////		} else if (cmd.equals("delete")) {
////			System.out.print("번호 : ");
////			int id = Integer.parseInt(sc.nextLine());
////
////			String sql2 = "select * from article where id = ?";
////			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
////			pstmt2.setInt(1, id);
////
////			ResultSet rs = pstmt2.executeQuery();
////
////			if (rs.next()) {
////				String sql = "delete from article WHERE id = ?";
////				PreparedStatement pstmt = conn.prepareStatement(sql);
////
////				pstmt.setInt(1, id);
////
////				pstmt.executeUpdate();
////			} else {
////				System.out.println("없는 게시물입니다.");
////			}
////		} else if (cmd.equals("read")) {
////			System.out.print("번호 : ");
////			int id = Integer.parseInt(sc.nextLine());
////
////			String sql2 = "select * from article where id = ?";
////			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
////			pstmt2.setInt(1, id);
////
////			ResultSet rs = pstmt2.executeQuery();
////
////			if (rs.next()) {
////				int id2 = rs.getInt("id");
////				String title = rs.getString("title");
////				String body = rs.getString("body");
////
////				System.out.println("번호 : " + id2);
////				System.out.println("제목 : " + title);
////				System.out.println("내용 : " + body);
////
////			} else {
////				System.out.println("없는 게시물입니다.");
////			}
////		}
}
