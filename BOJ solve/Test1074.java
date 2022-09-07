import java.io.*;
import java.util.*;
public class Test1074 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N,r,c,size;

    //배열의 좌표를 이용한 재귀함수로 찾아내는 것이 아닌,
    //선택적인 4분할 재귀함수로 근사치를 구해간다.
    // Z모양, 즉 좌상->우상->좌하->우하 식으로 움직이며 증가하기에
    //(0,0) / (2^n,0) / (0,2^n) / (2^n,2^n)과 가까운지를 확인하고
    //n의 크기에 따라 Z경로를 거친 4분할된 배열 크기와 그 개수만큼
    //결과값에 더한다.
    static int Search(int range,int startX,int startY){
        if(range==1)
            return 0;
        if(r<range/2+startX&&c<range/2+startY)
            return Search(range/2, startX, startY);
        else if(r<range/2+startX&&c>=range/2+startY)
            return Search(range/2, startX, startY+range/2)+(int)Math.pow(range/2,2);
        else if(r>=range/2+startX&&c<range/2+startY)
            return Search(range/2, startX+range/2, startY)+(int)Math.pow(range/2,2)*2;
        else
            return Search(range/2, startX+range/2, startY+range/2)+(int)Math.pow(range/2,2)*3;
    }

    public static void main(String[]args)throws IOException{
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        size=(int)Math.pow(2,N);
        System.out.println(Search(size,0,0));
    }
}
