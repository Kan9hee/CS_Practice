import java.util.Scanner;
public class Test14888 {
    private static Scanner sc=new Scanner(System.in);
    private static int MAX=Integer.MIN_VALUE,MIN=Integer.MAX_VALUE;
    private static int count=sc.nextInt();
    private static int[] vals=new int[count];
    private static int[] operator=new int[4];

    public static void Solution(int FrontValue,int Stack){
        if(Stack==count){
            MAX=Math.max(MAX,FrontValue);
            MIN=Math.min(MIN,FrontValue);
            return;
        }
        for(int i=0;i<4;i++){
            if(operator[i]>0){
                operator[i]--;
                switch(i){
                    case 0:Solution(FrontValue+vals[Stack], Stack+1);break;
                    case 1:Solution(FrontValue-vals[Stack], Stack+1);break;
                    case 2:Solution(FrontValue*vals[Stack], Stack+1);break;
                    case 3:Solution(FrontValue/vals[Stack], Stack+1);break;
                }
                operator[i]++;
            }
        }
    }
    public static void main(String[] args){
        for(int i=0;i<count;i++)
            vals[i]=sc.nextInt();
        for(int i=0;i<4;i++)
            operator[i]=sc.nextInt();
        
        Solution(vals[0],1);
        System.out.println(MAX+"\n"+MIN);
    }
}
