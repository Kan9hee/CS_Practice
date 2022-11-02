import java.io.*;

public class Test14427 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static char temp1[],temp2[];
    static int map[][];

    static int result(int maxY,int maxX){
        for(int i=0;i<maxY;i++){
            for(int t=0;t<temp2.length;t++){
                if(temp1[i]==temp2[t])
                    map[i+1][t+1]=map[i][t]+1;
                else
                    map[i+1][t+1]=Math.max(map[i+1][t],map[i][t+1]);
            }
        }
        return map[maxY][maxX];
    }

    public static void main(String[] args)throws IOException{
        temp1=br.readLine().toCharArray();
        temp2=br.readLine().toCharArray();
        map=new int[temp1.length+1][temp2.length+1];

        System.out.println(result(temp1.length,temp2.length));
    }
}
