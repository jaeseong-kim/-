import java.io.*
import java.util.StringTokenizer

fun main(){
 	val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var st = StringTokenizer(br.readLine())
	val sb = StringBuffer()
    
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    
    var arr = IntArray(N)
    for(i in 1..M){
        st = StringTokenizer(br.readLine())
        
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        
        for(j in a..b){
            arr[j-1] = c
        }
    }
    

    for(i in 0..arr.size-1){
        bw.write("${arr[i]} ")
    }
    bw.flush()
    bw.close()
}