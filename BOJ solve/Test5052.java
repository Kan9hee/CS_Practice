import java.io.*;
import java.util.*;

public class Test5052 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static String list[];   //���� �迭 ����Ʈ
    static int repeat,count;    //�׽�Ʈ���̽�, ���� �迭 ��

    static void check(){    //���ξ� �׽�Ʈ
        for(int i=0;i<count-1;i++)
            if(list[i+1].startsWith(list[i])){  //i��° ���� �迭�� �׺��� ū ���� �迭�� �Ϻ��� ���
                System.out.println("NO");   //NO�� ����ϰ� �޼ҵ带 �����Ѵ�.
                return;
            }
        System.out.println("YES");  //��� ���� �迭�� �ٸ� ���� �迭�� �Ϻΰ� �ƴ� ���, YES�� ����Ѵ�.
    }

    public static void main(String[]args)throws IOException{
        repeat=Integer.parseInt(br.readLine()); //�׽�Ʈ Ƚ�� �Է�
        for(int i=0;i<repeat;i++){
            count=Integer.parseInt(br.readLine());  //���� �迭 ���� �Է�
            list=new String[count];
            for(int t=0;t<count;t++)
                list[t]=new String(br.readLine());
            Arrays.sort(list);  //�Էµ� ���� �迭���� ������������ �����Ѵ�.
            check();
        }
    }
}
