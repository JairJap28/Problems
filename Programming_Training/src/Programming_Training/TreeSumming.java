package Programming_Training;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TreeSumming {
    
    String tree = "";
    int test;
    int posChecked;
    
    public TreeSumming() throws IOException{
        Scanner lea = new Scanner();
        
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            while(lea.hasNext()){
                posChecked = 1;
                tree = "";
                test = lea.nextInt();
                String in;
                int balancer = 0;
                do{
                    in = lea.next();
                    tree += in;
                    for (int i = 0; i < in.length(); i++) {
                        if(in.charAt(i) == '(') balancer++;
                        else if(in.charAt(i) == ')') balancer--;
                    }
                }while(balancer != 0);

                Node root = new Node();
                boolean flag = root.checkFinal(0);
                if(flag) so.println("yes");
                else so.println("no");
            }
        }
    }
    
    public class Node{
        Node left;
        Node right;
        Integer value = null;

        public Node() {
            
            if(tree.charAt(posChecked) == ')'){
                this.value = null;
            }
            else{
                this.value = Integer.parseInt(tree.substring(posChecked, tree.indexOf("(", posChecked)));
                posChecked = tree.indexOf("(", posChecked) + 1;
                this.left = new Node();
                posChecked = tree.indexOf("(", posChecked) + 1;
                this.right = new Node();
            }
        }
        
        public boolean isLeaf(){
            return (this.left.value == null && this.right.value == null);
        }
        
        
        public boolean checkFinal(int sum){
            
            if(this.value == null){
                return false;
            }
            else{
                sum += this.value;
           
                if(this.isLeaf()){
                    return sum == test;
                }
                else{
                    if(this.left.checkFinal(sum)){
                        return true;
                    }
                    else if(this.right.checkFinal(sum)){
                        return true;
                    }
                    else return false;
                }
            }
        }
        
    }

    public static void main(String[] args) throws IOException {
        new TreeSumming();
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int espacios = 0;
        
        public String next() throws IOException{
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        public boolean hasNext() throws IOException{
            while (!st.hasMoreTokens()) {
                String linea = br.readLine();
                if(linea == null) return false;
                if(linea.equals("")) espacios++;
                st = new StringTokenizer(linea);
            }
            return true;
        }
        
        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }
    
}
