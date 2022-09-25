//Test11724�� ������ ����
//���߹迭�� ���� dfs�� �����ؾ� �Ѵ�.
import java.io.*;
import java.util.*;

public class Test2606 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int com,link,temp1,temp2,result=0;
    static boolean order[][];
    static boolean check[];

    //������ com�� ��ȣ�� check�ϰ�(�����ϰ�),
    //�ش� com�� �̾��� com�� check�ϱ� ����
    //�̾��� com�� ��ȣ�� �������Ѵ�.
    private static void find(int temp){
        check[temp]=true;
        for(int i=1;i<=com;i++)
            if(order[temp][i]&&!check[i]){
                result++;
                find(i);
            }
    }

    public static void main(String[] args)throws IOException{
        com=Integer.parseInt(br.readLine());
        link=Integer.parseInt(br.readLine());
        order=new boolean[com+1][com+1];
        check=new boolean[com+1];

        //������ �� ������ ���� ���� �� �ִ� �������� �̾���
        //���� �迭���� �� ���� �ٲ� ��쵵 true�� �Ѵ�.
        for(int i=0;i<link;i++){
            st=new StringTokenizer(br.readLine());
            temp1=Integer.parseInt(st.nextToken());
            temp2=Integer.parseInt(st.nextToken());
            order[temp1][temp2]=order[temp2][temp1]=true;
        }

        find(1);
        System.out.println(result);
    }
}
