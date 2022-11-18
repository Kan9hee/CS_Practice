import java.io.*;

public class Test2156 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static int count,list[],maxStack[];

    public static void main(String[] args)throws IOException{
        count=Integer.parseInt(br.readLine());
        list=new int[count+1];
        maxStack=new int[count+1];  //list[0] = 0

        for(int i=1;i<=count;i++)
            list[i]=Integer.parseInt(br.readLine());

        maxStack[1]=list[1];
        if(count>1)
            maxStack[2]=list[1]+list[2];
        for(int i=3;i<=count;i++)
            maxStack[i]=Math.max(maxStack[i-1],Math.max(maxStack[i-2]+list[i],maxStack[i-3]+list[i-1]+list[i]));
        //최근 최댓값, 그 전 최댓값+현재 list값, 그보다 더 전 최댓값 + 이전 list값+ 현재 list값을 비교해 최댓값을 갱신해간다.
        System.out.println(maxStack[count]);    //마지막으로 갱신된 최댓값을 반환한다.
    }
}
