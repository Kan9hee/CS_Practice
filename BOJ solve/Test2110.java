import java.io.*;
import java.util.*;

public class Test2110 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] list;               //��ġ ����Ʈ
    static int size,router,result=0; //����Ʈ ũ��, ���� ����, �����

    static void getDistance(){
        int min=1;              
        int max=list[size-1];

        while(min<=max){            //�ּڰ��� �ִ��� �����ϱ� ������ �ݺ��Ѵ�.
            int mid=(max+min)/2;    //�� �ݺ����� �ִ밪�� �ּڰ��� �߰����� ���Ѵ�.

            if(check(mid)){         //�߰����� ������ ��� ���� ������ Ŀ�� ������ ���
                result=Math.max(result,mid);    //������� ���� ������� mid�� �� ū ������ �����Ѵ�.
                min=mid+1;          //�ּڰ��� mid+1�� �����Ѵ�.
            }else                   //Ŀ�� �Ұ����� ���
                max=mid-1;          //�ִ��� mid-1�� �����Ѵ�.
        }
    }

    static boolean check(int val){  //getDistance���� mid�� ���� Ȯ���ϴ� �޼ҵ�.
        int count=1;
        int index=0;

        for(int i=0;i<size-1;i++){
            if(list[index]+val<=list[i+1]){ //�߰����� index��° list���� ��ģ ���� i+1��° ����Ʈ ������ �۴ٴ� ����
                count++;                    //�� �߰����� ������ ������ �Ǵ���
                index=i+1;                  //count���� 1 �ø���, index���� i+1�� ����
            }
        }

        if(count>=router)   //count���� ������ �������� Ŭ ���, �׸�ŭ Ŀ���� �����ϴٴ� ������ �����Ѵ�.
            return true;
        else
            return false;
    }

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        size=Integer.parseInt(st.nextToken());
        router=Integer.parseInt(st.nextToken());
        
        list=new int[size];
        for(int i=0;i<size;i++)
            list[i]=Integer.parseInt(br.readLine());
        Arrays.sort(list);  //list�� �Է��� ��ġ�� ������������ �����Ѵ�.

        getDistance();
        System.out.println(result);
    }
}
