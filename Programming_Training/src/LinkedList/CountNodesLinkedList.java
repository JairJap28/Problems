
package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountNodesLinkedList {
    
    Node insert(Node head, int a){
        if(head == null) 
            return new Node(a);
        
        head.next = insert(head.next, a);
        return head;
    }
    
    
    int countNodesIterative(Node head){ //0.22
        int count = 0;
        Node current = head;
        while(current != null){
            current = current.next;
            count++;
        }
        
        return count;
    }
    
    int countNodesRecursive(Node head){ //0.16
        if(head == null) return 0;
        return (1 + countNodesRecursive(head.next));
    }

    public CountNodesLinkedList() throws IOException {
        Scanner lea = new Scanner();
        int n = lea.nextInt();
        Node head = null;
        for (int i = 0; i < n; i++) {
            int aux = lea.nextInt();
            head = insert(head, aux);
        }
        
        System.out.println(countNodesIterative(head));
        System.out.println(countNodesRecursive(head));
        
    } 
    
    public static void main(String[] args) throws IOException {
        new CountNodesLinkedList();
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
