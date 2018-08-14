
package BinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Preorder {
    
    void printPreorder(Node tree){
        if(tree == null) return;
        
        System.out.print(tree.key + " ");
        printPreorder(tree.left);
        printPreorder(tree.right);
    }

    public Preorder() {
        Scanner lea = new Scanner();
        
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right = new Node(3);
        
        printPreorder(tree);
    }

    public static void main(String[] args) {
        Preorder obj = new Preorder();
    }
    
    class Node{
        int key;
        Node left;
        Node right;
        
        public Node(int k){
            this.key = k;
            this.left = null;
            this.right = null;
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
    }
    
}
