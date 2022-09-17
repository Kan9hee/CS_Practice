import java.io.*;
import java.util.*;
public class Test11279 {
    public static void main(String[]args)throws IOException{
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(br.readLine());
        int input;
        for(int i=0;i<count;i++){
            input=Integer.parseInt(br.readLine());
            if(input==0){
                if(pq.peek()==null)
                    System.out.println(0);
                    System.out.println(pq.poll());
            }else{
                pq.add(input);
            }
        }
    }
}
