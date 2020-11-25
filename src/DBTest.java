import java.util.ArrayList;
import java.util.Scanner;

public class DBTest {

	public static void main(String[] args) {
		
		ArticleDao articleDao = new ArticleDao();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();
			if(cmd.equals("list")) {
				ArrayList<Article> articles = articleDao.getArticles();
				for(int i = 0; i < articles.size(); i++) {
					System.out.println(articles.get(i).getTitle());
				}
			} else if(cmd.equals("update")) {
				System.out.print("수정할 게시물 번호 : ");
				int aid = Integer.parseInt(sc.nextLine());
				
				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String body = sc.nextLine();
				articleDao.updateArticle(title, body, aid);
			} else if(cmd.equals("delete")) {
				System.out.print("삭제할 게시물 번호 : ");
				int aid = Integer.parseInt(sc.nextLine());
				articleDao.deleteArticle(aid);
			} else if(cmd.equals("add")) {
				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String body = sc.nextLine();
				
				articleDao.insertArticle(title, body);
			} else if(cmd.equals("read")) {
				System.out.print("상세보기할 게시물 번호 : ");
				int aid = Integer.parseInt(sc.nextLine());
				
				Article article = articleDao.getArticleById(aid);
				System.out.println(article.getTitle());
			}
		}

//		ArticleDao articleDao = new ArticleDao();
//
//		Scanner sc = new Scanner(System.in);
//
//		while (true) {
//			System.out.println("명령어를 입력해주세요 : ");
//			String cmd = sc.nextLine();
//
//			if (cmd.equals("list")) {
//
//				ArrayList<Article> articles = articleDao.getArticles();
//
//				for (int i = 0; i < articles.size(); i++) {
//					System.out.println("제목 : " + articles.get(i).getTitle());
//				}
//
//				/*
//				 * 리팩토링 전
//				 * 
//				 * String sql = "SELECT * FROM article"; PreparedStatement pstmt =
//				 * conn.prepareStatement(sql); // PreparedStatment 통해서 sql 세팅 ResultSet rs =
//				 * pstmt.executeQuery(); // 조회 결과가 있는 경우 // pstmt.executeUpdate(); // 조회 결과가 없는
//				 * 경우 while (rs.next()) { String title = rs.getString("title"); int id =
//				 * rs.getInt("id"); String body = rs.getString("body"); String nickname =
//				 * rs.getString("nickname"); int hit = rs.getInt("hit"); System.out.println(id +
//				 * " " + title + " " + body + " " + nickname + " " + hit); }
//				 */
//
//			}
//
//			else if (cmd.equals("add")) {
//				
//				Article a = new Article(); 
//				
//				System.out.print("제목 : ");
//				String title = sc.nextLine();
//				a.setTitle(title);
//				System.out.print("내용 : ");
//				String body = sc.nextLine();
//				a.setBody(body);
//				
//				ArrayList<Article> articles = articleDao.AddArticleslist();
//
//				articles.setString(1, title);
//				articles.setString(2, body);
//				articles.executeUpdate();
//			}
////			else if (cmd.equals("update")) {
////				System.out.print("번호 : ");
////				int id = Integer.parseInt(sc.nextLine());
////
////				String sql2 = "select * from article where id = ?";
////				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
////				pstmt2.setInt(1, id);
////
////				ResultSet rs = pstmt2.executeQuery();
////
////				if (rs.next()) {
////
////					String sql = "UPDATE article SET title = ?, `body` = ? WHERE id = ?";
////					PreparedStatement pstmt = conn.prepareStatement(sql);
////					System.out.print("제목 : ");
////					String title = sc.nextLine();
////					System.out.print("내용 : ");
////					String body = sc.nextLine();
////
////					pstmt.setString(1, title);
////					pstmt.setString(2, body);
////					pstmt.setInt(3, id);
////
////					pstmt.executeUpdate();
////				} else {
////					System.out.println("없는 게시물입니다.");
////				}
////			} else if (cmd.equals("delete")) {
////				System.out.print("번호 : ");
////				int id = Integer.parseInt(sc.nextLine());
////
////				String sql2 = "select * from article where id = ?";
////				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
////				pstmt2.setInt(1, id);
////
////				ResultSet rs = pstmt2.executeQuery();
////
////				if (rs.next()) {
////					String sql = "delete from article WHERE id = ?";
////					PreparedStatement pstmt = conn.prepareStatement(sql);
////
////					pstmt.setInt(1, id);
////
////					pstmt.executeUpdate();
////				} else {
////					System.out.println("없는 게시물입니다.");
////				}
////			} else if (cmd.equals("read")) {
////				System.out.print("번호 : ");
////				int id = Integer.parseInt(sc.nextLine());
////
////				String sql2 = "select * from article where id = ?";
////				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
////				pstmt2.setInt(1, id);
////
////				ResultSet rs = pstmt2.executeQuery();
////
////				if (rs.next()) {
////					int id2 = rs.getInt("id");
////					String title = rs.getString("title");
////					String body = rs.getString("body");
////
////					System.out.println("번호 : " + id2);
////					System.out.println("제목 : " + title);
////					System.out.println("내용 : " + body);
////
////				} else {
////					System.out.println("없는 게시물입니다.");
////				}
////			}
		

	}
}