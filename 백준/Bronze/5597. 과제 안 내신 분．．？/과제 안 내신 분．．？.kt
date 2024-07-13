import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    
	var arr = IntArray(30){i -> i+1}
    for(i in 1..28){
        val idx = br.readLine().toInt()-1
        
        arr[idx] = 0
    }
    
    for(i in 0..29){
        if(arr[i]!=0){
            bw.write("${arr[i]}\n")
        }
    }
    bw.flush()
    bw.close()
}