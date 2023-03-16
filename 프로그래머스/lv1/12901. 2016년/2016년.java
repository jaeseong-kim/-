import java.time.LocalDate;


class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        LocalDate date = LocalDate.of(2016,a,b);
        
        switch(date.getDayOfWeek().getValue()){
            case 1:
                answer = "MON";
                break;
            case 2:
                answer = "TUE";
                break;
            case 3:
                answer = "WED";
                break;
            case 4:
                answer = "THU";
                break;
            case 5:
                answer = "FRI";
                break;
            case 6:
                answer = "SAT";
                break;
            case 7:
                answer = "SUN";
                break;
        }
        
        return answer;
    }
}