import java.io.*;
import java.util.*;

public class Test15649 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb=new StringBuilder();

    static int values[];
    static boolean line[];
    
    static void dfs(int max, int print, int start) {
		if (start == print) {
			for (int v=0;v<print;v++)
				sb.append(values[v]+" ");
			sb.append('\n');
			return;
		}
 
		for (int i = 0; i < max; i++) {
			if (!line[i]) {
				line[i] = true;
				values[start] = i + 1;
				dfs(max, print, start + 1);
				line[i] = false;
			}
		}
	}

    public static void main(String[] args)throws IOException{
        StringTokenizer st=new StringTokenizer(br.readLine());
        int max=Integer.parseInt(st.nextToken());
        int print=Integer.parseInt(st.nextToken());

        values=new int[print];
        line=new boolean[max];
        dfs(max,print,0);
        System.out.println(sb);
    }
}
