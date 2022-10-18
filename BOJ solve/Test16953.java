import java.io.*;
import java.util.*;

public class Test16953 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<long[]>q=new LinkedList<>();

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        long start=Integer.parseInt(st.nextToken());
        long end=Integer.parseInt(st.nextToken());
        long node[]={start,0};
        q.add(node);

        while(!q.isEmpty()){
            node=q.poll();
            long t1,t2;

            if(node[0]==end){
                System.out.println(node[1]+1);
                break;
            }
            else{
                if(node[0]*2<=end){
                    t1=node[0]*2;
                    t2=node[1]+1;
                    q.add(new long[]{t1,t2});
                }
                if((node[0]*10)+1<=end){
                    t1=(node[0]*10)+1;
                    t2=node[1]+1;
                    q.add(new long[]{t1,t2});
                }
            }
        }
        if(node[0]!=end)
            System.out.println(-1);
    }
}
