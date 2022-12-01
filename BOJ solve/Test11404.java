import java.io.*;
import java.util.*;

public class Test11404 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static int[][] map;         //�ܹ��� �Ÿ��� ������ ���߹迭
    static int temp=10000001;   //������� �ʾ��� ����� �� (�迭 �ִ� ũ�� X �ִ� ��� +1)

    public static void main(String[] args)throws IOException{
        int size=Integer.parseInt(br.readLine());   //���߹迭�� ũ�� (�ִ� 100)
        int base=Integer.parseInt(br.readLine());   //�迭�� �Է��� Ƚ��

        map=new int[size+1][size+1];
        for(int i=1;i<=size;i++){
            Arrays.fill(map[i],temp);   //���߹迭�� i��° �� �ʱ�ȭ
            map[i][i]=0;                //�ڱ� �ڽŰ��� �Ÿ��� 0
        }

        for(int i=0;i<base;i++){
            st=new StringTokenizer(br.readLine());
            int ty=Integer.parseInt(st.nextToken());    //�����
            int tx=Integer.parseInt(st.nextToken());    //������
            int value=Integer.parseInt(st.nextToken()); //��������� ���������� �̵����� ��� (�ִ� 100,000)
            map[ty][tx]=Math.min(map[ty][tx],value);    //���� �̵����� ���� ���� ���� ������ ����
        }

        //Floyd �˰��� �̿�
        for(int check=1;check<=size;check++)
            for(int y=1;y<=size;y++)
                for(int x=1;x<=size;x++)
                    map[y][x]=Math.min(map[y][x],(map[y][check]+map[check][x]));
        
        for(int i=1;i<=size;i++){
            for(int j=1;j<=size;j++){
                if(map[i][j]==temp) //�̵� �Ұ����� ����� ��� 0�� ����Ѵ�.
                    sb.append(0).append(" ");
                else
                    sb.append(map[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }
}
