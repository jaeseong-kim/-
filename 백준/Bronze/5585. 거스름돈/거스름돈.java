import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        long change = 1000L - Long.parseLong(br.readLine());
        long cnt = 0;

        // 500
        while (change >= 500) {
            change -= 500;
            cnt++;
        }

        // 100
        while (change >= 100) {
            change -= 100;
            cnt++;
        }

        // 50
        while (change >= 50) {
            change -= 50;
            cnt++;
        }

        // 10
        while (change >= 10) {
            change -= 10;
            cnt++;
        }

        // 5
        while (change >= 5) {
            change -= 5;
            cnt++;
        }

        // 1
        while (change >= 1) {
            change -= 1;
            cnt++;
        }

        // 출력
        System.out.println(cnt);
    }
}