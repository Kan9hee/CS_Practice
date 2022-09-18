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

        //두 회의의 종료시간을 기준으로 오름차순 정렬한다.
        //단, 두 회의의 종료 시간이 같을 경우 시작 시간도 비교해 정렬한다.
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