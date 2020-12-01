
public class Reply {

	int id;
	int parentId;
	String body;
	String Nickname;
	String regDate;
	
	public Reply(int id, int parentId, String body, String Nickname, String regDate) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.body = body;
		this.Nickname = Nickname;
		this.regDate = regDate;
	}
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getNickname() {
		return Nickname;
	}
	public void setNickname(String Nickname) {
		this.Nickname = Nickname;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}
