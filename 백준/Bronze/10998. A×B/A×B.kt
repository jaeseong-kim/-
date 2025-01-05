fun main(){
    val br = System.`in`.bufferedReader()
    val inputs = br.readLine().split(" ").map{it -> it.toInt()}
    
    val a = inputs[0]
    val b = inputs[1]
    
    print(a*b)
}