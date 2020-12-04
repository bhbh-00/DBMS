package board.like;

public class Like {
	
	private int like;
	private int ArticleNum;
	private int MemberRegNum;
	private String regdate;
	
	public Like() {
		
	}
		
	public Like(int like, int articleNum, int memberRegNum, String regdate) {
		super();
		this.like = like;
		this.ArticleNum = articleNum;
		this.MemberRegNum = memberRegNum;
		this.regdate = regdate;
	}
	
	
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getArticleNum() {
		return ArticleNum;
	}
	public void setArticleNum(int articleNum) {
		ArticleNum = articleNum;
	}
	public int getMemberRegNum() {
		return MemberRegNum;
	}
	public void setMemberRegNum(int memberRegNum) {
		MemberRegNum = memberRegNum;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	

}
