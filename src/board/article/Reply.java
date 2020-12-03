package board.article;

public class Reply {
	
	private int parentId;
	private int replyId;
	private String replybody;
	private String replynickname;
	private String replyregdate;
	
	public Reply() {
		
	}
	
	public Reply(int parentId, int replyId, String replybody, String replynickname, String replyregdate) {
		super();
		this.parentId = parentId;
		this.replyId = replyId;
		this.replybody = replybody;
		this.replynickname = replynickname;
		this.replyregdate = replyregdate;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReplybody() {
		return replybody;
	}

	public void setReplybody(String replybody) {
		this.replybody = replybody;
	}

	public String getReplynickname() {
		return replynickname;
	}

	public void setReplynickname(String replynickname) {
		this.replynickname = replynickname;
	}

	public String getReplyregdate() {
		return replyregdate;
	}

	public void setReplyregdate(String replyregdate) {
		this.replyregdate = replyregdate;
	}
	

}
