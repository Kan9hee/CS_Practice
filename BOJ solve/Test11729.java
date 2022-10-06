//하노이의 탑 문제
//3개의 기둥을 순환하며 주어진 원판을 적절히 배분한다.
//가장 큰 원판이 1번 기둥에 남고, n-1개의 기둥이 2번 기둥에 있을 때까지
//2번과 3번 기둥을 바꿔가며 재귀호출한다.
//1번 기둥에 있던 원판을 3번 기둥으로 옮기고, 나머지 원판을 3번 기둥에 쌓도록
//1번과 2번 기둥을 바꿔가며 재귀호출한다.
//전반적으로 중위 순회와 비슷한 양상을 띈다.
import java.util.*;

public class Test11729 {
    static Scanner sc=new Scanner(System.in);
    static StringBuilder sb=new StringBuilder();
    static int count=0;
    static void hanoi(int n,char a,char b,char c){
        count++;
        if(n==1)
            sb.append(a+" "+c+"\n");
        else{
            hanoi(n-1,a,c,b);
            sb.append(a+" "+c+"\n");
            hanoi(n-1,b,a,c);
        }
    }

    public static void main(String[] args){
        int round=sc.nextInt();
        hanoi(round,'1','2','3');
        System.out.println(count);
        System.out.println(sb);
    }
}
