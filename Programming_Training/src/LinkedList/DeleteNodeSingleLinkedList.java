package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DeleteNodeSingleLinkedList {
    
    
    Node addToTheLast(Node head, Node node){
        if(head == null){
            head = node;
        }
        else{
            Node tmp = head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = node;
        }
        return head;
    }
    
    Node deleteNode(Node head,int data){
        
        if(head.next == null && data == 1) {
            return null;
        }
        
        
        Node tmp = head;
        int counter = 1;
        
        while(tmp.next != null){
            if(data == 1){
                tmp = tmp.next;
                return tmp;
            }
            if(counter == data - 1){
                tmp.next = tmp.next.next;
                return head;
            }
            tmp = tmp.next;
            counter++;
        }
        return head;
    }
    
    void printList(Node head){
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println("");
    }
    

    public DeleteNodeSingleLinkedList() throws IOException {
        Scanner lea = new Scanner();
        
        int n = lea.nextInt();
        
        Node head = null;
        
        for (int i = 0; i < n; i++) 
            head = addToTheLast(head, new Node(lea.nextInt()));
        
        int x = lea.nextInt();
        head = deleteNode(head, x);
        printList(head);
    }
    
    public static void main(String[] args) throws IOException {
        new DeleteNodeSingleLinkedList();
    }
    
    class Node{
        Node next;
        int data;
        
        public Node(int d){
            this.data = d;
            this.next = null;
        }
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int spaces = 0;
        
        String nextLine() throws IOException{
            if(spaces > 0){
                spaces--;
                return "";
            }
            else if(st.hasMoreTokens()){
                StringBuilder out = new StringBuilder();
                while(st.hasMoreTokens()){
                    out.append(st.nextToken());
                    if(st.countTokens() > 0) out.append(" ");
                }
                return out.toString();
            }
            return br.readLine();
        }
        
        boolean hasNext() throws IOException{
            while(!st.hasMoreTokens()){
                String line = br.readLine();
                if(line == null) return false;
                if(line.equals("")) spaces++;
                st = new StringTokenizer(line);
            }
            return true;
        }
        
        String next() throws IOException{
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }
    
}
