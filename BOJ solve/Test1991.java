import java.io.*;
import java.util.*;

public class Test1991 {
	static class Node {
		int left;
		int right;

		public Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Node>[] list;
	static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<n+1; i++) {
            st=new StringTokenizer(br.readLine());
			int data = st.nextToken().charAt(0) -'A'+1;
			int left = st.nextToken().charAt(0) -'A'+1;
			int right = st.nextToken().charAt(0) -'A'+1;
			list[data].add(new Node(left, right));
		}
		
		preorder(1);
		sb.append("\n");
		inorder(1);
		sb.append("\n");
		postorder(1);
		System.out.println(sb.toString());
		
	}
	
	static void preorder(int start) {
		for(Node node : list[start]) {
			int l = node.left;
			int r = node.right;
			
			sb.append((char)(start+'A'-1));
			if(l != -18) preorder(l);
			if(r != -18) preorder(r);
            //아스키 코드상 A-1-18 = . 이다
		}
	}
	
	static void inorder(int start) {
		for(Node node : list[start]) {
			int l = node.left;
			int r = node.right;
			
			if(l != -18) inorder(l);
			sb.append((char)(start+'A'-1));
			if(r != -18) inorder(r);
		}
	}
	
	static void postorder(int start) {
		for(Node node : list[start]) {
			int l = node.left;
			int r = node.right;
			
			if(l != -18) postorder(l);
			if(r != -18) postorder(r);
			sb.append((char)(start+'A'-1));
		}
	}
}