/*��������� ������������ �ּ� �̵� �Ÿ��� ���Ѵ�.
 * �ѹ� �̵��� ������ ���� �̵� �Ÿ��� 1��ŭ ���̰ų� ���� �� �ִ�.
 * ��, �ѹ��� ���� �Ÿ��� ���ų� ���� �� ������ ������ �̵��Ÿ��� 1�̾�� �Ѵ�.
*/
import java.io.*;
import java.util.*;

public class Test1011 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int test,start,end;
    
    public static void main(String[] args)throws IOException{
        test=Integer.parseInt(br.readLine());
        
        for(int i=0;i<test;i++){
            st=new StringTokenizer(br.readLine());
            start=Integer.parseInt(st.nextToken()); //�������
            end=Integer.parseInt(st.nextToken());   //��������
            int distance=end-start; //�Ÿ�
            int current=1,result=0; //���� �̵����� �Ÿ�, �� �̵� ȸ��
            while(distance>current*2){  //��������� ������������ ���ÿ� �̵��ϴ� ������
                distance-=current*2;    //�� �̵����� �Ÿ����� �ܿ� �Ÿ��� ���� ������ �ݺ��Ѵ�.
                result+=2;
                current++;
            }
            if(distance!=0){    //�ܿ� �Ÿ��� �̵����� �Ÿ��� ����� �̵� ȸ���� �߰��Ѵ�.
                if(distance<=current)
                    result++;
                else
                    result+=2;
            }
            System.out.println(result);
        }
    } 
}
