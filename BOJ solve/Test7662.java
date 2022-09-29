import java.util.*;
import java.io.*;

//�켱���� ť�� �̿��� �ذ��ϴ� ������.
//�׷��� java���� �����ϴ� PriorityQueue�� ����� ���
//�ð����⵵�� O(n)�̱� ������ ä���� �ð� �ʰ��� �ȴ�.
//���� �켱����ť�� ���� Ʈ���� ���� �����Ѵ�.

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