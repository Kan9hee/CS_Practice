import java.io.*;
import java.util.*;

public class Test5430{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static ArrayList<Integer>al=new ArrayList<>();

    static void ACWorking(String order,int size,String values){
        boolean right=true; //�迭�� �ùٸ��� ���ĵǾ����� Ȯ��
        st=new StringTokenizer(values,"[,]");   //�Էµ� ���ڿ����� ���ȣ�� ��ǥ�� �� �������� �����´�.
        for(int t=0;t<size;t++)
            al.add(Integer.parseInt(st.nextToken()));   //������ ���� ArrayList�� �����Ѵ�.
        
        for(int i=0;i<order.length();i++){  //��ɾ� Ȯ��
            if(order.charAt(i)=='R')    //��ɾ R�� ��� ���� �迭�� �������ٰ� �����Ѵ�.
                right=!right;
            else{   //��ɾ D�� ��� �迭 �� ���� ���� ���ش�.
                if(al.isEmpty()){   //���̻� �� ���� ���� ��� ���� �޽����� ����� �����Ѵ�.
                    sb.append("error\n");
                    return;
                }
                if(right)   //�迭�� �ùٸ��� ���ĵǾ��� ��� �� ���� ���� ���ش�.
                    al.remove(0);
                else    //�迭�� �������ٰ� �����Ǿ��ٸ� �� ���� ���� ���ش�.
                    al.remove(al.size()-1);  
            }
        }
        if(!right)  //��� ����ÿ��� �������� �����Ǿ�����
            Collections.reverse(al);    //��¥�� �����´�.
        sb.append(al.toString().replaceAll("\\s", "")+"\n");    //AllayList�� ���ڿ��� �ٲ� ��, ������ ���ش�.
    }

    public static void main(String[]args)throws IOException{
        int count=Integer.parseInt(br.readLine());  //�ݺ� Ƚ��

        for(int i=0;i<count;i++){
            String order=br.readLine(); //��ɾ�
            int size=Integer.parseInt(br.readLine());   //�迭 ũ��
            String values=br.readLine();    //�迭
            ACWorking(order, size, values);
            al.clear(); //���� ���� �� �ܿ� ArrayList�� ����
        }

        System.out.println(sb.toString());  //�� ��� ���
    }
}