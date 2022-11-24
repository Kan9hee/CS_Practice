import java.io.*;
import java.util.*;

public class Test2470 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int acid,alkali,min,size,list[];

    static void find(int start,int end){    //�־��� ���� �� 2���� ���� ���� 0�� ������ �� �� ã��
        while(start<end){                   //�迭�� �� ���� ����Ű�� �� �����Ͱ� ������ ������ �ݺ��Ѵ�.
            int temp=list[start]+list[end];
            if(Math.abs(temp)<min){         //���� ���� �ݺ����� 0�� ���� ������ ���� ���� ���,
                min=Math.abs(temp);         //�ּڰ��� �ش� ������ �ʱ�ȭ�ϰ�
                acid=list[start];           //��ġ�� �� ���� �� ���� �����Ѵ�.
                alkali=list[end];
            }
            if(temp>0)                      //���� �� ���� ������ �迭 ������ �����͸� �������� 1ĭ �̵���Ű��
                end--;
            else                            //�� ���� ������� �迭 ������ �����͸� �������� 1ĭ �̵���Ų��.
                start++;
        }
    }

    public static void main(String[] args)throws IOException{
        size=Integer.parseInt(br.readLine());
        list=new int[size];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++)
            list[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(list);      //�Էµ� ������ ������������ �����Ͽ� ���� ã�� ���� �Ѵ�.
        min=Integer.MAX_VALUE;  

        find(0,size-1);
        System.out.println(acid+" "+alkali);    //������ �� ���� ����Ѵ�.
    }   
}
