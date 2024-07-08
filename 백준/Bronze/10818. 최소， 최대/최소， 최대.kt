import java.io.*
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    
    val N = br.readLine().toInt()
    
    val st = StringTokenizer(br.readLine())
    var min = 1000001
    var max = -1000001
    var num = 0
    for(i in 1..N){
        num = st.nextToken().toInt()

        if(num < min){
            min = num
        }
        
        if(num > max){
            max = num
        }
    }
    
    bw.write("${min} ${max}\n")
    bw.flush()
    bw.close()
}