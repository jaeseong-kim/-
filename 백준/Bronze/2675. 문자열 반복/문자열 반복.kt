import java.io.*
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    
    val T = br.readLine().toInt()
    var sb = StringBuffer()
    for(i in 1..T){
        val st = StringTokenizer(br.readLine())
        val R = st.nextToken().toInt()
        val S = st.nextToken()
         
        for(j in 0..S.length-1){
			for(k in 1..R){
                sb.append(S[j])
            }
        }   
        sb.append("\n")
    }
    
    bw.write("${sb.toString()}")
    bw.flush()
    bw.close()
}