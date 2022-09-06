import java.io.*;
import java.util.*;
public class Test1935 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int unit=Integer.parseInt(br.readLine());
        char[] line=br.readLine().toCharArray();

        double stack[]=new double[line.length];
        int stacksize=-1;

        Map<Character,Integer>match=new HashMap<Character,Integer>();
        for(int i=0;i<unit;i++){
            match.put((char)('A'+i),Integer.parseInt(br.readLine()));
        }
        
        for(int i=0;i<line.length;i++){
            switch(line[i]){
                case'+':stack[stacksize-1]+=stack[stacksize--];break;
                case'-':stack[stacksize-1]-=stack[stacksize--];break;
                case'*':stack[stacksize-1]*=stack[stacksize--];break;
                case'/':stack[stacksize-1]/=stack[stacksize--];break;
                default:stack[++stacksize]=(double)match.get(line[i]);break;
            }
        }
        System.out.printf("%.2f",stack[0]);
    }
}
