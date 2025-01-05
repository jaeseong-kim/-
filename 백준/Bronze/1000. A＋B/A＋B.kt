fun main(){
    val br = System.`in`.bufferedReader()
    val arr = br.readLine().split(" ").map{it -> it.toInt()}
    
    print(arr[0]+arr[1])
}