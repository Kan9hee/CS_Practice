import java.io.*;
import java.util.*;

//�޸� ���� 4MB!!//

public class Test2293{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int kind,limit,list[],cases[];   //���� ����, ��ǥ��, ���� ����, ���� ������ ���� ����� ��

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        kind=Integer.parseInt(st.nextToken());
        limit=Integer.parseInt(st.nextToken());

        list=new int[kind];
        cases=new int[limit+1];
        for(int i=0;i<kind;i++)
            list[i]=Integer.parseInt(br.readLine());
        
        Arrays.sort(list);  //�Է¹��� �������� ������������ ����
        cases[0]=1; //1��° ���� ������ 1���� �����.

        for(int i=0;i<kind;i++) //���� ��������
            for(int t=1;t<=limit;t++)   //������ ���� ��츦 ����
                if(t>=list[i])  //��� ������ ���� ������ ���� ����ϴ� ���� ������ ������ Ŭ ���
                    cases[t]+=cases[t-list[i]]; //�ش� ����� ���� ����

        System.out.println(cases[limit]);   //cases[limit]�� ���� ���������� ������ ����� ��
    }
}