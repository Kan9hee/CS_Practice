import java.io.*;
import java.util.*;

public class Test6603 {
    static int[] list;
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boolean looped=false;
        while(true){
            String input=br.readLine();

            if(input.equals("0"))
                break;
            if(looped)
                System.out.println();

            StringTokenizer st=new StringTokenizer(input);
            list=new int[Integer.parseInt(st.nextToken())];
            for(int i=0;st.hasMoreTokens();i++)
                list[i]=Integer.parseInt(st.nextToken());
            Arrays.sort(list);

            for(int i=0;i<=list.length-6;i++)
                result(i,1,Integer.toString(list[i]));
            looped=true;
        }
    }

    private static void result(int index,int count,String str){
        if(count==6){
            System.out.println(str);
            return;
        }
        
        for(int i=1;i<list.length-index;i++)
            result(index+i,count+1,str+" "+Integer.toString(list[index+i]));
    }
}
