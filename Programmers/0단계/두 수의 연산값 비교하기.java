import java.util.Scanner;

/* 두 수의 연산값 비교하기 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int i = scan.nextInt();
        int j = scan.nextInt();

        int ij = Integer.parseInt(""+i+j);
        int ji = 2 * i * j;

        int res = ij != ji ? Math.max(ij, ji) : ij;

        System.out.println(res);
    }
}