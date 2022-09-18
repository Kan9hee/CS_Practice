import java.util.*;
import java.io.*;

public class Test1931 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int timeTable[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
			timeTable[i][0] = Integer.parseInt(st.nextToken());
			timeTable[i][1] = Integer.parseInt(st.nextToken());
		}

        //�� ȸ���� ����ð��� �������� �������� �����Ѵ�.
        //��, �� ȸ���� ���� �ð��� ���� ��� ���� �ð��� ���� �����Ѵ�.
		Arrays.sort(timeTable, (a, b) -> {
			if(a[1] == b[1])
                return a[0] - b[0];
			return a[1] - b[1];
		});

        for(int i=0;i<timeTable.length;i++){
            System.out.println(timeTable[i][0]+" "+timeTable[i][1]);
        }

		int ans = 0;
		int time = 0;

		for (int i = 0; i < N; i++) {
			if (timeTable[i][0] >= time) { 
				time = timeTable[i][1];
				ans++;
			}
		}
		System.out.println(ans);
        
	}
}