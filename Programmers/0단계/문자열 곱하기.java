import java.util.Scanner;

/* 문자열 곱하기 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String ms = scan.nextLine();
        int i = scan.nextInt();

        String res = "";

        for(int j = 1; j <= i; j++){
            res += ms;
        }
        System.out.println(res);

        /* StringBuilder */
        StringBuilder res1 = new StringBuilder();

        for(int k = 1; k <= i; k++){
            res1.append(ms);
        }
        System.out.println(res1.toString());
    }
}