import java.util.Scanner;

/* 문자열 출력하기 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("문자열 입력 : ");
        String str = scan.nextLine();

        System.out.println(str);
    }
}