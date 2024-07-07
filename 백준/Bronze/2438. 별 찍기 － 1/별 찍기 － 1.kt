import java.io.*
import java.util.StringTokenizer

fun main(){
	val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val N = br.readLine().toInt()
    val sb = StringBuffer()
    
    for(i in 1..N){
        for(j in 1..i){
            sb.append("*")
        }
        sb.append("\n")
    }
    
    bw.write(sb.toString())
    bw.flush()
    bw.close()
}