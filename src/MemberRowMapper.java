import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberRowMapper implements RowMapper<Member> {

	public Member getRow(ResultSet rs) throws SQLException {

		ArrayList<Member> Members = new ArrayList<>();

		int id = rs.getInt("id");
		String Mid = rs.getString("MId");
		String MPw = rs.getString("MPw");
		String Mnickname = rs.getString("Mnickname");
		String MregDate = rs.getString("MregDate");

		Member member = new Member();
		member.setId(id);
		member.setMId(Mid);
		member.setMPw(MPw);
		member.setMNickname(Mnickname);
		member.setMregDate(MregDate);

		Members.add(member);

		return member;
	}
}
