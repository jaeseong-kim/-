import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int COUNT_OF_COURSES = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        float sumOfCoursesGrade = 0.0f;
        float sumOfCredits = 0.0f;
        for (int i = 0; i < COUNT_OF_COURSES; i++) {
            String[] str = br.readLine().split(" ");
            if(str[2].equals("P")){
                continue;
            }
            float credit = Float.parseFloat(str[1]);
            float gradePoint = getGradePoint(str[2]);

            sumOfCoursesGrade = (credit * gradePoint) + sumOfCoursesGrade;
            sumOfCredits = sumOfCredits + credit;
        }

        float gpa = sumOfCoursesGrade / sumOfCredits;
        System.out.println(gpa);

    }

    private static float getGradePoint(String grade) {

        switch (grade) {
            case "A+":
                return 4.5f;
            case "A0":
                return 4.0f;
            case "B+":
                return 3.5f;
            case "B0":
                return 3.0f;
            case "C+":
                return 2.5f;
            case "C0":
                return 2.0f;
            case "D+":
                return 1.5f;
            case "D0":
                return 1.0f;
            case "F":
                return 0.0f;
        }

        return -1.0f;
    }
}