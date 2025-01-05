fun main(){
    //첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.
    val sb = StringBuffer()
    val br = System.`in`.bufferedReader()
    val inputs = br.readLine().split(" ").map{it -> it.toInt()}
    
    val a = inputs[0]
    val b = inputs[1]
    
    sb.append(a+b)
      .append("\n")
      .append(a-b)
      .append("\n")
      .append(a*b)
      .append("\n")
      .append(a/b)
      .append("\n")
      .append(a%b)
    
    print(sb)
}