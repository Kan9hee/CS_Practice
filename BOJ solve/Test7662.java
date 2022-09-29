import java.util.*;
import java.io.*;

//우선순위 큐를 이용해 해결하는 문제다.
//그러나 java에서 제공하는 PriorityQueue를 사용할 경우
//시간복잡도가 O(n)이기 때문에 채점시 시간 초과가 된다.
//따라서 우선순위큐를 이진 트리를 통해 구현한다.

public class Test7662 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static StringTokenizer st;
    static TreeMap<Integer,Integer>pq;
    static String order;
    static int test,step,val;

    public static void main(String[] args)throws IOException{
        test=Integer.parseInt(br.readLine());
        for(int t=0;t<test;t++){
            pq=new TreeMap<>();
            sb=new StringBuilder();
            step=Integer.parseInt(br.readLine());

            for(int i=0;i<step;i++){
                st=new StringTokenizer(br.readLine());
                order=st.nextToken();
                val=Integer.parseInt(st.nextToken());

                if(order.equals("I"))
                    pq.put(val, pq.getOrDefault(val, 0)+1);
                if(order.equals("D")&&!pq.isEmpty()){
                    if(val==-1){
                        int target=pq.firstKey();
                        if(pq.get(target)==1)
                            pq.remove(target);
                        else
                            pq.put(target,pq.get(target)-1);
                        }else{ 
                            int target=pq.lastKey();
                            if(pq.get(target)==1)
                                pq.remove(target);
                            else
                                pq.put(target,pq.get(target)-1);
                    }
                }
            }
            
            if(pq.isEmpty())
                sb.append("EMPTY");
            else
                sb.append(pq.lastKey()+" "+pq.firstKey());
            System.out.println(sb.toString());
        }
    }
}