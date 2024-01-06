import java.io.*;

public class Test9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input1 = br.readLine().toCharArray();
        char[] input2 = br.readLine().toCharArray();
        int[][] map = new int[input1.length + 1][input2.length + 1];
        int x = input1.length;
        int y = input2.length;

        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++) {
                if (input1[i] == input2[j])
                    map[i + 1][j + 1] = map[i][j] + 1;
                else
                    map[i + 1][j + 1] = Math.max(map[i + 1][j], map[i][j + 1]);
            }

        String reverse = "";
        while (x != 0 && y != 0) {
            if (map[x - 1][y] == map[x][y])
                x--;
            else if (map[x][y - 1] == map[x][y])
                y--;
            else {
                reverse += input1[x - 1];
                x--;
                y--;
            }
        }

        String answer = "";
        for (int i = reverse.length() - 1; i >= 0; i--)
            answer += reverse.charAt(i);
        System.out.println(answer.length() + "\n" + answer);
    }
}
