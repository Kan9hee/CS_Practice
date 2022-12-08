import java.io.*;

public class Test5639 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb=new StringBuilder();

    static class Node{  //���� Ʈ���� ��� Ŭ����
        int value;      //����� ��
        Node left,right;//����� ��,���� �ڽĳ��

        public Node(int value){
            this.value=value;
            this.left=null;
            this.right=null;
        }
        public void setValue(int temp){this.value=temp;}
        public void setLeft(Node temp){this.left=temp;}
        public void setRight(Node temp){this.right=temp;}
        public int getValue(){return value;}
        public Node getLeft(){return left;}
        public Node getRight(){return right;}
    }

    static void push(Node temp,int value){  //���� Ʈ�� ���� �޼ҵ�
        if(value<temp.value){               //���� ��庸�� ���� ����
            if(temp.getLeft()!=null)        //���� ����Ʈ���� �̵��Ѵ�.
                push(temp.getLeft(),value);
            else                            //���� ���� ����� ���� �ڽĳ�尡 ���� ���, ���� �߰��Ѵ�.
                temp.setLeft(new Node(value));
        }
        else{                               //���� ��庸�� ū ����
            if(temp.getRight()!=null)       //���� ����Ʈ���� �̵��Ѵ�.
                push(temp.getRight(),value);
            else                            //���� ���� ����� ���� �ڽĳ�尡 ���� ���, ���� �߰��Ѵ�.
                temp.setRight(new Node(value));
        }
    }

    static void postOrder(Node temp){   //������ȸ
        if(temp==null)
            return;
        postOrder(temp.getLeft());
        postOrder(temp.getRight());
        sb.append(temp.getValue()).append("\n");
    }

    public static void main(String[] args)throws IOException{
        String input=br.readLine();
        Node root=new Node(Integer.parseInt(input));    //�ʱ� ��Ʈ��� ����

        while(true){
            input=br.readLine();
            if(input==null||input.equals(""))   //���̻� �Է��� ���� ���� ���, �ݺ����� �����Ѵ�.
                break;
            push(root,Integer.parseInt(input)); //�Է¹��� ���� ������� ���� Ʈ���� ���ο� ��带 �����Ѵ�.
        }

        postOrder(root);
        System.out.println(sb.toString());
        br.close();
    }
}
