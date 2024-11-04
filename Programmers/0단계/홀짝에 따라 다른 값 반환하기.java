import java.util.Scanner;

/* 홀짝에 따라 다른 값 반환하기 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int i = scan.nextInt();
        int sub = 0;
        int sum = 0;

        for(int j = 0; j <= i; j++) {
            if(j % 2 == 0){
                sub += j * j;
            }else{
                sum += j;
            }
        }
        int res = i % 2 == 0 ? sub : sum;

        System.out.println(res);
    }
}