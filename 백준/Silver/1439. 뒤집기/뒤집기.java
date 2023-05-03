import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] nums = br.readLine().toCharArray();

        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            char c = nums[i];

            if (c != nums[i + 1]) {
                cnt++;
            }
        }

        if (nums[0] != nums[nums.length - 1]) {
            System.out.println((cnt / 2) + 1);
        } else {
            System.out.println(cnt / 2);
        }
    }
}