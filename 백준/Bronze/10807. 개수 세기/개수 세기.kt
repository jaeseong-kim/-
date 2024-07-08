import java.io.*
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    
    val N = br.readLine().toInt()
    val arr = IntArray(N)
    val st = StringTokenizer(br.readLine())
    
    
    for(i in 0..N-1){
    	arr[i] = st.nextToken().toInt()
    }
    
    val V = br.readLine().toInt()
    
    var cnt = 0
    for(i in 0..N-1){
        if(V == arr[i]){
            cnt+=1
        }
    }
    
    bw.write("${cnt}\n")
    bw.flush()
    bw.close()
}