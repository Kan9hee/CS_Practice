import java.io.*;

class Test1003{
    static void Find01(int value){
        int stack0=1;
        int stack1=0;
        for(int i=0;i<value;i++){
            int temp=stack1;
            stack1+=stack0;
            stack0=temp;
        }
        System.out.println(stack0+" "+stack1);
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testcase=Integer.parseInt(br.readLine());
        for(int i=0;i<testcase;i++)
            Find01(Integer.parseInt(br.readLine()));
    }
}