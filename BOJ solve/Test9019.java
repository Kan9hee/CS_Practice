import java.io.*;
import java.util.*;

public class Test9019 {
    static class Case{
        String order;
        int value;
        Case(String order,int value){
            this.order=order;
            this.value=value;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            String[] input=br.readLine().split("\\s+");
            int A=Integer.parseInt(input[0]);
            int B=Integer.parseInt(input[1]);

            Queue<Case> q=new LinkedList<>();
            boolean[] check=new boolean[10000];
            q.add(new Case("",A));
            check[A]=true;
            
            while(!q.isEmpty()){
                Case temp=q.poll();
                if(temp.value==B){
                    System.out.println(temp.order);
                    break;
                }
                
                int D=(temp.value*2)%10000;
                int S=(temp.value==0)?9999:temp.value-1;
                int L=(temp.value%1000)*10+temp.value/1000;
                int R=(temp.value%10)*1000+temp.value/10;

                if(!check[D]){
                    check[D]=true;
                    q.add(new Case(temp.order+"D",D));
                }
                if(!check[S]){
                    check[S]=true;
                    q.add(new Case(temp.order+"S",S));
                }
                if(!check[L]){
                    check[L]=true;
                    q.add(new Case(temp.order+"L",L));
                }
                if(!check[R]){
                    check[R]=true;
                    q.add(new Case(temp.order+"R",R));
                }
            }
        }
    }
}
