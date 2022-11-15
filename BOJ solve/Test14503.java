import java.io.*;
import java.util.*;

public class Test14503 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int lengthX,lengthY,way,count=1,map[][];
    static int setX[]={0,1,0,-1};   //0�� ����, 1�� ���� 2�� ����, 3�� ������ �ǹ��ϸ�,
    static int setY[]={-1,0,1,0};   //�� �������� ���� ����� ��ġ ��ȯ ���̴�.

    static void cleaner(int x,int y){
        map[y][x]=-1;   //û���� ��ġ�� ���� -1�� �Ͽ� ��, ������� �����Ѵ�.
        int tempx,tempy;

        for(int i=0;i<4;i++){
            way=(way+3)%4;  //�·� 1ȸ���Ѵ�.
            tempx=x+setX[way];  //
            tempy=y+setY[way];  //ȸ�� �� �������� ��ġ��.
            if(tempx >=0 && tempx < lengthX && tempy >= 0 && tempy < lengthY)
                if(map[tempy][tempx] == 0){ //map�迭 �� �� ������ ���
                    count++;    //û�� ���� Ƚ�� + 1
                    cleaner(tempx,tempy);   //�ش� ��ġ�� �̵�
                    return;
                }
        }

        int reverseWay=(way+2)%4;   //���� �ٶ󺸴� ��ġ�� �ݴ� ����. �ռ� for������ 4������ �� �ٶ󺸰� ���� �������� ���ƿԱ⿡ ����.
        tempx=x+setX[reverseWay];
        tempy=y+setY[reverseWay];
        if(tempx >= 0 && tempx < lengthX && tempy >= 0 && tempy < lengthY && map[tempy][tempx] != 1)
            cleaner(tempx, tempy);  //�ݴ� �������� ���ư��� �� ���� �ƴ� ��� �� ��ġ�� �̵��Ѵ�.
    }

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        lengthY=Integer.parseInt(st.nextToken());
        lengthX=Integer.parseInt(st.nextToken());
        map=new int[lengthY][lengthX];

        st=new StringTokenizer(br.readLine());
        int tempy=Integer.parseInt(st.nextToken());
        int tempx=Integer.parseInt(st.nextToken());
        way=Integer.parseInt(st.nextToken());

        for(int i=0;i<lengthY;i++){
            st=new StringTokenizer(br.readLine());
            for(int t=0;t<lengthX;t++)
                map[i][t]=Integer.parseInt(st.nextToken());
        }

        cleaner(tempx, tempy);
        System.out.println(count);
    }
}
