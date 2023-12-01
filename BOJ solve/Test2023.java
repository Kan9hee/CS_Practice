import java.io.*;
import java.util.*;

public class Test2023 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        Queue<Integer>q=new LinkedList<>();
        q.add(2);
        q.add(3);
        for(int i=4;i<=9;i++)
            if(i%2!=0&&i%3!=0)
                q.add(i);

        while(!q.isEmpty()){
            int temp=q.poll();

            if((int)Math.log10(temp)+1==n){
                System.out.println(temp);
                continue;
            }

            temp*=10;
            for(int i=1;i<=9;i++){
                boolean check=true;
                int next=temp+i;
                for(int t=2;t<=Math.sqrt(next);t++)
                    if(next%t==0){
                        check=false;
                        break;
                    }
                if(check)
                    q.add(next);
            }
        }
    }
}
