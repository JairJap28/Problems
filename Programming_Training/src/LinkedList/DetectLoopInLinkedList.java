
package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class DetectLoopInLinkedList {
    
    Node head;
    
    void insert(int d){
        if(head == null)head = new Node(d);
        
        else{
            Node tmp = head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new Node(d);
        }
    }
    
    boolean checkLoop(Node head){
        Node tmp = head;
        HashSet<Node> checking = new HashSet<>();
        while(tmp != null){
            if(checking.contains(tmp)){
                return true;
            }
            checking.add(tmp);
            tmp = tmp.next;
        }
        return false;        
    }

    public DetectLoopInLinkedList() throws IOException {
        Scanner lea = new Scanner();
        int n = lea.nextInt();
        for (int i = 0; i < n; i++) {
            int aux = lea.nextInt();
            insert(aux);
        }
        Node p; //Para crear el loop 
        Node q; //Tomado de geeks for geeks
        p = head;
        q = head;
        while (q.next != null) {
            q = q.next;
        }
        int c = lea.nextInt();
        if (c > 0) {
            c = c - 1;
            for (int i = 0; i < c; i++) {
                p = p.next;
            }
            q.next = p;
        }
        
        System.out.println(checkLoop(head));
        
    }   
    
    public static void main(String[] args) throws IOException {
        new DetectLoopInLinkedList();
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
