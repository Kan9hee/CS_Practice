import java.io.*;
import java.util.*;

public class Test2583 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static PriorityQueue<Integer>list=new PriorityQueue<>();
    static boolean map[][]; //���߹迭
    static int mapX,mapY,count=0;   //���߹迭 x,y�� ũ��, ���� ������ ����
    static int setX[]={1,-1,0,0};   //x�� �̵��� �迭
    static int setY[]={0,0,1,-1};   //y�� �̵��� �迭

    static void inputBoxs(int stx,int sty,int ex,int ey){   //��Ȱ�� ���� ����
        for(int i=sty;i<ey;i++)
            for(int t=stx;t<ex;t++)
                map[i][t]=true;
    }

    static void check(int x,int y){
        map[y][x]=true; //���� ��ġ �湮 Ȯ��
        count++;    //�̾��� ��ġ ���� ����
        for(int i=0;i<4;i++){
            int tmpX=x+setX[i];
            int tmpY=y+setY[i];
            if(tmpX>=0&&tmpX<mapX&&tmpY>=0&&tmpY<mapY&&!map[tmpY][tmpX])
                check(tmpX, tmpY);  //���� �迭 ���̸�, false�� ��ġ�� ��� ���ȣ��
        }
    }

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        mapY=Integer.parseInt(st.nextToken());
        mapX=Integer.parseInt(st.nextToken());
        int boxs=Integer.parseInt(st.nextToken());
        map=new boolean[mapY][mapX];

        for(int i=0;i<boxs;i++){
            st=new StringTokenizer(br.readLine());
            int info[]=new int[4];  //�־��� ���� ���� ���� ��Ȱ��ȭ
            for(int t=0;t<4;t++)    //info[0],info[1] ����  info[2],info[3]������ �迭�� ��Ȱ��ȭ�Ѵ�.
                info[t]=Integer.parseInt(st.nextToken());
            inputBoxs(info[0], info[1], info[2], info[3]);
        }

        for(int i=0;i<mapY;i++)
            for(int t=0;t<mapX;t++)
                if(!map[i][t]){ //���� ��ġ�� false�� ���
                    check(t,i); //���� ��ġ���� Ȱ��ȭ�� ������ ũ�⸦ ����, ��Ȱ��ȭ�Ѵ�.
                    list.add(count);    //�켱����ť�� ������ ����ũ�⸦ �����Ѵ�.
                    count=0;    //���� ������ ���� �ʱ�ȭ
                }
        
        count=list.size();  //�켱���� ť ���� �������� ��
        sb.append(count+"\n");
        for(int i=0;i<count;i++)
            sb.append(list.poll()+" ");

        System.out.println(sb.toString());
    }
}
