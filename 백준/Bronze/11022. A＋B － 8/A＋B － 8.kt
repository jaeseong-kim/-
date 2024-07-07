import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    var st:StringTokenizer
    val sb = StringBuffer()
    var a = 0
    var b = 0
    
    for(i in 1..T){
        st = StringTokenizer(br.readLine())
        a = st.nextToken().toInt()
        b = st.nextToken().toInt()
        
        sb.append("Case #${i}: ${a} + ${b} = ${a+b}\n")
    }
    
    print(sb)
}