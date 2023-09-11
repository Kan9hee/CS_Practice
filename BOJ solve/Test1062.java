import java.io.*;
import java.util.*;

public class Test1062 {
    static int N,K;
    static int result=Integer.MIN_VALUE;
    static String[] words;
    static boolean[] checklist;

    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken()) - 5;
        words=new String[N];

        for(int i=0;i<N;i++){
            String word=br.readLine();
            word = word.replace("anta", "");
            word = word.replace("tica", "");
            words[i]=word;
        }
        
        if(K>=26){
            result=N;
        }else if(K<0){
            result=0;
        }else{
            checklist=new boolean[26];
            checklist['a'-'a']=true;
            checklist['c'-'a']=true;
            checklist['i'-'a']=true;
            checklist['n'-'a']=true;
            checklist['t'-'a']=true;

            Backtracking(0, 0);
        }

        System.out.println(result);
    }

    private static void Backtracking(int alphabet,int length){
        if(length==K){
            int count=0;
            for(String word:words){
                boolean success=true;
                for(char letter:word.toCharArray())
                    if(!checklist[letter-'a']){
                        success=false;
                        break;
                    }
                if(success)
                    count++;
            }
            result=Math.max(result, count);
            return;
        }

        for(int i=alphabet;i<26;i++){
            if(!checklist[i]){
                checklist[i]=true;
                Backtracking(i, length+1);
                checklist[i]=false;
            }
        }
    }
}
