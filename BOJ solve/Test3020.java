import java.io.*;
public class Test3020{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split("\\s+");

        int[] caveBottom=new int[Integer.parseInt(input[1])+1];
        int[] caveTop=new int[Integer.parseInt(input[1])+1];

        for(int i=0;i<Integer.parseInt(input[0]);i++){
            int temp=Integer.parseInt(br.readLine());
            if(i%2==0)
                caveBottom[temp]++;
            else
                caveTop[temp]++;
        }

        for(int i=Integer.parseInt(input[1])-1;i>0;i--){
            caveBottom[i]+=caveBottom[i+1];
            caveTop[i]+=caveTop[i+1];
        }

        int min=Integer.MAX_VALUE, count=0;
        for(int i=1;i<=Integer.parseInt(input[1]);i++){
            int total=caveBottom[i]+caveTop[Integer.parseInt(input[1])-i+1];
            if(min>total){
                min=total;
                count=1;
            }
            else if(min==total)
                count++;
        }
        
        System.out.printf(min+" "+count);
    }
}