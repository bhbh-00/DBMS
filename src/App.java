import java.util.ArrayList;
import java.util.Scanner;

public class App {

	Scanner sc = new Scanner(System.in);

	private ArticleDao aDao = new ArticleDao();
	private MemberDao mDao = new MemberDao();
	Member login = null;
	
	String[] Article = { "add : 게시물 추가", "list : 게시물 목록 조회", "read : 게시물 조회", "search : 검색", "sort : 정렬",
			"page : 페이지" };
	String[] Member = { "signup : 회원가입", "signin : 로그인", "findpass : 비밀번호 찾기", "findid : 아이디 찾기", "logout : 로그아웃",
			"myinfo : 나의 정보 확인 및 수정" };

	public void start() {

		while (true) {

			System.out.println("원하는 명령어를 입력하세요.");

			String cmd = sc.nextLine();

			if (cmd.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (cmd.equals("menu")) {
				printMenu();
			} else if (cmd.equals("add")) {
				AddArticle();
			} else if (cmd.equals("list")) {
				ArticlesList();
			} else if (cmd.equals("delete")) {
				DeleteArticle();
			} else if (cmd.equals("update")) {
				UpdateArticle();
			} else if (cmd.equals("read")) {
				readArticle();
			} else if (cmd.equals("signup")) {
				Membersignup();
			}
		}

	}

	// ======================================================메서드
	// 메뉴보기
	public void printMenu() {
		System.out.println("메뉴보기");
		String menu = sc.nextLine();
		if (menu.equals("Article")) {
			for (int i = 0; i < Article.length; i++) {
				System.out.println(i + 1 + ". " + Article[i]);
			}
		} else if (menu.equals("Member")) {
			for (int i = 0; i < Member.length; i++) {
				System.out.println(i + 1 + ". " + Member[i]);
			}
		}
	}

	// 게시물추가 - add
	public void AddArticle() {
		System.out.println("게시물을 추가 합니다");
		System.out.println("제목을 입력해주세요 : ");
		String title = sc.nextLine();
		System.out.println("내용을 입력해주세요 : ");
		String body = sc.nextLine();

		aDao.insertArticle(title, body);
	}

	// 게시물보기 - list
	public void ArticlesList() {
		ArrayList<Article> article = aDao.getArticles();
		printArticles(article);
	}

	public void printArticles(ArrayList<Article> article) {
		for (int i = 0; i < article.size(); i++) {
			System.out.println(article.get(i).getTitle());
		}
	}

	// 게시물삭제 - delete
	public void DeleteArticle() {
		System.out.println("삭제할 게시물의 번호를 입력해주세요.");
		int ArticleNum = Integer.parseInt(sc.nextLine());

		aDao.deleteArticle(ArticleNum);
	}

	// 게시물수정 - update
	public void UpdateArticle() {
		System.out.println("수정할 게시물의 번호를 입력해주세요.");
		int ArticleNum = Integer.parseInt(sc.nextLine());
		System.out.println("제목을 입력해주세요 : ");
		String title = sc.nextLine();
		System.out.println("내용을 입력해주세요 : ");
		String body = sc.nextLine();

		aDao.updateArticle(title, body, ArticleNum);
	}

	// 게시물상세보기 - read
	public void readArticle() {
		System.out.println("게시물을 선택해주세요.");
		int ArticleNum = Integer.parseInt(sc.nextLine());

		Article article = new Article();

		if (article == null) {
			System.out.println("없는 게시물입니다.");
		} else {
			ArrayList<Reply> reply = aDao.getRepliesByArticleId(ArticleNum);
			printArticle(article, reply);
		}

		while (true) {

			System.out.println("상세보기 기능을 선택해주세요. 1.댓글 등록, 2.좋아요, 3. 수정, 4.삭제, 5.목록으로 :");

			int rcmd = Integer.parseInt(sc.nextLine());

			if (rcmd == 1) {
				System.out.print("댓글 내용을 입력해주세요 :");
				String reply = sc.nextLine();
				aDao.insertReply(article.getArticleNum(), reply);
			} else if (rcmd == 2) {

			}
		}
	}

	public void printArticle(Article article, ArrayList<Reply> reply) {
		System.out.println("게시물 번호 :" + article.getArticleNum());
		System.out.println("게시물 제목 :" + article.getTitle());
		System.out.println("게시물 내용 :" + article.getBody());
		System.out.println("==== 댓글 ====");
		for (int i = 0; i < reply.size(); i++) {
			System.out.println("댓글 내용 :" + reply.get(i).getReplybody());
			System.out.println("댓글 작성자 :" + reply.get(i).getReplynickname());
			System.out.println("등록날짜 :" + reply.get(i).getReplyregdate());
			System.out.println("==================================");
		}

	}
	
	public void Membersignup() {
		System.out.println("======== 회원가입 ========");
		System.out.print("아이디 : ");
		String id = sc.nextLine(); 
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		System.out.println("닉네임 : ");
		String nm = sc.nextLine();
		
		mDao.insertMember(id, pw, nm);
		
	}
	
	public void MemberLOGIN() {
		System.out.println("======== LOGIN ========");
		System.out.print("아이디 : ");
		String id = sc.nextLine(); 
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		Member target = mDao.getMemberByLoginIdAndPw(id, pw);
		
		if(login == null) {
			System.out.println("잘못된 정보입니다.");
		} else {
			login = target;
			System.out.println(target.getMembernickname() + "님, 안녕하세요!");
		}
		
	}

}
