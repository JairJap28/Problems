package LinkedList;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class LinkedListInsertion {
    
    Node insertAddBegining(Node head, int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }
        else{
            Node tmp = head;
            head = node;
            head.next = tmp;
        }
        return head;
    }
    
    Node insertAtEnd(Node head, int data){
        Node node = new Node(data);
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
    
    void printList(Node head){
        Node tmp = head;
        while(tmp.next != null){
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println(tmp.data);
    }
    

    public LinkedListInsertion() throws IOException {
        Scanner lea = new Scanner();
        int n = lea.nextInt();
        
        Node head = null;
        
        for (int i = 0; i < n; i++) {
            int in = lea.nextInt();
            int type = lea.nextInt();
            
            head = (type == 0) ? insertAddBegining(head, in) : insertAtEnd(head, in);
        }
        printList(head);
    }

    public static void main(String[] args) throws IOException {
        new LinkedListInsertion();
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
                st = new StringTokenizer(br.readLine());
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
    
    class Node{
        Node next;
        int data;

        public Node(int d) {
            this.data = d;
            this.next = null;
        }
    }
}


