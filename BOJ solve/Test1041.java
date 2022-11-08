import java.io.*;
import java.util.*;

public class Test1041 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long result=0,size=0,dice[]=new long[7],set[]=new long[3];
    static void find(){
        set[0]=Math.min(dice[1],dice[6]);
        set[1]=Math.min(dice[2],dice[5]);
        set[2]=Math.min(dice[3],dice[4]);

        Arrays.sort(set);   //중요. 주사위에서 고른 3개의 수 중에서 작은 수가 우선시 되어야 한다.

        if(size==1){    //주사위가 1개만 있을 경우, 최댓값을 제외한 나머지 값을 모두 합친다.
            Arrays.sort(dice);
            for(int i=1;i<=5;i++)
                result+=dice[i];
            System.out.println(result);
        }
        else{
            long visibleCube=(long)Math.pow(size,2)*5;  //주사위로 만든 정육면체 중 외부에 보일 주사위 면의 수
            long edge=((size-1)+(size-2))*4;    //꼭짓점을 제외한 모서리 면의 수
            result=4*(set[0]+set[1]+set[2]) + edge*(set[0]+set[1]) + (visibleCube-(edge*2+12))*set[0];
            //꼭짓점에 드러나는 주사위값 + 모서리에 드러나는 주사위값 + 남은 면의 주사위값(최솟값).
            System.out.println(result);
        }
    }

    public static void main(String[] args)throws IOException{
        size=Long.parseLong(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=6;i++)
            dice[i]=Long.parseLong(st.nextToken());

        find();
    }
}
