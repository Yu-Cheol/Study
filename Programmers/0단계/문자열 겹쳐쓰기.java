import java.util.Scanner;

/* 문자열 겹쳐쓰기 */
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();
        String ow_str = scan.nextLine();
        int i = scan.nextInt();

        String res = str.substring(0,i) + ow_str;
        // str 처음부터 i 번까지의 부분 문자열에 ow_str 을 붙여서 res 에 저장

        if(str.length() > res.length()){ // 원본 문자열의 길이가 결과 문자열보다 길면
            res += str.substring(res.length());
            // 남은 부분을 res 에 덧붙임 (즉, 원래 문자열의 나머지 부분 추가)
        }
        System.out.println(res);
    }
}