import java.io.*;
import java.util.*;

public class Test1041 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long result=0,size=0,dice[]=new long[7],set[]=new long[3];
    static void find(){
        set[0]=Math.min(dice[1],dice[6]);
        set[1]=Math.min(dice[2],dice[5]);
        set[2]=Math.min(dice[3],dice[4]);

        Arrays.sort(set);   //�߿�. �ֻ������� �� 3���� �� �߿��� ���� ���� �켱�� �Ǿ�� �Ѵ�.

        if(size==1){    //�ֻ����� 1���� ���� ���, �ִ��� ������ ������ ���� ��� ��ģ��.
            Arrays.sort(dice);
            for(int i=1;i<=5;i++)
                result+=dice[i];
            System.out.println(result);
        }
        else{
            long visibleCube=(long)Math.pow(size,2)*5;  //�ֻ����� ���� ������ü �� �ܺο� ���� �ֻ��� ���� ��
            long edge=((size-1)+(size-2))*4;    //�������� ������ �𼭸� ���� ��
            result=4*(set[0]+set[1]+set[2]) + edge*(set[0]+set[1]) + (visibleCube-(edge*2+12))*set[0];
            //�������� �巯���� �ֻ����� + �𼭸��� �巯���� �ֻ����� + ���� ���� �ֻ�����(�ּڰ�).
            System.out.println(result);
        }
    }

    public static void main(String[] args)throws IOException{
        size=Long.parseLong(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=6;i++)
            dice[i]=Long.parseLong(st.nextToken());

        find();
    }
}
