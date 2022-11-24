import java.io.*;
import java.util.*;

public class Test2470 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int acid,alkali,min,size,list[];

    static void find(int start,int end){    //주어진 값들 중 2개의 합이 가장 0과 근접한 두 값 찾기
        while(start<end){                   //배열의 양 끝을 가리키는 두 포인터가 교차할 때까지 반복한다.
            int temp=list[start]+list[end];
            if(Math.abs(temp)<min){         //만약 현재 반복에서 0과 가장 근접한 합이 나올 경우,
                min=Math.abs(temp);         //최솟값을 해당 값으로 초기화하고
                acid=list[start];           //합치는 데 사용된 두 값을 저장한다.
                alkali=list[end];
            }
            if(temp>0)                      //만약 두 합이 양수라면 배열 우측의 포인터를 좌측으로 1칸 이동시키고
                end--;
            else                            //두 합이 음수라면 배열 좌측의 포인터를 우측으로 1칸 이동시킨다.
                start++;
        }
    }

    public static void main(String[] args)throws IOException{
        size=Integer.parseInt(br.readLine());
        list=new int[size];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<size;i++)
            list[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(list);      //입력된 값들을 오름차순으로 정렬하여 값을 찾기 쉽게 한다.
        min=Integer.MAX_VALUE;  

        find(0,size-1);
        System.out.println(acid+" "+alkali);    //결정된 두 값을 출력한다.
    }   
}
