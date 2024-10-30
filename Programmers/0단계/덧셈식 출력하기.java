import java.util.Scanner;

/* 덧셈식 출력하기 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int i = scan.nextInt();
        int j = scan.nextInt();

        System.out.println(i+"+"+j+"="+(i+j));
    }
}