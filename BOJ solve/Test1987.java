import java.io.*;
import java.util.*;

public class Test1987 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] alphaCheck=new boolean[26];
    static int[][] map;
    static int[] setX={1,0,-1,0};
    static int[] setY={0,1,0,-1};
    static int mapX,mapY,result=0;

    static void solve(int x,int y,int count){   //���� x��ǥ, y��ǥ, �̵� Ƚ��
        if(alphaCheck[map[y][x]]){          //���� ���� ��ǥ�� ���� �̹� ������ ���
            result=Math.max(result,count);  //�̵� Ƚ���� ���� �ִ� �̵� Ƚ���� �����Ѵ�.
            return;                         //���� �޼ҵ带 ��ȯ�Ѵ�.
        }
        alphaCheck[map[y][x]]=true; //���� ��ǥ�� ���� �������� ����Ѵ�.
        count++;                    //�̵� Ƚ���� �����Ѵ�.
        for(int i=0;i<4;i++){   
            int tempX=x+setX[i];    //�������� �̵��� x��ǥ
            int tempY=y+setY[i];    //�������� �̵��� y��ǥ
            if(tempX>=0&&tempX<mapX&&tempY>=0&&tempY<mapY)
                solve(tempX,tempY,count);   //x,y��ǥ�� ��ȿ�� ���, solve�� ��ȯȣ���Ѵ�.
        }
        alphaCheck[map[y][x]]=false;//��ȯ ��, �� ������ ���� ���� ��ǥ ��� �ʱ�ȭ
    }

    public static void main(String[] args)throws IOException{
        st=new StringTokenizer(br.readLine());
        mapY=Integer.parseInt(st.nextToken());
        mapX=Integer.parseInt(st.nextToken());
        map=new int[mapY][mapX];

        for(int i=0;i<mapY;i++){
            String temp=br.readLine();
            for(int t=0;t<mapX;t++){
                map[i][t]=temp.charAt(t)-'A';
            }
        }

        solve(0,0,0);
        System.out.println(result);
    }
}
