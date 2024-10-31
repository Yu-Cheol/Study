import java.util.Scanner;

/* 문자열 섞기 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        String res = "";

        for (int i = 0; i < str1.length(); i++) {
            res += String.valueOf(str1.charAt(i)) + str2.charAt(i);
        }

        System.out.println(res);

        /* StringBuilder 사용 */

        StringBuilder res1 = new StringBuilder();
        String res2 = ""; // 문자 -> 문자열 변환시켜주기 위한 res2 변수 선언

        for(int i = 0; i < str1.length(); i++) {
            res1.append(str1.charAt(i)).append(str2.charAt(i)); // .append 메서드를 이용해서 str1, str2의 각 문자들을 res1에 번갈아가며 추가
        }
        res2 = res1.toString(); // 문자열로 변환

        System.out.println(res2);
    }
}