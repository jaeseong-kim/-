import java.io.BufferedReader
import java.io.InputStreamReader


fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
	
    val X = br.readLine().toInt()
    
    val N = br.readLine().toInt()
    
    var amount = 0
    for(i in 1.. N){
        var item = br.readLine().split(" ")
        amount += item[0].toInt()*item[1].toInt()
    }
    
    if(amount == X){
        print("Yes")
    }else{
        print("No")
    }
    
}