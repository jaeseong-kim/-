import java.io.*
import java.util.StringTokenizer

fun main(){
	val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val N = br.readLine().toInt()
    
    for(i in 1..N){
        for(j in 1..N-i){
            bw.write(" ")
        }
        for(j in 1..i){
            bw.write("*")
        }
        bw.write("\n")
    }
    bw.flush()
}