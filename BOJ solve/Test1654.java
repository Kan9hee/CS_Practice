import java.io.*;
import java.util.*;

public class Test1654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

    static long findout(int value,long max,long[] list) {
		long min = 1;
		while (min <= max) {
			long middle = (min + max) / 2;
			long sum = 0;
			for (long lan : list) {
				if (middle < lan) {
					sum += (lan / middle);
				}
			}
			if (sum < value)
				max = middle - 1;
			else
				min = middle + 1;
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int value = Integer.parseInt(st.nextToken());

		long list[] = new long[size];

		for (int i = 0; i < size; i++)
			list[i] = Long.parseLong(br.readLine());

        Arrays.sort(list);
        long max=list[size-1];

		System.out.println(findout(value,max,list));
	}
}
