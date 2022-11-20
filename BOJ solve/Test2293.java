import java.io.*;
import java.util.*;

//메모리 제한 4MB!!//

public class Test2293{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int kind,limit,list[],cases[];   //동전 개수, 목표값, 동전 종류, 동전 개수에 따른 경우의 수

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        kind=Integer.parseInt(st.nextToken());
        limit=Integer.parseInt(st.nextToken());

        list=new int[kind];
        cases=new int[limit+1];
        for(int i=0;i<kind;i++)
            list[i]=Integer.parseInt(br.readLine());
        
        Arrays.sort(list);  //입력받은 동전들을 오름차순으로 정렬
        cases[0]=1; //1번째 경우는 동전을 1개만 사용함.

        for(int i=0;i<kind;i++) //동전 종류마다
            for(int t=1;t<=limit;t++)   //개수에 따른 경우를 거쳐
                if(t>=list[i])  //사용 가능한 동전 개수가 현재 사용하는 동전 종류의 값보다 클 경우
                    cases[t]+=cases[t-list[i]]; //해당 경우의 수가 증가

        System.out.println(cases[limit]);   //cases[limit]의 값이 최종적으로 증가한 경우의 수
    }
}