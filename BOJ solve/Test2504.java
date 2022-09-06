import java.util.*;
import java.io.*;
import java.lang.String;
public class Test2504 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Stack<Character>stack=new Stack<Character>();
        HashMap<Character,Integer>match=new HashMap<Character,Integer>();
        int result=0,temp=1;
        match.put('(', 2);
        match.put('[',3);
        String input=br.readLine();
        for(int i=0;i<input.length();i++){
            char check=input.charAt(i);
            if(check=='('||check=='['){
                stack.push(check);
                temp*=match.get(check);
            }
            else if(!stack.isEmpty()&&(stack.peek()=='('&&check==')'||
                    stack.peek()=='['&&check==']')){
                char poped=stack.pop();
                if(input.charAt(i-1)==poped)
                    result+=temp;
                temp/=match.get(poped);
            }
            else{
                result=0;
                break;
            }
        }
        if(!stack.isEmpty())
            result=0;
        System.out.println(result);
        br.close();
    }
}
