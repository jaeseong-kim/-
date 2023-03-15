import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet();
        int num = nums.length/2;
        
        //총 종류의 개수 구하기
        for(int i : nums){
            if(!set.contains(i)){
                set.add(i);
            }
        }
        
        //종류의 개수 구하기
        //종류의 개수가 내가 가져갈 수 보다 많으면 -> 내가 가져갈 수가 답
        //종류의 개수보다 내가 가져갈 수가 많으면 -> 종류의 개수가 답
        return num < set.size() ? num : set.size();
    }
}