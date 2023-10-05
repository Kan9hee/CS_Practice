import java.io.*;

public class Test5582 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line1=br.readLine();
        String line2=br.readLine();
        int[][] map=new int[line1.length()+1][line2.length()+1];

        int result=0;
        for(int i=1;i<=line1.length();i++)
            for(int j=1;j<=line2.length();j++)
                if(line1.charAt(i-1)==line2.charAt(j-1)){
                    map[i][j]=map[i-1][j-1]+1;
                    result=Math.max(result,map[i][j]);
                }

        System.out.println(result);
    }
}