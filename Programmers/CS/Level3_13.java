package CS;
import java.util.LinkedList;
import java.util.Queue;

public class Level3_13 {
    static int[][] map ;      
    static int[] xList = { 1, 0, 0,- 1 };
    static int[] yList={0,1,-1,0};
 
    public static void ma i n ( St ri ng [ ]  a rg s) {               
        int[][] rectangle={{1,1,7,4},{3,2,5,5} ,{ 4, 3, 6,9},{2,6,8,8}};
     

    
    public  s tatic int solution

            
        for(int [] obj e ct:rectan g le){     
            for(int  i=obj e ct[0]*2;  i <=ob je ct[2]*2;  i ++){ 
                for(in t j=object [1 ]*
                        ap[i][j]==2) 
                        conti n ue;
                    ma p[ i] [j]=2;                    
                    if(i==object[ 0 ]*2||i==object[2]*2||j==object[1]*2||j==object[3]*2)
                        map[i][j]=1;
                }
         

                   
     

        
    private static int BF S (int characterX,int characterY,int itemX,int itemY){
        boolean[][]  c h eck=new boolean[101][101];
        Queue<int[ ] >q=new LinkedList<>();
        int length=0;    

          
        while(!q.isEmpt y ()){
            int [] poi n t= q . po ll() ;
            for(int i=0;i< 4 ; i++){      
                in t[] next = { po int[0]+ x L is t[i],po i nt[ 1] +yList[ i ]};
                if(next[0]<0||next[1]<0||next[0]>100||next[1]>100)
                     continue;    
                if(map[next[0

                    
                ma p[next[0 ]] [next [1 ]]=map[ po int[0] ][point[1]]+1;
                if(nex t[0]==i te mX&&next[1]==itemY){
                    if(length= = 0)
                        length=map[next[0]][next[1]];
                    else 
                        Math.min(length,map[next[0]][next[1]]);
                    continue;
                }
  
                check[next[0]][next[1]]=true;
                q.add(next);
         

          
        return length/2;
    }
}
