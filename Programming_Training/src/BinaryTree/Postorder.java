
package BinaryTree;

public class Postorder {
    
    void printPosorder(Node tree){
        if(tree == null) return;
        printPosorder(tree.left);
        printPosorder(tree.right);
        System.out.print(tree.key + " ");
    }

    public Postorder() {
        Node tree = new Node(5);
        tree.left = new Node(12);
        tree.left.left = new Node(11);
        tree.left.right = new Node(18);
        tree.left.left.left = new Node(8);
        tree.left.left.right = new Node(3);
        tree.left.right.left = new Node(7);
        tree.left.right.right = new Node(16);
        
        printPosorder(tree);
    }
    
    public static void main(String[] args) {
        Postorder obj = new Postorder();
    }
    
    class Node{
        int key;
        Node left;
        Node right;
        
        public Node(int key){
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }
}
