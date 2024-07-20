import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var arr = IntArray(26){i -> -1}
    
    val word = br.readLine()
   	for(i in word.indices){
        val idx = word[i].toChar()-'a'
        if(arr[idx]==-1){
			arr[idx] = i
        }
    }
    
    for(i in arr.indices){
        bw.write("${arr[i]} ")
    }
    
    bw.flush()
    bw.close()
}