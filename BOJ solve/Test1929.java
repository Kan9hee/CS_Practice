import java.io.*;
import java.util.*;
public class Test1929 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());
        boolean list[]=new boolean[end+1];

        list[0]=list[1]=true;
        for(int i=2; i*i<=end; i++){
            if(!list[i]){
            	for(int j=i+i; j<=end; j+=i)
                    list[j]=true;                
            }        
        }

        for(int i=start;i<=end;i++){
            if(!list[i])
                sb.append(i+"\n");
        }

        System.out.println(sb);
    }
}
