
package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReverseLinkedList {
    
    Node headAux;
    
    Node insert(Node head, int d){
        if(head == null) return new Node(d);
        head.next = insert(head.next, d);
        return head;
    }
    
    Node reverseByIteration(Node head){
        
        Node prev = null;
        Node next = null;
        Node curr = head;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
        
        return head;
    } //0.31
        
    void printList(Node head){
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public ReverseLinkedList() throws IOException {
        Scanner lea = new Scanner();
        int n = lea.nextInt();
        Node head = null;
        for (int i = 0; i < n; i++) 
            head = insert(head, lea.nextInt());
        
        head = reverseByIteration(head);
        printList(head);
        
    }
    //From here to the top there are methods or functiosn
    public static void main(String[] args) throws IOException {
        new ReverseLinkedList();
    }
    //From here to below there are classes
    
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
                while(!st.hasMoreTokens()){
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
