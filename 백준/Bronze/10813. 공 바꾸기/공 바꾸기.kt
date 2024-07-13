import java.io.*
import java.util.StringTokenizer

fun main(){	
	val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var st = StringTokenizer(br.readLine())
    
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    
    var arr = IntArray(N){i->i+1}
    
    for(k in 1..M){
        st = StringTokenizer(br.readLine())
        
        val i = st.nextToken().toInt()-1
        val j = st.nextToken().toInt()-1
        if(i!=j){
            arr[i] = arr[i] xor arr[j]
        	arr[j] = arr[i] xor arr[j]
        	arr[i] = arr[i] xor arr[j]
        }
    }
    
    for(i in 0..arr.size-1){
        bw.write("${arr[i]} ")
    }
    
    bw.flush()
    bw.close()
}