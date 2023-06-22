import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int answer = -1;
        if (!input.matches(
                "A+||B+||C+||D+||E+||F+||G+" +
                        "||H+||I+||J+||K+||L+||M+||N+" +
                        "||O+||P+||Q+||R+||S+||T+||U+" +
                        "||V+||W+||X+||Y+||Z+")) {
            for (int i = input.length(); i > -1; i--) {
                String subString = input.substring(0, i);

                if (!isPalindrome(subString)) {
                    answer = subString.length();
                    break;
                }

            }
        }

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
}