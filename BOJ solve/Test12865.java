import java.io.*;
import java.util.*;

public class Test12865 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int repeat,size,backpack[][],map[][];

    static void result(int maxY,int maxX){
        for(int i=1;i<=maxY;i++)
            for(int t=1;t<=maxX;t++){
                if(backpack[i][0]>t)    //만약 물건의 무게가 베낭에 넣을 수 있는 무게보다 크다면
                    map[i][t]=map[i-1][t];  //현재 map의 값은 바로 위의 값이 된다.
                else
                    map[i][t]=Math.max(map[i-1][t],map[i-1][t-backpack[i][0]]+backpack[i][1]);
                    //현재 맵의 값은 바로 위의 값과
                    //위의 배열에서 베낭에 넣을 수 있는 무게-물건의 무게 번째에 있는 값에 물건의 값어치를 합친 값과 비교해
                    //최댓값을 넣는다.
            }
    }

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        repeat=Integer.parseInt(st.nextToken());    //물건 개수
        size=Integer.parseInt(st.nextToken());  //베낭의 최대 무게

        backpack=new int[repeat+1][2];  //베낭 (무게, 값어치)
        map=new int[repeat+1][size+1];  //최대 값어치 누적용 2차원 배열
        for(int i=1;i<=repeat;i++){
            st=new StringTokenizer(br.readLine());
            backpack[i][0]=Integer.parseInt(st.nextToken());
            backpack[i][1]=Integer.parseInt(st.nextToken());
        }
        result(repeat,size);

        System.out.println(map[repeat][size]);
    }
}
