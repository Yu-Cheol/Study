import java.util.Scanner;

/* 문자열 돌리기 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();

        for(int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }

        /* 다르게 풀이 */
        String str2 = scan.nextLine();
        char[] ch = str2.toCharArray(); // "abcde" 라는 문자열을 문자 배열로 변환

        for (char c : ch) { // 향샹된 for 문을 사용해 ch 의 각 문자를 변수 c에 넣음
            System.out.println(c);
        }
    }
}