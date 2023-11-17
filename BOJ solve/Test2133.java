import java.io.*;

public class Test2133 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int beforeResults=0;
        int answer=0;

        int n=Integer.parseInt(br.readLine());
        if(n%2==0){
            int listMax=Math.max(n/2,2);
            int[] list=new int[listMax];
            list[0]=3;
            list[1]=11;

            for(int i=2;i<listMax;i++){
                beforeResults+=list[i-2]*2;
                list[i]=list[i-1]*3+beforeResults+2;
            }
            answer=list[(n/2)-1];
        }

        System.out.println(answer);
    }
}
