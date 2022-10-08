import java.io.*;
import java.util.*;

public class Test11286 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    /*�켱���� ť�� �迭 ����� �������̵��Ͽ� ������ ����
     * ���� ���� ���� �켱������ �迭�ϰ� �Ѵ�.
    */
    static PriorityQueue<Integer>heap=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer q1,Integer q2){
            if(Math.abs(q1)==Math.abs(q2))
                return q1-q2;
            else
                return Math.abs(q1)-Math.abs(q2);
        }
    });

    public static void main(String[] args)throws IOException{
        int count=Integer.parseInt(br.readLine());

        for(int i=0;i<count;i++){
            int temp=Integer.parseInt(br.readLine());
            if(temp==0){
                if(heap.isEmpty())
                    sb.append(0+"\n");
                else
                    sb.append(heap.poll()+"\n");
            }
            else
                heap.add(temp);
        }

        System.out.println(sb);
    }
}
