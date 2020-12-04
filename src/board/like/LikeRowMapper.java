package board.like;

import java.sql.ResultSet;
import java.sql.SQLException;

import board.RowMapper;

public class LikeRowMapper implements RowMapper<Like> {

	public Like getRow(ResultSet rs) throws SQLException {

		int like = rs.getInt("like");
		int ArticleNum = rs.getInt("ArticleNum");
		int MemberRegNum = rs.getInt("MemberRegNum");
		String regdate = rs.getString("regdate");

		Like likes = new Like();
		likes.setLike(like);
		likes.setArticleNum(ArticleNum);
		likes.setMemberRegNum(MemberRegNum);
		likes.setRegdate(regdate);

		return likes;
	}

}
