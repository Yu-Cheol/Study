/* 문자 리스트를 문자열로 변환하기 */
public class Main {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};
        String answer = "";

        for(int i = 0; i < arr.length; i++){
            answer += arr[i];
        }
        System.out.println(answer);

        /* StringBuilder */
        StringBuilder res = new StringBuilder();

        for(String s : arr){
            res.append(s);
        }

        System.out.println(res.toString());
    }
}