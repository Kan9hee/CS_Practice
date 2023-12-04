import java.io.*;

public class Test14916 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int result=0;
        int n=Integer.parseInt(br.readLine());

        if(n<=2){
            System.out.println(n/2==0?-1:n/2);
            return;
        }

        int re=n%5;
        if(re==2||re==4)
            result=(n/5)+(re/2);
        else if(re==1||re==3)
            if(n>=9)
                result=(n/5)-1+(re+5)/2;
            else
                result=(n/5)-1+(n/2);
        else
            result=n/5;

        System.out.println(result==0?-1:result);
    }
}
