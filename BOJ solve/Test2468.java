import java.io.*;
import java.util.*;

public class Test2468 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] check;
    static int[] setX={1,-1,0,0};
    static int[] setY={0,0,-1,1};
    static int size,count,height=0,result=0;

    static int DFS(int y,int x,int height){ //���� ����� DFS
        check[y][x] = true;
		for(int i=0; i<4; i++) {
			int nx = x +setX[i];
			int ny = y +setY[i];
			
			if(nx>=0 && ny>=0 && nx<size && ny<size)
                if(!check[ny][nx] && map[ny][nx]>height)
                    DFS(ny,nx, height);
		}
		return 1;   //������ ������ ���� �ǹǷ�, �ش� ������ �����Ѵٴ� 1�� ���� ��ȯ�Ѵ�.
    }

    public static void main(String[] args)throws IOException{
        size=Integer.parseInt(br.readLine());
        map=new int[size][size];

        for(int i=0; i<size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<size; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

        do{
            count=0;    //�� �ݺ����� ������ ������ 0���� ����.
            check=new boolean[size][size];  //�� �ݺ����� ���� Ȯ�ο� ���߹迭 check�� �ʱ�ȭ�Ѵ�.
            for(int i=0; i<size; i++)
                for(int j=0; j<size; j++)
                    if(!check[i][j]&&map[i][j]>height)  //Ȯ�ε��� ���� ������, ���� ������ ������ų ���
                        count+=DFS(i,j,height);         //�� ������ ũ�⸸ŭ check�� ǥ���ϰ�, ������ ������ 1 �ø���.
            result=Math.max(result,count);  //�̹� �ݺ����� �� ������ ������ �ִ� ������ ���� �����Ѵ�.
            height++;       //�� �ݺ��� ������ ���� ������ 1 �ø���.
        }while(count!=0);   //�� �� �ִ� ������ ���ٸ� ���̻� ���� ������ ������ų �� ���ٰ� �����Ͽ�, �ݺ��� �����Ѵ�.

        System.out.println(result); //������ �ִ� ������ ����Ѵ�.
    }
}
