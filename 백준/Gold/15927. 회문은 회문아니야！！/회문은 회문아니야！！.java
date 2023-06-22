import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 문자열 입력
        String input = br.readLine();
        
        // 펠린드롬이 아닌 최장 문자열 길이 구하기
        int answer = -1;
        if (!isAllSame(input)) {
            for (int i = input.length(); i > -1; i--) {
                String subString = input.substring(0, i);

                if (!isPalindrome(subString)) {
                    answer = subString.length();
                    break;
                }

            }
        }
        
        // 출력
        System.out.println(answer);
    }

    public static boolean isPalindrome(String input) {

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            char leftChar = input.charAt(left);
            char rightChar = input.charAt(right);

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean isAllSame(String input) {
        return input.matches(
                "A+||B+||C+||D+||E+||F+||G+" +
                        "||H+||I+||J+||K+||L+||M+||N+" +
                        "||O+||P+||Q+||R+||S+||T+||U+" +
                        "||V+||W+||X+||Y+||Z+");
    }
}