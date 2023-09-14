import java.io.*;
import java.util.*;

public class Test10844 {
    static int N;
    static long requirement=1000000000;
    static Long map[][];

    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new Long[N+1][10];
        long result=0;

        Arrays.fill(map[1],1L);
        for(int i=1;i<=9;i++)
            result += TopDown(N, i);

        System.out.println(result % requirement);
    }

    private static long TopDown(int digit,int value){
        if(digit==1)
            return map[digit][value];
        
        if(map[digit][value]==null){
            if(value==0)
                map[digit][value]=TopDown(digit-1, 1);
            else if(value==9)
                map[digit][value]=TopDown(digit-1, 8);
            else
                map[digit][value]=TopDown(digit-1, value-1)+TopDown(digit-1, value+1);
        }

        return map[digit][value] % requirement;
    }
}
