import java.io.*;

public class Test11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("\\s+");
        int[] list = new int[n];
        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(input[i]);

        int[] ldp = new int[n];
        ldp[0] = 1;
        for (int i = 1; i < n; i++) {
            ldp[i] = 1;
            for (int j = 0; j < i; j++)
                if (list[i] > list[j] && ldp[j] + 1 > ldp[i])
                    ldp[i] = ldp[j] + 1;
        }

        int[] rdp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            rdp[i] = 1;
            for (int j = n - 1; j > i; j--)
                if (list[i] > list[j] && rdp[j] + 1 > rdp[i])
                    rdp[i] = rdp[j] + 1;
        }

        int answer = 0;
        for (int i = 0; i < n; i++)
            answer = Math.max(answer, ldp[i] + rdp[i]);

        System.out.println(answer - 1);
    }
}
