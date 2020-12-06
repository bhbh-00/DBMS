package board.article;
import java.util.ArrayList;

import board.DBUtil2;

public class ArticleDao {

	private DBUtil2 db = new DBUtil2();

	// 여러개 가져올 때 -> getRows
	// 한개 가져올 때(KEY로 가져올 때) -> getRow
	// 추가,수정,삭제시 가져올 때 -> updateQuery

	// 전체조회
	public ArrayList<Article> getArticles() {
		String sql = "SELECT a.*, Membernickname nickname FROM article a INNER JOIN `member` m ON a.MRegNum = MemberRegNum";
		return db.getRows(sql, new ArticleRowMapper()); // 조회가 필요한 것
	}

	// 게시물 수정
	public int updateArticle(String title, String body, int aid) {
		String sql = "update article set title = ?, body = ? where id = ?";
		return db.updateQuery(sql, title, body, aid); // 추가,수정,삭제가 필요한 것
	}

	// 게시물 삭제
	public int deleteArticle(int aid) {
		String sql = "delete from article where id = ?";
		return db.updateQuery(sql, aid);
	}

	// 게시물 추가
	public int insertArticle(String title, String body) {
		String sql = "insert into article set title = ?, body = ?, MRegNum = 1, regDate = NOW(), hit = 0";
		return db.updateQuery(sql, title, body);
	}
	
	public int insertReply(int parentId, String replybody) {
		String sql = "insert into reply set parentId = ?, replybody = ?, replynickname = '익명', replyregdate = NOW()";
		return db.updateQuery(sql, parentId, replybody);
	}

	public ArrayList<Reply> getRepliesByArticleId(int parentId) {
		String sql = "select * from reply where parentId = ?";
		return db.getRows(sql, new ReplyRowMapper(), parentId);
	}
	
	public Article getArticleById(int ArticleNum) {
		String sql = "select * from article where ArticleNum = ?";
		return db.getRow(sql, new ArticleRowMapper(), ArticleNum);
	}
	
	//검색 제목 1. 제목, 2. 내용, 3. 제목 + 내용, 4. 작성자
	public Article searchArticleBytitle(String title) {
		String sql = "select * from article where title like concat_ws('%', '?', '%')";
		return db.getRow(sql, new ArticleRowMapper(), title);
	}
	
	public Article searchArticleBytitle(String title, String body) {
		String sql = "select * from article where title like concat_ws('%', '?', '%')";
		return db.getRow(sql, new ArticleRowMapper(), title, body);
	}
	
	//조회수로 정렬
	public ArrayList<Article> sortArticleByhitofacs() {
		String sql = "SELECT a.*, Membernickname nickname FROM article a INNER JOIN `member` m ON a.MRegNum = MemberRegNum order by a.hit asc";
		return db.getRows(sql, new ArticleRowMapper());
	}
	
	public ArrayList<Article> sortArticleByhitofdesc() {
		String sql = "SELECT a.*, Membernickname nickname FROM article a INNER JOIN `member` m ON a.MRegNum = MemberRegNum order by a.hit desc";
		return db.getRows(sql, new ArticleRowMapper());
	}

}
