import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberRowMapper implements RowMapper<Member> // <> 안에는 내가 다루고 싶은 것을 넣는다 
{
	
	@Override
	public Member getRow(ResultSet rs) throws SQLException {

		ArrayList<Member> Members = new ArrayList<>();

		int id = rs.getInt("Mid");
		String Mid = rs.getString("id");
		String MPw = rs.getString("MPw");
		String Mnickname = rs.getString("Mnickname");
		String MregDate = rs.getString("MregDate");

		Member member = new Member();
		member.setId(id);
		member.setMPw(MPw);
		member.setMNickname(Mnickname);
		member.setMregDate(MregDate);

		Members.add(member);

		return member;
		
		// 
	}
}
