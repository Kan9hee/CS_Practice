import java.io.*;
import java.util.*;

public class Test5052 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static String list[];   //숫자 배열 리스트
    static int repeat,count;    //테스트케이스, 숫자 배열 수

    static void check(){    //접두어 테스트
        for(int i=0;i<count-1;i++)
            if(list[i+1].startsWith(list[i])){  //i번째 숫자 배열이 그보다 큰 숫자 배열의 일부일 경우
                System.out.println("NO");   //NO를 출력하고 메소드를 종료한다.
                return;
            }
        System.out.println("YES");  //모든 숫자 배열이 다른 숫자 배열의 일부가 아닐 경우, YES를 출력한다.
    }

    public static void main(String[]args)throws IOException{
        repeat=Integer.parseInt(br.readLine()); //테스트 횟수 입력
        for(int i=0;i<repeat;i++){
            count=Integer.parseInt(br.readLine());  //숫자 배열 개수 입력
            list=new String[count];
            for(int t=0;t<count;t++)
                list[t]=new String(br.readLine());
            Arrays.sort(list);  //입력된 숫자 배열들을 오름차순으로 정렬한다.
            check();
        }
    }
}
