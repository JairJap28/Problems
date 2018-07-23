
package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CheckIfLinkedListPalindrome {
    
    Node left;
    Node head;
    
    Node middleNode(Node head){
        
        int cant = getCant(head) / 2;
        int counter = 0;
        Node tmp = head;
        Node tmp2 = head;
        while(tmp != null){
            if(counter == cant) return tmp;
            tmp = tmp.next;
            counter++;
        }
        head = tmp2;
        return tmp;
    }
    
    Node reverse(Node head){
        
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
    }
    
    Node insert(Node head, int c){
        if(head == null) return new Node(c);
        head.next = insert(head.next, c);
        return head;
    }
     
    int getCant(Node head){
        Node tmp = head;
        int counter = 0;
        
        while(tmp != null){
            counter++;
            tmp = tmp.next;
        }
        
        return counter;
    }
    
    boolean isPalindrome(Node head){
        
        Node middle = middleNode(head);
        middle = reverse(middle);
        
        return compare(head, middle);
    }
    
    boolean isPalindromeRecursive(Node right){
        left = head;
        
        if(right == null) return true;
        
        if(!isPalindromeRecursive(right.next)) return false;
        
        boolean flag2 = (right.data == (left).data);
        
        left = left.next;
        return flag2;
    }
    
    boolean compare(Node first, Node second){
        Node tmp1 = first;
        Node tmp2 = second;
        boolean flag = true;
        while(tmp1 != null && tmp2 != null){
            if(tmp1.data != tmp2.data){
                flag = false;
            }
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        
        return flag;
    }
    

    public CheckIfLinkedListPalindrome() throws IOException {
        Scanner lea = new Scanner();
        int n = lea.nextInt();
        Node head = null;
        for (int i = 0; i < n; i++) 
            head = insert(head, lea.nextInt());
        this.head = head;
        System.out.println(isPalindromeRecursive(this.head)); //0.26
        System.out.println(isPalindrome(head)); //0.31
    }
    
    public static void main(String[] args) throws IOException {
        new CheckIfLinkedListPalindrome();
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
        
        boolean hesNext() throws IOException {
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
