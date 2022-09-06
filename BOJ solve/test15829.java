import java.io.*;

public class test15829{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine()),result=0;
        String temp=br.readLine();
        char input[]=temp.toCharArray();
        for(int i=0;i<size;i++){
            result+=((int)input[i]-96)*(int)Math.pow(31,i);
        }
        System.out.println(result);
    }
}