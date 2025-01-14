fun main(){
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    
    for(i in 1..9){
        println("${N} * ${i} = ${N*i}")
    }
}