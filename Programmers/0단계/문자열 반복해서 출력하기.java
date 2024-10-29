import java.util.Scanner;

/* 문자열 반복해서 출력하기 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();
        int i = scan.nextInt();

        for(int j = 1; j <= i; j++) {
            System.out.print(str);
        }
    }
}