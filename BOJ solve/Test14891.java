import java.io.*;
import java.util.*;

public class Test14891{
    static int gear[][]=new int[4][8];
	static int d[];
	static int n,m;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		
		for(int i=0;i<4;i++) {
			String s=br.readLine();
			for(int j=0;j<8;j++)
				gear[i][j]=s.charAt(j)-'0';
		}
		
		int k=Integer.parseInt(br.readLine());
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());
			int gearVal=Integer.parseInt(st.nextToken()) - 1;
			int turn=Integer.parseInt(st.nextToken());
			d=new int[4]; 
			
			d[gearVal]=turn; 
			check(gearVal);
			turn();	
		}
		
		int ans=0;
        for(int i=0;i<4;i++)
            if(gear[i][0]==1)
                ans+=Math.pow(2,i);

		System.out.println(ans);
	}

	static void check(int gearVal){
		for(int i=gearVal-1;i>=0;i--) {
			if(gear[i][2]!=gear[i+1][6])
				d[i]=-d[i+1];
            else
				break;
		}
		for(int i=gearVal+1;i<4;i++){
			if(gear[i][6]!=gear[i-1][2])
				d[i]=-d[i-1];
            else
				break;
		}	
	}
	
	static void turn() {
		int temp=0;
		
		for(int i=0;i<4;i++){
			if(d[i]==1){
				temp=gear[i][7];
				for(int j=7;j>0;j--)
					gear[i][j]=gear[i][j-1];
				gear[i][0]=temp;
			}
			else if(d[i]==-1){
				temp=gear[i][0];
				for(int j=0;j<7;j++)
					gear[i][j]=gear[i][j+1];
				gear[i][7]=temp;
			}
		}
	}
}