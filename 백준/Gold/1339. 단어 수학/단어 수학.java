import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        int[] alphabets = new int[26];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < arr.length; i++) {
            int val = (int) Math.pow(10, arr[i].length() - 1);
            for (int j = 0; j < arr[i].length(); j++) {
                alphabets[arr[i].charAt(j) - 'A'] += val;
                val /= 10;
            }
        }

        // 오름차순 정렬
        sort(alphabets);


        int num = 9;

        int answer = 0;
        for (int i = 0; i < alphabets.length; i++) {

            if (alphabets[i] == 0) {
                break;
            }

            answer += alphabets[i] * num;
            num--;
        }

        System.out.println(answer);
    }

    public static void sort(int[] arr){

        for (int i = 0; i < arr.length; i++) {

            int max = -1;
            int idx = -1;
            for (int j = i; j < arr.length; j++) {

                if(max < arr[j]){
                    max = arr[j];
                    idx = j;
                }
            }

            int tmp = arr[i];
            arr[i] = max;
            arr[idx] = tmp;

        }
    }
}