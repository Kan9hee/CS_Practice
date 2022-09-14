import java.io.*;

class Test1463{
    static int Simulate(int value,int count){
        if(value<=1)
            return count;
        return Math.min(Simulate(value/3,count+1+value%3), Simulate(value/2,count+1+value%2));
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int value=Integer.parseInt(br.readLine());
        System.out.println(Simulate(value,0));
    }
}