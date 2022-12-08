import java.io.*;

public class Test5639 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb=new StringBuilder();

    static class Node{  //이진 트리의 노드 클래스
        int value;      //노드의 값
        Node left,right;//노드의 좌,우측 자식노드

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

    static void push(Node temp,int value){  //이진 트리 삽입 메소드
        if(value<temp.value){               //현재 노드보다 작은 값은
            if(temp.getLeft()!=null)        //왼쪽 서브트리로 이동한다.
                push(temp.getLeft(),value);
            else                            //만약 현재 노드의 좌측 자식노드가 없을 경우, 새로 추가한다.
                temp.setLeft(new Node(value));
        }
        else{                               //현재 노드보다 큰 값은
            if(temp.getRight()!=null)       //우측 서브트리로 이동한다.
                push(temp.getRight(),value);
            else                            //만약 현재 노드의 우측 자식노드가 없을 경우, 새로 추가한다.
                temp.setRight(new Node(value));
        }
    }

    static void postOrder(Node temp){   //후위순회
        if(temp==null)
            return;
        postOrder(temp.getLeft());
        postOrder(temp.getRight());
        sb.append(temp.getValue()).append("\n");
    }

    public static void main(String[] args)throws IOException{
        String input=br.readLine();
        Node root=new Node(Integer.parseInt(input));    //초기 루트노드 설정

        while(true){
            input=br.readLine();
            if(input==null||input.equals(""))   //더이상 입력을 받지 않을 경우, 반복문을 종료한다.
                break;
            push(root,Integer.parseInt(input)); //입력받은 값을 기반으로 이진 트리에 새로운 노드를 삽입한다.
        }

        postOrder(root);
        System.out.println(sb.toString());
        br.close();
    }
}
