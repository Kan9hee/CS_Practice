import java.io.*;
import java.util.*;
 
public class Test1806 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int size,target,list[],start,end,min;

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());    //배열의 크기
        target = Integer.parseInt(st.nextToken());  //부분합 통과 기준
        list = new int[size+1]; //기존 배열보다 1만큼 더 크게 만들어 후위증가 연산자로 인한 배열의 범위를 벗어나는 경우를 대비한다.
        min = size+1;           //최소 진행 횟수
        start = end = 0;        //시작점,종점 위치

        st=new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++)
            list[i] = Integer.parseInt(st.nextToken());
        
        int total = 0;  //현재 부분합
        while(start <= size && end <= size) {   //시작점과 종점이 배열 크기 인덱스보다 클 때까지 반복한다.
            if(total >= target && min > end - start)
                min = end - start;  //현재 부분합이 기준을 통과할 때 최소 진행 횟수를 최소치로 초기화한다.
            if(total < target)
                total += list[end++];   //종점의 위치를 이동하며 현재 부분합에 배열 인덱스가 종점인 값을 더한다.
            else
                total -= list[start++]; //시작점의 위치를 이동하며 현재 부분합이 통과 기준보다 작도록 뺀다.
        }
        
        if(min == size+1)
            System.out.println(0);  //만약 최소 진행 회수에 변함이 없을 경우, 기준을 통과하는 경우가 없는 것으로 판단한다.
        else
            System.out.println(min);
    }
}