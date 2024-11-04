import java.util.Scanner;

/* n의 배수 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int i = scan.nextInt();
        int j = scan.nextInt();

        int res;
        res = i % j == 0 ? 1 : 0;

        System.out.println(res);
    }
}