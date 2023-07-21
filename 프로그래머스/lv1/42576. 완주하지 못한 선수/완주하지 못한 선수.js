function solution(participant, completion) {
    var answer = '';
    
    var map = new Map();
    
    // 참가자 입력
    for(var i = 0; i < participant.length; i++){
        if(map.has(participant[i])){
            map.set(participant[i],map.get(participant[i])+1);            
        }else{
            map.set(participant[i],1);
        }
    }
    
    // 완주자 제거
    for(var i = 0; i < completion.length; i++){
        map.set(completion[i],map.get(completion[i])-1);
    }
    
    
    for(var name of map.keys()){
        if(map.get(name)===1){
            answer = name;
            break;
        }
    }
        
    
    return answer;
}