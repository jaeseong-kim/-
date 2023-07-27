import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList();
        Queue<Integer> pq = new PriorityQueue(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        
        // 큐에 프로세스 넣기
        for(int i = 0; i < priorities.length; i++){
            int[] arr = new int[2];
            arr[0] = i;
            arr[1] = priorities[i];
            
            queue.add(arr);
        }
        
        // 우선순위 큐에 순위 넣기
        for(int i = 0; i < priorities.length; i++){
            pq.add(priorities[i]);
        }
        
        // 실행 순서가 궁금한 프로세스
        int[] myArr = {location, priorities[location]};
        
        int priority = pq.poll();
        int answer = 0;
        //System.out.println("myArr[0] = "+myArr[0]+", myArr[1] = "+myArr[1]);
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            //System.out.println("arr[0] = "+arr[0]+", arr[1] = "+arr[1]);
            //System.out.println("priority = " + priority+", answer = "+answer);
            
            if(arr[1] == priority){
                answer += 1;
                if(!pq.isEmpty()){
                    priority = pq.poll();
                }
            }else{
                queue.add(arr);
                continue;
            }
            
            if(sameArr(myArr,arr)){
                break;
            }
            
        }

        return answer;
    }
    
    public boolean sameArr(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length){
            return false;
        }
        
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        
        return true;
    }
}