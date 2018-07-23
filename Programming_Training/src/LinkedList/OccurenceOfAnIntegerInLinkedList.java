
package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OccurenceOfAnIntegerInLinkedList {
    
    Node insert(Node head, int a){
        if(head == null) return new Node(a);
        head.next = insert(head.next, a);
        return head;
    }
    
    int countOccurrences(Node head, int x){
        Node tmp = head;
        int counter = 0;
        while(tmp != null){
            if(tmp.data == x) counter++;
            tmp = tmp.next;
        }
        return counter;
    }

    public OccurenceOfAnIntegerInLinkedList() throws IOException {
        Scanner lea = new Scanner();
        int n = lea.nextInt();
        Node head = null;
        for (int i = 0; i < n; i++) {
            int aux = lea.nextInt();
            head = insert(head, aux);
        }
        
        int x = lea.nextInt();
        
        System.out.println(countOccurrences(head, x));
    }
    
    public static void main(String[] args) throws IOException {
        new OccurenceOfAnIntegerInLinkedList();
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
