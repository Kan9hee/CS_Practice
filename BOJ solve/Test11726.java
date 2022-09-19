import java.io.*;

public class Test11726 {
    public static void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int width=Integer.parseInt(br.readLine());

       //���丮���� �̿��� �ذ�
        /*int sum=1,before=0,temp;

        for(int i=0;i<width;i++){
            temp=sum;
            sum+=before;
            sum%=10007;
            before=temp;
        }

        System.out.println(sum);*/

        //���� ���� ������ ���丮�� �ڵ�
        int factorial[]=new int[width+1];
        factorial[0]=1;
        factorial[1]=1;

        for(int i=2;i<=width;i++){
            factorial[i]=(factorial[i-1]+factorial[i-2])%10007;
        }

        System.out.println(factorial[width]);
    }
}
