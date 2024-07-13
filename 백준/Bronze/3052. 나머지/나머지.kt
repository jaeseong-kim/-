import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var arr = IntArray(42)
    
    for(i in 1..10){
    	var mod = br.readLine().toInt() % 42
        arr[mod]+=1
    }
    
    var count = 0
    for(i in arr.indices){
        if(arr[i]!=0){
            count+=1
        }
    }
    print("$count")	
}