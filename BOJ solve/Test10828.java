import java.io.*;
import java.util.*;

public class Test10828 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Stack<Integer>stack=new Stack<>();

    public static void main(String[]args)throws IOException{
        int work=Integer.parseInt(br.readLine());
        int temp;

        for(int i=0;i<work;i++){
            st=new StringTokenizer(br.readLine());
            String order=st.nextToken();
            switch(order){
                case "push":stack.push(Integer.parseInt(st.nextToken()));break;
                case "pop":
                    if(stack.isEmpty())
                        temp=-1;
                    else
                        temp=stack.pop();
                    System.out.println(temp);
                break;
                case "size":System.out.println(stack.size());break;
                case "empty":System.out.println((stack.isEmpty())?1:0);break;
                case "top":
                    if(stack.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(stack.peek());
                    break;
            }
        }
    }
}