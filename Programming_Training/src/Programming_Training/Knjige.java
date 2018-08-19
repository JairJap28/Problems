
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Knjige {

    Node addTop(Node pileBooks, int label){
        Node tmp = null;
        if(pileBooks == null){
            return new Node(label);
        }
        else{
            tmp = new Node(label);
            tmp.next = pileBooks;
        }
        return tmp;
    }
    
    Node addBottom(Node pileBooks, int label){
        if(pileBooks == null){
            return new Node(label);
        }
        else{
            Node tmp = pileBooks;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            
            tmp.next = new Node(label);
        }
        return pileBooks;
    }
    
    Node deleteBook(Node pileBooks, int label){
        
        Node tmp = pileBooks;
        int counter = 1;
        while(tmp.next != null){
            if(label == 0){
                tmp = tmp.next;
                return tmp;
            }
            if(counter == label){
                tmp.next = tmp.next.next;
                return pileBooks;
            }
            tmp = tmp.next;
            counter++;
        }
        
        return pileBooks;
    }
    
    boolean checkOrder(Node pileBooks){
        int actual = pileBooks.label;
        pileBooks = pileBooks.next;
        while(pileBooks != null){
            
            if(actual > pileBooks.label){
                return false;
            }
            actual = pileBooks.label;
            pileBooks = pileBooks.next;
            
        }
        
        return true;
    }
    
    int getPos(Node pileBooks, int label){
        Node tmp = pileBooks;
        int counter = 0;
        while(tmp.next != null){
            if(tmp.label == label){
                return counter;
            }
            counter++;
            tmp = tmp.next;
        }
        
        return counter;
    }
    
    public Knjige() throws IOException {
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        Stack<Integer> pile = new Stack<>();
        
        Node pileBooks = null;
        
        for (int i = 0; i < n; i++) {
            pileBooks = addBottom(pileBooks, sc.nextInt());
        }
        
        int counter = 0;
        while(!checkOrder(pileBooks)){
            int pos = getPos(pileBooks, n - 1);
            int posN = getPos(pileBooks, n);
            
            if(pos > posN){
                int labelBook = n - 1;  
                pileBooks = deleteBook(pileBooks, pos);
                pileBooks = addTop(pileBooks, labelBook);
                counter++;
            }
            n--;
            
        }
        
        System.out.println(counter);
    }
    
    public static void main(String[] args) throws IOException {
        Knjige obj = new Knjige();
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int spaces = 0;
        
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
        int label;
        Node next;
        public Node(int label){
            this.label = label;
            this.next = null;
        }
    }
    
}
