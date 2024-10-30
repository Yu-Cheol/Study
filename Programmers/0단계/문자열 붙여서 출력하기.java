import java.util.Scanner;

/* 문자열 붙여서 출력하기 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String str1 = scan.nextLine();
        String str2 = scan.nextLine();

        System.out.println(str1+str2);

        /* 이런 방법도 써봤지만 런타임 에러가 떠버렸다.. (프로그래머스 기준) 실행은 잘 됨 */
        StringBuilder sb = new StringBuilder();

        String str3 = scan.nextLine();
        String str4 = scan.nextLine();

        sb.append(str3).append(str4); // str3, str4 문자열을 연결

        System.out.println(sb.toString()); // toString() 최종 문자열을 String 형태로 출력
    }
}