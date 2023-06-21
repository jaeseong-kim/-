import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 로마 숫자 입력
        String roman1 = br.readLine();
        String roman2 = br.readLine();

        // 아라비아 숫자 구하기
        int arabic1 = convert(roman1);
        int arabic2 = convert(roman2);

        // 숫자 합 로마 숫자로 구하기
        String answer = convert(arabic1 + arabic2);

        // 출력
        System.out.println(arabic1 + arabic2);
        System.out.println(answer);
    }

    public static int convert(String romanNum) {

        int arabicNum = 0;
        for (int i = 0; i < romanNum.length(); i++) {
            char c = romanNum.charAt(i);

            if (c == 'M') {
                arabicNum += 1000;
            } else if (c == 'D') {
                arabicNum += 500;
            } else if (c == 'C') {
                if (i < romanNum.length() - 1) {
                    char nextC = romanNum.charAt(i + 1);
                    if (nextC == 'M') {
                        i++;
                        arabicNum += 900;
                    } else if (nextC == 'D') {
                        i++;
                        arabicNum += 400;
                    } else {
                        arabicNum += 100;
                    }
                } else {
                    arabicNum += 100;
                }

            } else if (c == 'L') {
                arabicNum += 50;
            } else if (c == 'X') {
                if (i < romanNum.length() - 1) {
                    char nextC = romanNum.charAt(i + 1);
                    if (nextC == 'C') {
                        i++;
                        arabicNum += 90;
                    } else if (nextC == 'L') {
                        i++;
                        arabicNum += 40;
                    } else {
                        arabicNum += 10;
                    }
                } else {
                    arabicNum += 10;
                }

            } else if (c == 'V') {
                arabicNum += 5;
            } else {
                if (i < romanNum.length() - 1) {
                    char nextC = romanNum.charAt(i + 1);
                    if (nextC == 'X') {
                        i++;
                        arabicNum += 9;
                    } else if (nextC == 'V') {
                        i++;
                        arabicNum += 4;
                    } else {
                        arabicNum += 1;
                    }
                } else {
                    arabicNum += 1;
                }

            }
        }
        return arabicNum;
    }

    public static String convert(int arabicNum) {

        StringBuffer sb = new StringBuffer();
        int v = 0, l = 0, d = 0, i = 0, x = 0, c = 0, m = 0;

        while (arabicNum > 0) {
            if (arabicNum >= 3000) {
                sb.append("MMM");
                arabicNum -= 3000;
            } else if (arabicNum >= 1000) {
                sb.append("M");
                arabicNum -= 1000;
            } else if (arabicNum >= 900) {
                sb.append("CM");
                arabicNum -= 900;
            } else if (arabicNum >= 500 && d == 0) {
                sb.append("D");
                arabicNum -= 500;
                d += 1;
            } else if (arabicNum >= 400 && d == 0) {
                sb.append("CD");
                arabicNum -= 400;
                d += 1;
            } else if (arabicNum >= 300) {
                sb.append("CCC");
                arabicNum -= 300;
            } else if (arabicNum >= 100) {
                sb.append("C");
                arabicNum -= 100;
            } else if (arabicNum >= 90) {
                sb.append("XC");
                arabicNum -= 90;
            } else if (arabicNum >= 50 && l == 0) {
                sb.append("L");
                arabicNum -= 50;
                l += 1;
            } else if (arabicNum >= 40 && l == 0) {
                sb.append("XL");
                arabicNum -= 40;
                l += 1;
            } else if (arabicNum >= 30) {
                sb.append("XXX");
                arabicNum -= 30;
            } else if (arabicNum >= 10) {
                sb.append("X");
                arabicNum -= 10;
            } else if (arabicNum >= 9) {
                sb.append("IX");
                arabicNum -= 9;
            } else if (arabicNum >= 5 && v == 0) {
                sb.append("V");
                arabicNum -= 5;
                v += 1;
            } else if (arabicNum >= 4 && v == 0) {
                sb.append("IV");
                arabicNum -= 4;
                v += 1;
            } else {
                sb.append("I");
                arabicNum -= 1;
            }
        }

        return sb.toString();
    }
}