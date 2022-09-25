//Test11724와 유사한 문제
//이중배열을 통한 dfs를 구현해야 한다.
import java.io.*;
import java.util.*;

public class Test2606 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int com,link,temp1,temp2,result=0;
    static boolean order[][];
    static boolean check[];

    //감염된 com의 번호를 check하고(감염하고),
    //해당 com과 이어진 com도 check하기 위해
    //이어진 com의 번호로 재참조한다.
    private static void find(int temp){
        check[temp]=true;
        for(int i=1;i<=com;i++)
            if(order[temp][i]&&!check[i]){
                result++;
                find(i);
            }
    }

    public static void main(String[] args)throws IOException{
        com=Integer.parseInt(br.readLine());
        link=Integer.parseInt(br.readLine());
        order=new boolean[com+1][com+1];
        check=new boolean[com+1];

        //선언한 두 정점은 서로 오갈 수 있는 간선으로 이어져
        //이중 배열에서 두 값을 바꾼 경우도 true로 한다.
        for(int i=0;i<link;i++){
            st=new StringTokenizer(br.readLine());
            temp1=Integer.parseInt(st.nextToken());
            temp2=Integer.parseInt(st.nextToken());
            order[temp1][temp2]=order[temp2][temp1]=true;
        }

        find(1);
        System.out.println(result);
    }
}
