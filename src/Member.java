
public class Member {
	private int id; // 등록번호
	private String MId; // 회원가입 아이디
	private String MPw; // 회원가입 비밀번호
	private String MNickname; // 회원가입 닉네임
	private String MregDate; // 회원가입 등록날짜

	public Member() {

	}

	public Member(int id, String mId, String mPw, String mNickname, String mregDate) {
		this.id = id;
		this.MId = mId;
		this.MPw = mPw;
		this.MNickname = mNickname;
		this.MregDate = mregDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMId() {
		return MId;
	}

	public void setMId(String mId) {
		MId = mId;
	}

	public String getMPw() {
		return MPw;
	}

	public void setMPw(String mPw) {
		MPw = mPw;
	}

	public String getMNickname() {
		return MNickname;
	}

	public void setMNickname(String mNickname) {
		MNickname = mNickname;
	}

	public String getMregDate() {
		return MregDate;
	}

	public void setMregDate(String mregDate) {
		MregDate = mregDate;
	}

}
