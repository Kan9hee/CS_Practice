/*출발점부터 도착점까지의 최소 이동 거리를 구한다.
 * 한번 이동할 때마다 다음 이동 거리를 1만큼 늘이거나 줄일 수 있다.
 * 단, 한번에 많은 거리를 가거나 줄일 순 없으며 도착시 이동거리는 1이어야 한다.
*/
import java.io.*;
import java.util.*;

public class Test1011 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int test,start,end;
    
    public static void main(String[] args)throws IOException{
        test=Integer.parseInt(br.readLine());
        
        for(int i=0;i<test;i++){
            st=new StringTokenizer(br.readLine());
            start=Integer.parseInt(st.nextToken()); //출발지점
            end=Integer.parseInt(st.nextToken());   //도착지점
            int distance=end-start; //거리
            int current=1,result=0; //현재 이동가능 거리, 총 이동 회수
            while(distance>current*2){  //출발지점과 도착지점에서 동시에 이동하는 것으로
                distance-=current*2;    //두 이동가능 거리보다 잔여 거리가 낮을 때까지 반복한다.
                result+=2;
                current++;
            }
            if(distance!=0){    //잔여 거리와 이동가능 거리를 비례해 이동 회수를 추가한다.
                if(distance<=current)
                    result++;
                else
                    result+=2;
            }
            System.out.println(result);
        }
    } 
}
