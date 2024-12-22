fun main(){
    
    val br = System.`in`.bufferedReader()
    val input = br.readLine()
    val tmp = input.split(" ")
    
    val a = tmp[0].toInt()
    val b = tmp[1].toInt()
    val answer = when{
        a-b > 0 -> ">"
        a-b < 0 -> "<"
        else -> "=="
    }
    
    print("$answer")
}