import java.util.ArrayList;

public class ArticleDao {
	
	
private DBUtil2 db = new DBUtil2();
	
	// 여러개 가져올 때 -> getRows
	// 한개 가져올 때(KEY로 가져올 때) -> getRow
	// 추가,수정,삭제시 가져올 때 -> updateQuery
	
	//전체조회
	public ArrayList<Article> getArticles() {
		String sql = "select * from article";
		return db.getRows(sql); //조회가 필요한 것
	}
	
	//수정
	public int updateArticle(String title, String body, int aid) {
		String sql = "update article set title = ?, body = ? where id = ?";
		return db.updateQuery(sql, title, body, aid); //추가,수정,삭제가 필요한 것
	}
	
	//삭제
	public int deleteArticle(int aid) {
		String sql = "delete from article where id = ?";
		return db.updateQuery(sql, aid);
	}
	
	//
	public int insertArticle(String title, String body) {
		String sql = "insert into article set title = ?, body = ?, nickname = '익명', regDate = NOW(), hit = 0";
		return db.updateQuery(sql, title, body);
	}

	public Article getArticleById(int aid) {
		String sql = "select * from article where id = ?";
		return db.getRow(sql, aid);
	}

	public void insertReply(int id, String body) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Member> insertMember(String mid, String mpw, String mnn) {
		String sql = "insert into member set Mid = ?, MPw = ?, Mnickname = '?', regDate = NOW()";
		return db.updateQuery(sql, params);
	}

	public ArrayList<Member> getMember(String mid, String mpw) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
