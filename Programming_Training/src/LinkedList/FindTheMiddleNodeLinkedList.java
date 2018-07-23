
package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindTheMiddleNodeLinkedList {
    
    
    Node middleNode(Node head){
        int middleIndex = getCount(head) / 2;
        int counter = 0;
        
        Node middle = null;
        
        while(head != null){
            if(counter == middleIndex) middle = head;
            counter++;
            head = head.next;
        }
        return middle;
    }
    
    int getCount(Node head){
        if(head == null) return 0;
        else return 1 + getCount(head.next);
    }
    
    Node insert(Node head, char d){
        if(head == null) return new Node(d);
        
        head.next = insert(head.next, d);
        
        return head;
    }

    public FindTheMiddleNodeLinkedList() throws IOException {
        Scanner lea = new Scanner();
        
        int n = lea.nextInt();
        Node head =  null;
        for (int i = 0; i < n; i++) {
            char aux = lea.next().charAt(0);
            head = insert(head, aux);
        }
        
        Node middle = middleNode(head);
        System.out.println(middle.data);
        
    }
    
    public static void main(String[] args) throws IOException {
       new FindTheMiddleNodeLinkedList();
    }
    
    class Node{
        Node next;
        char data;
        
        public Node(char d){
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
                    if(st.countTokens() > 0)out.append(" ");
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
