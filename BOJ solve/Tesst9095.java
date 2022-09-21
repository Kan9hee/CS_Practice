import java.io.*;

class Test9095 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static int list[]=new int[11];
    static int cases;
    
	public static void main (String[] args) throws IOException {
	    cases=Integer.parseInt(br.readLine());
	    
	    list[0]=1;
	    list[1]=1;
	    list[2]=2;
	    
	    for(int i=0;i<cases;i++){
	        int temp=Integer.parseInt(br.readLine());
	        for(int t=3;t<=temp;t++)
	            list[t]=list[t-1]+list[t-2]+list[t-3];
	        System.out.println(list[temp]);
	    }
	}
}