import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReplyRowMapper implements RowMapper<Reply>{
	
	@Override
	public Reply getRow(ResultSet rs) throws SQLException{
		
		ArrayList<Reply> Reply = new ArrayList<>();
		
		int parentId = rs.getInt("parentId");
		int id = rs.getInt("id");
		String body = rs.getString("body");
		String writer = rs.getString("writer");
		String regDate = rs.getString("regDate");

		Reply reply = new Reply();
		reply.setParentId(parentId);
		reply.setId(id);
		reply.setBody(body);
		reply.setwriter(writer);
		reply.setRegDate(regDate);

		Reply.add(reply);
		
		return reply;
	}
}
