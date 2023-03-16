class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();
        int[] nums = new int[3];
        int idx = 0;


        for (int i = 0; i < dartResult.length(); i++) {

            char c = dartResult.charAt(i);

            if ('0' <= c && c <= '9') {
                sb.append(c);
            } else if (c == 'S' || c == 'D' || c == 'T') {
                int num = Integer.parseInt(sb.toString());
                if (c == 'S') {
                    nums[idx] = num*1;
                } else if (c == 'D') {
                    nums[idx] = num*num;
                } else {
                    nums[idx] = num*num*num;
                    ;
                }
                idx++;
                sb = new StringBuffer();
            } else {

                if (c == '*') {
                    nums[idx - 1] *= 2;
                    if (idx - 2 >= 0) {
                        nums[idx - 2] *= 2;
                    }
                } else {
                    nums[idx - 1] *= -1;
                }
            }

        }

        for (int n : nums) {
            System.out.print(n+" ");
            answer += n;
        }

        return answer;
    }
}