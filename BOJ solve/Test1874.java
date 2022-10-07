import java.io.*;
import java.util.*;

public class Test1874 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb=new StringBuilder();
    static Stack<Integer>stack=new Stack<>();

    public static void main(String[]args)throws IOException{
        int size=Integer.parseInt(br.readLine()),point=0;
        stack.push(0);
        
        for(int i=0;i<size;i++){
            int temp=Integer.parseInt(br.readLine());
            if(temp>point){
                for(int t=point+1;t<=temp;t++){
                    stack.push(t);
                    sb.append("+\n");
                }
                point=temp;
            }
            else if(stack.peek()!=temp){
                sb=new StringBuilder();
                sb.append("NO\n");
                break;
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}
