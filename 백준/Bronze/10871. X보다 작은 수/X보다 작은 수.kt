import java.io.*
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var st = StringTokenizer(br.readLine())
    
    val N = st.nextToken().toInt()
    val X = st.nextToken().toInt()
    
    st = StringTokenizer(br.readLine())
    val sb = StringBuffer()
    var num = 0
    for(i in 1..N){
        num = st.nextToken().toInt()
        if(num < X){
            sb.append(num).append(" ")
        }
    }
	
    bw.write("${sb}")
    bw.flush()
    bw.close()
}