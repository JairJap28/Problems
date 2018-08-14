
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuadTrees {
    int auxIndex;

    public QuadTrees() throws IOException {
        Scanner lea = new Scanner();
        
        int cases = lea.nextInt();
        for (int t = 0; t < cases; t++) {
            String in1 = lea.next();
            String in2 = lea.next();

            Node tree_one = new Node();
            tree_one = tree_one.Build(in1, 0);
            auxIndex = 0;
            Node tree_two = new Node();
            tree_two = tree_two.Build(in2, 0);

            Node tree_final = new Node();
            tree_final = tree_final.Build(tree_one.start(tree_one, tree_two), 0);
            System.out.println(tree_one.start(tree_one, tree_two));
            System.out.println("There are " + tree_final.search(tree_final) + " black pixels.");
        }
    }    
    
    public static void main(String[] args) throws IOException {
        QuadTrees init = new QuadTrees();
    }
    
    class Node{
        char data;
        Node quad_1;
        Node quad_2;
        Node quad_3;
        Node quad_4;
        
        public Node(){};
        
        public Node(char data){
            this.data = data;
            this.quad_1 = null;
            this.quad_2 = null;
            this.quad_3 = null;
            this.quad_4 = null;
        }
        
        int search(Node end){
            int sum = 0;
            sum += valueSum(end.quad_1, 1);
            sum += valueSum(end.quad_2, 1);
            sum += valueSum(end.quad_3, 1);
            sum += valueSum(end.quad_4, 1);
            return sum;
        }
        
        int valueSum(Node quad, int level){
            int sum = 0;
            if(quad.data == 'p') sum += auxValueSum(quad, level);
            else if(quad.data == 'f') sum += getValue(level);
            return sum;
        }
        
        int auxValueSum(Node quad, int level){
            int sum = 0;
            sum += valueSum(quad.quad_1, level + 1);
            sum += valueSum(quad.quad_2, level + 1);
            sum += valueSum(quad.quad_3, level + 1);
            sum += valueSum(quad.quad_4, level + 1);
            return sum;
        }
        
        int getValue(int level){
            int value = 1024;
            for (int i = 1; i <= level; i++) {
                value /= 4;
            }
            return value;
        }
                
        String start(Node tree_one, Node tree_two){
            StringBuilder out = new StringBuilder();
            out.append("p");
            out.append(Compare(tree_one.quad_1, tree_two.quad_1));
            out.append(Compare(tree_one.quad_2, tree_two.quad_2));
            out.append(Compare(tree_one.quad_3, tree_two.quad_3));
            out.append(Compare(tree_one.quad_4, tree_two.quad_4));
            
            return out.toString();
        }
        
        String auxStart(Node p, Node e){
             
            StringBuilder out = new StringBuilder();
            out.append("p");
            out.append(Compare(p.quad_1, e));
            out.append(Compare(p.quad_2, e));
            out.append(Compare(p.quad_3, e));
            out.append(Compare(p.quad_4, e));
            return out.toString();
        }
        
        String Compare(Node one, Node two){
            StringBuilder out = new StringBuilder();
            if(one.data == 'p' && two.data == 'e'){
                out.append(auxStart(one, two));
            }
            else if(one.data == 'e' && two.data == 'p'){
                out.append(auxStart(two, one));
            }
            else{
                out.append(letter(one, two));
            }
            return out.toString();
        }
        
        String letter(Node one, Node two){
            if(one.data == 'e' && two.data == 'e') return "e";
            if(one.data == 'f' || two.data == 'f') return "f";
            return "";
        }
        
        Node Build(String in, int index){
            int countParent = 0;
            Node tree = new Node('p');
            int i;

            for (i = index; i < in.length() && countParent < 4; i++) {
               if(in.charAt(i) == 'p' && i != 0){
                   countParent++;
                   switch(countParent){
                       case 1: tree.quad_1 = Build(in, i + 1); break;
                       case 2: tree.quad_2 = Build(in, i + 1); break;
                       case 3: tree.quad_3 = Build(in, i + 1); break;
                       default:tree.quad_4 = Build(in, i + 1); break;
                   }
                   int tmp = i;
                   i = auxIndex;
               }
               else if(i != 0){
                   countParent++;
                   switch(countParent){
                        case 1: tree.quad_1 = new Node(in.charAt(i)); break;
                        case 2: tree.quad_2 = new Node(in.charAt(i)); break;
                        case 3: tree.quad_3 = new Node(in.charAt(i)); break;
                        default: tree.quad_4 = new Node(in.charAt(i)); break;
                    }
               }
            }
            auxIndex = i - 1;
            return tree;
        }
        
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int spaces = 0;
        
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
