
package BinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Inorder {

    void printInorder(Node tree){
        if(tree == null) return;
        printInorder(tree.left);
        System.out.print(tree.key + " ");
        printInorder(tree.right);
    }
    
    public Inorder() {
        Scanner lea = new Scanner();
        Node tree = new Node(18);
        tree.left = new Node(3);
        tree.left.left = new Node(8);
        tree.left.right = new Node(16);
        tree.left.left.left = new Node(7);
        tree.left.left.right = new Node(11);
        tree.left.right.left = new Node(5);
        tree.left.right.right = new Node(12);
        
        printInorder(tree);
    }
    
    public static void main(String[] args) {
        Inorder obj = new Inorder();
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
        
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }
}
