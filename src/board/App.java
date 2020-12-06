package board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import board.article.Article;
import board.article.ArticleDao;
import board.article.Reply;
import board.member.Member;
import board.member.MemberDao;

public class App {

	Scanner sc = new Scanner(System.in);

	private ArticleDao aDao = new ArticleDao();
	private MemberDao mDao = new MemberDao();
	private Member login = null;

	int hitNo = 0;

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
			} else if (cmd.equals("search")) {
				searchArticle();
			} else if (cmd.equals("sort")) {
				Articlesort();
			} else if (cmd.equals("signup")) {
				Membersignup();
			} else if (cmd.equals("signin")) {
				MemberLOGIN();
			} else if (cmd.equals("logout")) {
				MemberLogout();
			}
		}

	}

	// ======================================================메서드
	// 프로그램 시작
	public void startboard() {

	}

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

		if (!isLogin()) {

		} else {
			System.out.println("게시물을 추가 합니다");
			System.out.println("제목을 입력해주세요 : ");
			String title = sc.nextLine();
			System.out.println("내용을 입력해주세요 : ");
			String body = sc.nextLine();

			aDao.insertArticle(title, body);
		}
	}

	// 게시물보기 - list
	public void ArticlesList() {
		ArrayList<Article> article = aDao.getArticles();
		printArticles(article);
	}

	// 게시물 출력
	public void printArticles(ArrayList<Article> article) {
		for (int i = 0; i < article.size(); i++) {
			Article articles = article.get(i);
			System.out.println("=========== " + articles.getArticleNum() + "번 게시물 ===========");
			System.out.println("제목 : " + articles.getTitle());
			System.out.println("내용 : " + articles.getBody());
			System.out.println("작성자 : " + articles.getNickname());
			System.out.println("조회수 : " + articles.getHit());
			System.out.println("등록날짜 : " + articles.getRegdate());
			System.out.println("================================");
		}
	}

	// 게시물삭제 - delete
	public void DeleteArticle() {

		if (!isLogin()) {

		} else {
			System.out.println("삭제할 게시물의 번호를 입력해주세요.");
			int ArticleNum = Integer.parseInt(sc.nextLine());

			aDao.deleteArticle(ArticleNum);
		}
	}

	// 게시물수정 - update
	public void UpdateArticle() {

		if (!isLogin()) {

		} else {
			System.out.println("수정할 게시물의 번호를 입력해주세요.");
			int ArticleNum = Integer.parseInt(sc.nextLine());
			System.out.println("제목을 입력해주세요 : ");
			String title = sc.nextLine();
			System.out.println("내용을 입력해주세요 : ");
			String body = sc.nextLine();

			aDao.updateArticle(title, body, ArticleNum);
		}
	}

	// 게시물상세보기 - read
	public void readArticle() {

		if (!isLogin()) {

		} else {
			System.out.println("게시물을 선택해주세요.");
			int aid = Integer.parseInt(sc.nextLine());

			Article article = aDao.getArticleById(aid);

			if (article == null) {
				System.out.println("없는 게시물입니다.");
			} else {
				ArrayList<Reply> reply = aDao.getRepliesByArticleId(article.getArticleNum());
				printArticle(article, reply);

				article.setHit(article.getHit() + 1);

				while (true) {

					System.out.println("상세보기 기능을 선택해주세요. 1.댓글 등록, 2.좋아요, 3. 수정, 4.삭제, 5.목록으로 :");
					System.out.print(" 1.댓글 등록, 2.좋아요, 3. 수정, 4.삭제, 5.목록으로 :");

					int rcmd = Integer.parseInt(sc.nextLine());

					if (rcmd == 1) {
						System.out.print("댓글 내용을 입력해주세요 : ");
						String Rbody = sc.nextLine();
						aDao.insertReply(article.getArticleNum(), Rbody);
					} else if (rcmd == 2) {

					} else {
						break;
					}
				}

			}
		}
	}

	// 게시물 출력 + 댓글
	public void printArticle(Article article, ArrayList<Reply> reply) {

		System.out.println("======== " + article.getArticleNum() + " ========");
		System.out.println("제목 : " + article.getTitle());
		System.out.println("내용 : " + article.getBody());
		System.out.println("조회수 : " + article.getHit());
		System.out.println("등록날짜 : " + article.getRegdate());
		System.out.println("==== 댓글 ====");
		for (int i = 0; i < reply.size(); i++) {
			System.out.println("댓글 내용 :" + reply.get(i).getReplybody());
			System.out.println("댓글 작성자 :" + reply.get(i).getReplynickname());
			System.out.println("등록날짜 :" + reply.get(i).getReplyregdate());
			System.out.println("===============================");
		}

	}

	// 게시물 검색 기능
	public void searchArticle() {

		if (!isLogin()) {

		} else {
			System.out.println("게시물 검색 방식을 선택해주세요.");
			System.out.println();
			System.out.println("1. 제목, 2. 내용, 3. 제목 + 내용, 4. 작성자");

			int flag = Integer.parseInt(sc.nextLine());

			System.out.println("검색키워드를 입력해주세요.");
			String key = sc.nextLine();
		}
	}

	// 게시물 정렬 기능
	public void Articlesort() {

		ArrayList<Article> article;
		
		System.out.println("정렬 대상을 선택해주세요. : (like : 좋아요,  hit : 조회수)");
		String sortType = sc.nextLine();
		if (sortType.equals("like")) {
			System.out.println("정렬 방법을 선택해주세요. : (asc : 오름차순,  desc : 내림차순)");
			String sortOrder = sc.nextLine();
			if (sortOrder.equals("asc")) {
			} else if (sortOrder.equals("desc")) {
			}
		} else if (sortType.equals("hit")) {
			System.out.println("정렬 방법을 선택해주세요. : (asc : 오름차순,  desc : 내림차순)");
			String sortOrder = sc.nextLine();
			if (sortOrder.equals("asc")) {
				aDao.sortArticleByhitofdesc();
			} else if (sortOrder.equals("desc")) {
				aDao.sortArticleByhitofdesc();
			}
		}
	}

	// 회원가입기능
	public void Membersignup() {
		System.out.println("======== 회원가입 ========");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		System.out.print("닉네임 : ");
		String nm = sc.nextLine();

		mDao.insertMember(id, pw, nm);
		System.out.println("회원가입이 되었습니다.");

	}

	// 로그인기능
	public void MemberLOGIN() {
		System.out.println("======== LOGIN ========");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();

		Member target = mDao.getMemberByLoginIdAndPw(id, pw);

		if (target == null) {
			System.out.println("잘못된 정보입니다.");
		} else {
			System.out.println(target.getMembernickname() + "님, 안녕하세요!");
			login = target;
		}

	}

	// 로그인필요기능
	private boolean isLogin() {
		if (login == null) {
			System.out.println("로그인이 필요한 기능입니다.");
			return false;
		} else {
			return true;
		}
	}

	// 로그아웃
	public void MemberLogout() {
		if (!isLogin()) {

		} else {
			login = null;
			System.out.println("로그아웃 되었습니다.");
		}
	}

}
