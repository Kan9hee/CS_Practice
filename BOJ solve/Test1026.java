import java.util.*;
public class Test1026{
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        int result=0;
        int count=sc.nextInt();
        int[] lin1=new int[count];
        int[] lin2=new int[count];
        for(int i=0;i<count;i++)
            lin1[i]=sc.nextInt();
        for(int i=0;i<count;i++)
            lin2[i]=sc.nextInt();
        Arrays.sort(lin1);
        Arrays.sort(lin2);
        for(int i=0;i<count;i++)
            result+=lin1[i]*lin2[count-1-i];
        System.out.println(result);
        sc.close();
    }
}