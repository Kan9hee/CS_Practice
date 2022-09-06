import java.io.*;
import java.util.*;
public class Test1927 {
    public static void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int inputcount=Integer.parseInt(br.readLine());
        PriorityQueue<Integer>result=new PriorityQueue<>(Comparator.comparingInt(x->x));
        for(int i=0;i<inputcount;i++){
            int temp=Integer.parseInt(br.readLine());
            if(temp==0){
                if(result.isEmpty())
                    System.out.println(0);
                else{
                    System.out.println(result.poll());
                }
            }
            else{
                result.add(temp);
            }
        }
    }
}
