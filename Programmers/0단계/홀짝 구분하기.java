import java.util.Scanner;

/* 홀짝 구분하기 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();

        if(i % 2 == 0){
            System.out.println(i + "is even");
        }else{
            System.out.println(i + "is odd");
        }
    }
}