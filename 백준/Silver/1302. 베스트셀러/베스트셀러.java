import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 책 개수 입력
        int N = Integer.parseInt(br.readLine());

        String[] books = new String[N];
        int[] soldCnt = new int[N];
        
        // 책 입력
        for (int i = 0; i < N; i++) {
            String book = br.readLine();

            for (int j = 0; j < N; j++) {
                if (books[j] == null) {
                    books[j] = book;
                    soldCnt[j] += 1;
                    break;
                } else if (books[j].equals(book)) {
                    soldCnt[j] += 1;
                    break;
                }
            }
        }

        // 최대로 팔린 책 구하기
        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, soldCnt[i]);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (soldCnt[i] == max) {
                list.add(books[i]);
            }
        }
        
        // 사전 순 정렬
        Collections.sort(list);
        
        // 출력
        System.out.println(list.get(0));
    }
}