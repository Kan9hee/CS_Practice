import java.io.*;
import java.util.*;

public class Test11053{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int list[],results[];

	public static void main(String[] args) throws IOException {
		int size = Integer.parseInt(br.readLine());
		list = new int[size];
		results = new int[size];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < size; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < size; i++) {
			results[i] = 1;
			for(int j = 0; j < i; j++)
                //���� ��庸�� ���� ���� ������ ���ϵ�, �� ���� �� �ְ� ������� +1������ ���� �� �ִ�.
				if(list[j] < list[i] && results[i] < results[j] + 1)
                    results[i] = results[j] + 1;
		}

		int max = 0;
		for(int i = 0; i < size; i++)
			max =Math.max(results[i],max);
		System.out.println(max);
	}
}
