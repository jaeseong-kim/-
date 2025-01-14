fun main(){
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    
    for(i in 1..N){
        val inputs = br.readLine().split(" ").map{it -> it.toInt()}
        val a = inputs[0]
        val b = inputs[1]
        println(a+b)
    }
}