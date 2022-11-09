import java.io.*;
import java.util.*;

public class Test12865 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int repeat,size,backpack[][],map[][];

    static void result(int maxY,int maxX){
        for(int i=1;i<=maxY;i++)
            for(int t=1;t<=maxX;t++){
                if(backpack[i][0]>t)    //���� ������ ���԰� ������ ���� �� �ִ� ���Ժ��� ũ�ٸ�
                    map[i][t]=map[i-1][t];  //���� map�� ���� �ٷ� ���� ���� �ȴ�.
                else
                    map[i][t]=Math.max(map[i-1][t],map[i-1][t-backpack[i][0]]+backpack[i][1]);
                    //���� ���� ���� �ٷ� ���� ����
                    //���� �迭���� ������ ���� �� �ִ� ����-������ ���� ��°�� �ִ� ���� ������ ����ġ�� ��ģ ���� ����
                    //�ִ��� �ִ´�.
            }
    }

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        repeat=Integer.parseInt(st.nextToken());    //���� ����
        size=Integer.parseInt(st.nextToken());  //������ �ִ� ����

        backpack=new int[repeat+1][2];  //���� (����, ����ġ)
        map=new int[repeat+1][size+1];  //�ִ� ����ġ ������ 2���� �迭
        for(int i=1;i<=repeat;i++){
            st=new StringTokenizer(br.readLine());
            backpack[i][0]=Integer.parseInt(st.nextToken());
            backpack[i][1]=Integer.parseInt(st.nextToken());
        }
        result(repeat,size);

        System.out.println(map[repeat][size]);
    }
}
