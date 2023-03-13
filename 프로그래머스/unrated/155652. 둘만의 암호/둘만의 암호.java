import java.util.Set;
import java.util.HashSet;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuffer sb = new StringBuffer();
        Set<Character> set = new HashSet();
        
        for(char c : skip.toCharArray()){
            set.add(c);
        }
        
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length ; i++){
            char c = chars[i];
            int cnt = 0;
            
            while(cnt<index){
                c = (char)(c+1);
                
                if(c > 'z'){
                    c='a';
                    
                }
                if(set.contains(c)){
                    continue;
                }
                
                cnt++;
            }
            
            sb.append(c);
        }
        
        
        
        return sb.toString();
    }
}