//�ϳ����� ž ����
//3���� ����� ��ȯ�ϸ� �־��� ������ ������ ����Ѵ�.
//���� ū ������ 1�� ��տ� ����, n-1���� ����� 2�� ��տ� ���� ������
//2���� 3�� ����� �ٲ㰡�� ���ȣ���Ѵ�.
//1�� ��տ� �ִ� ������ 3�� ������� �ű��, ������ ������ 3�� ��տ� �׵���
//1���� 2�� ����� �ٲ㰡�� ���ȣ���Ѵ�.
//���������� ���� ��ȸ�� ����� ����� ���.
import java.util.*;

public class Test11729 {
    static Scanner sc=new Scanner(System.in);
    static StringBuilder sb=new StringBuilder();
    static int count=0;
    static void hanoi(int n,char a,char b,char c){
        count++;
        if(n==1)
            sb.append(a+" "+c+"\n");
        else{
            hanoi(n-1,a,c,b);
            sb.append(a+" "+c+"\n");
            hanoi(n-1,b,a,c);
        }
    }

    public static void main(String[] args){
        int round=sc.nextInt();
        hanoi(round,'1','2','3');
        System.out.println(count);
        System.out.println(sb);
    }
}
