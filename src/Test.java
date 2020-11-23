
public class Test {

	public static void main(String[] args) {
		String sql1 = "select * from article";
		String sql2 = "update article set";
		
		System.out.println();
		sql1.startsWith("select");
		//select로 시작하는거 찾아줘(문자열이 특정 문자열로 시작하는지 확인하는 메서드)
		
		if(sql1.startsWith("select") || sql1.startsWith("delete") ) {
			sql1.indexOf(" title "); //title
			// sql1.substring(1); ()안의 수 만큼 잘려서 출력되는 메서드
		}else {
			
		}
		
		// 문자열 공백 지우는 메서드 replace
		String str1 = "a aa aaa aaaa";
		System.out.println(str1.replace(" ", ""));
				
	}

}
