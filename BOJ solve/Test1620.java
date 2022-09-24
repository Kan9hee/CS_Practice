import java.io.*;
import java.util.*;

public class Test1620{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String,Integer>Hoenn=new HashMap<>();
    static String docs[];

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        int input=Integer.parseInt(st.nextToken());
        int ask=Integer.parseInt(st.nextToken());
        docs=new String[input+1];

        for(int i=1;i<=input;i++){
            String temp=br.readLine();
            Hoenn.put(temp,i);
            docs[i]=temp;
        }

        for(int i=0;i<ask;i++){
            String target=br.readLine();
            boolean isnum;
            try{
                Integer.parseInt(target);
                isnum=true;
            }catch(NumberFormatException e){
                isnum=false;
            }

            if(!isnum)
                System.out.println(Hoenn.get(target));
            else
                System.out.println(docs[Integer.parseInt(target)]);
        }
    }
}