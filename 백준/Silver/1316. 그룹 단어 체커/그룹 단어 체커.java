import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        while (N > 0) {
            char[] chars = br.readLine().toCharArray();
            Set<Character> set = new HashSet<>();

            // 초기화
            char prevChar = chars[0];
            set.add(chars[0]);
            boolean isGroupWord = true;

            // 그룹 단어 체크
            for (int i = 1; i < chars.length; i++) {
                Character c = chars[i];

                if (set.contains(c) && prevChar != c) {
                    isGroupWord = false;
                    break;
                }

                set.add(c);
                prevChar = c;
            }
            
            // 그룹단어일 때
            if (isGroupWord) {
                answer = answer + 1;
            }

            N--;
        }
        
        // 출력
        System.out.println(answer);
    }
}