
package BinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Insertion {
    
    Node root;
    Node temp = root;
    
    void inOrder(Node temp){
        if(temp == null) return;
        inOrder(temp.left);
        System.out.print(temp.key + " ");
        inOrder(temp.right);
    }
    
    void insert(Node temp, int key){
        Queue<Node> q = new LinkedList<>();
        q.add(temp);
        
        //Do level order traversal until we find an empty place
        while(!q.isEmpty()){
            temp =  q.peek();
            q.remove();
            if(temp.left == null){
                temp.left = new Node(key);
                break;
            }
            else
                q.add(temp.left);
            
            if(temp.right == null){
                temp.right = new Node(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

    public Insertion() {
        Scanner lea = new Scanner();
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        
        System.out.println("Inorder traversal before insertion");
        inOrder(root);
        
        int key = 12;
        insert(root, key);
        
        System.out.println("\nInorder traversal after insertion");
        inOrder(root);
    }
    
    public static void main(String[] args) {
        Insertion obj = new Insertion();
    }
    
    class Node{
        int key;
        Node left;
        Node right;
        
        public Node(int k){
            this.key = k;
            left = null;
            right = null;
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
            spaces = 0;
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
