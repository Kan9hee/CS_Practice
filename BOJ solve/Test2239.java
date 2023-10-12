import java.io.*;

public class Test2239 {
    static int[][] sudoku=new int[9][9];

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[] input;

        for(int i=0;i<9;i++){
            input=br.readLine().toCharArray();
            for(int j=0;j<9;j++)
                sudoku[i][j]=input[j]-'0';
        }

        //backtracking & dfs
        DFS(0);
    }

    private static void DFS(int num){
        if(num==81){
            StringBuilder sb=new StringBuilder();
            for(int[] row:sudoku){
                for(int colVal:row)
                    sb.append(colVal);
                sb.append("\n");
            }
            
            System.out.println(sb.toString());
            System.exit(0);
        }

        int row=num/9;
        int col=num%9;
        if(sudoku[row][col]!=0)
            DFS(num+1);
        else{
            for(int i=1;i<10;i++) {
				if(!check(row,col,i))
                    continue;
				sudoku[row][col] = i;
				DFS(num+1);
				sudoku[row][col]=0;
			}
        }
    }

    private static boolean check(int row,int col,int val){
        //check row and column lines of current place
        for(int i=0;i<9;i++)
            if(sudoku[i][col]==val||sudoku[row][i]==val)
                return false;
        
        //check miniBox of current place
        int boxRow=row-row%3;
        int boxCol=col-col%3;
        for(int i=boxRow;i<boxRow+3;i++)
            for(int j=boxCol;j<boxCol+3;j++)
                if(sudoku[i][j]==val)
                    return false;

        return true;
    }
}