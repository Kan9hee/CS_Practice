import java.io.*;
import java.util.*;
public class test1764 {
    public static void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int nh=Integer.parseInt(st.nextToken());
        int ns=Integer.parseInt(st.nextToken());
        HashSet<String> people=new HashSet<String>();
        List<String>who=new ArrayList<String>();
        for(int i=0;i<nh+ns;i++){
            String temp=br.readLine();
            if(people.add(temp)==false)
                who.add(temp);
        }
        who.sort(Comparator.naturalOrder());
        System.out.println(who.size());
        for(int i=0;i<who.size();i++)
            System.out.println(who.get(i));
    }
}
