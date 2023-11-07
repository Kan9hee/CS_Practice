import java.util.*;

public class Test12842 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); //must use scanner, not bufferedReader

        int n=sc.nextInt();
        int s=sc.nextInt();
        int m=sc.nextInt();
        int[] arr=new int[m];

        for(int i=0;i<m;i++)
            arr[i]=sc.nextInt();

        int eat=0;

        for(int t=0;;t++){
            for(int i=0;i<m;i++){
                if(t%arr[i]==0){
                    eat++;
                    if(eat>=n-s){
                        System.out.println(i+1);
                        return;
                    }
                }
            }
        }
    }
}
