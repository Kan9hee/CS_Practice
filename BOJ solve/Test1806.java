import java.io.*;
import java.util.*;
 
public class Test1806 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int size,target,list[],start,end,min;

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());    //�迭�� ũ��
        target = Integer.parseInt(st.nextToken());  //�κ��� ��� ����
        list = new int[size+1]; //���� �迭���� 1��ŭ �� ũ�� ����� �������� �����ڷ� ���� �迭�� ������ ����� ��츦 ����Ѵ�.
        min = size+1;           //�ּ� ���� Ƚ��
        start = end = 0;        //������,���� ��ġ

        st=new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++)
            list[i] = Integer.parseInt(st.nextToken());
        
        int total = 0;  //���� �κ���
        while(start <= size && end <= size) {   //�������� ������ �迭 ũ�� �ε������� Ŭ ������ �ݺ��Ѵ�.
            if(total >= target && min > end - start)
                min = end - start;  //���� �κ����� ������ ����� �� �ּ� ���� Ƚ���� �ּ�ġ�� �ʱ�ȭ�Ѵ�.
            if(total < target)
                total += list[end++];   //������ ��ġ�� �̵��ϸ� ���� �κ��տ� �迭 �ε����� ������ ���� ���Ѵ�.
            else
                total -= list[start++]; //�������� ��ġ�� �̵��ϸ� ���� �κ����� ��� ���غ��� �۵��� ����.
        }
        
        if(min == size+1)
            System.out.println(0);  //���� �ּ� ���� ȸ���� ������ ���� ���, ������ ����ϴ� ��찡 ���� ������ �Ǵ��Ѵ�.
        else
            System.out.println(min);
    }
}