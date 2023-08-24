import java.util.LinkedList;
import java.util.Queue;

public class Level3_13 {
    static int[][] map;
    static int[] xList={1,0,0,-1};
    static int[] yList={0,1,-1,0};

    public static void main(String[] args){
        int[][] rectangle={{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        System.out.println(solution(rectangle,1,3,7,8));
    }
    
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map=new int[101][101];
        
        for(int[] object:rectangle){
            for(int i=object[0]*2; i<=object[2]*2; i++){
                for(int j=object[1]*2; j<=object[3]*2; j++){
                    if(map[i][j]==2) 
                        continue;
                    map[i][j]=2;
                    if(i==object[0]*2||i==object[2]*2||j==object[1]*2||j==object[3]*2)
                        map[i][j]=1;
                }
            }
        }
        
        return BFS(characterX*2,characterY*2,itemX*2,itemY*2);
    }
    
    private static int BFS(int characterX,int characterY,int itemX,int itemY){
        boolean[][] check=new boolean[101][101];
        Queue<int[]>q=new LinkedList<>();
        int length=0;
        q.add(new int[]{characterX,characterY});
        
        while(!q.isEmpty()){
            int[] point=q.poll();
            for(int i=0;i<4;i++){
                int[] next={point[0]+xList[i],point[1]+yList[i]};
                if(next[0]<0||next[1]<0||next[0]>100||next[1]>100)
                    continue;
                if(map[next[0]][next[1]]!=1||check[next[0]][next[1]])
                    continue;
                
                map[next[0]][next[1]]=map[point[0]][point[1]]+1;
                if(next[0]==itemX&&next[1]==itemY){
                    if(length==0)
                        length=map[next[0]][next[1]];
                    else
                        Math.min(length,map[next[0]][next[1]]);
                    continue;
                }

                check[next[0]][next[1]]=true;
                q.add(next);
            }
        }
        
        return length/2;
    }
}
