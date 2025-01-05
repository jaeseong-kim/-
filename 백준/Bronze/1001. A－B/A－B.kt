fun main(){
    val br = System.`in`.bufferedReader()
    val arr = br.readLine().split(" ").map(){it -> it.toInt()}
    
    val a = arr[0]
    val b = arr[1]
    
    print(a - b)
}