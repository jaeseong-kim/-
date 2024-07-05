import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    
    val X = br.readLine().toInt()
    val N = br.readLine().toInt()
    
    var sum = 0
    for(i in 1..N){
        var item = br.readLine().split(" ")
        
        val price =  item[0].toInt()
        val amount = item[1].toInt()
        
        sum+=price*amount
    }
    
    var answer = ""
    if(X == sum){
        answer = "Yes"
    }else{
        answer = "No"
    }
    print(answer)
}