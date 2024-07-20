import java.io.*
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val st = StringTokenizer(br.readLine())
    bw.write("${st.countTokens()}")
    bw.flush()
    bw.close()
}