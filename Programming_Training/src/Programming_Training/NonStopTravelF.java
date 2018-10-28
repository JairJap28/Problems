//Implementation with Floyd Warshall
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NonStopTravelF {
    //D is a weights' copy where it will be assigned the lenght of the roads
    int d[][];
    //Relationship with parents to find the path to be necessary 
    int parent[][];
    int INF = 1000;
    
    //Floyd-Warshall algorithm, finds all the distances between every pair of vertex
    
    boolean check(int xGo, int yGo){
        return parent[xGo][yGo] != xGo && parent[xGo][yGo] != yGo;
    }
    
    String printPath(int xGo, int yGo){
        String aux = "";
        while(check(xGo, yGo)){
            aux = parent[xGo][yGo] + aux;
            yGo = parent[xGo][yGo];
            if(check(xGo, yGo)){
                aux = " " + aux;
            }
        }
        return aux;
    }
        
    void floyd(AdyacencyMatrix g){
        int i, j, k;
        int through_k;
        int n = g.nVertex;
        d = new int[n][n];
        parent = new int[n][n];
        
        for(i = 0; i < n; i++){ //height of the matrix
            for(j = 0; j < n; j++){ //width of the matrix
                d[i][j] = g.weights[i][j];
                parent[i][j] = i;
                //if the distance is INF then the node doesn't exist
                if(d[i][j] == INF){
                    parent[i][j] = -1;
                }
            }
        }
        
        //the distance of himself is 0
        for(i = 0; i < n; i++){
            d[i][i] = 0;
        }
        
        for(k = 0; k < n; k++){ //width of the matrix
            for(i = 0; i < n; i++){ //height of the matrix
                for(j = 0; j < n; j++){ //width of the matrix
                    through_k = d[i][k] + d[k][j];
                    if(through_k < d[i][j]){
                        d[i][j] = through_k;
                        parent[i][j] = parent[k][j];
                    }
                }
            }
        }
    }

    public NonStopTravelF() throws IOException {
        Scanner sc = new Scanner();
        AdyacencyMatrix g = new AdyacencyMatrix();
        
        int c = 1;
        
        while(true){
            int NI = sc.nextInt();
            
            if(NI == 0){
                break;
            }
            
            g.newGraph(NI);

            for(int i = 0; i < NI; i++){
                int aux = sc.nextInt();
                for(int j = 0; j < aux; j++){
                    int interception = sc.nextInt();
                    int delay = sc.nextInt();
                    g.insertEdge(i + 1, interception, delay, true);
                }
            }

            int xGo = sc.nextInt();
            int yGo = sc.nextInt();
            floyd(g);
            String cad = printPath(xGo, yGo);
            if(!cad.equals("")){
                cad = " " + cad + " ";
            }
            else{
                cad = " ";
            }
            System.out.println("Case " + c + ": Path = " + xGo + cad +yGo + "; " + d[xGo][yGo] + " second delay");
            c++;
        }
    }

    public static void main(String[] args) throws IOException {
        new NonStopTravelF();
    }
    
    class AdyacencyMatrix{
        //Maximun amount of vertex starting from 1
        int MAXVERTEX = 1001;
        //MaxInt for the nodes who don't have connection
        //The diameter has to be less than MaxInt
        int weights[][] = new int[MAXVERTEX][MAXVERTEX];
        int nVertex = 0;
        int maxValue = 10000000; //It is Intyeger.maxInt because overflow the roads
        
        //Create a new graph of n vertex quickly
        
        void newGraph(int vertex){
            for(int i = 0; i <= vertex; i++){
                Arrays.fill(weights[i], maxValue);
            }
            nVertex = vertex + 1;
        }
        
        //insert an edge of X to Y in the grapgh
        void insertEdge(int x, int y, int w, boolean directed){
            weights[x][y] = Math.min(w, weights[x][y]);
            if(!directed){
                insertEdge(y, x, w, true);
            }
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
                StringBuilder out = new  StringBuilder();
                while(st.hasMoreTokens()){
                    out.append(st.nextToken());
                    if(st.countTokens() > 0){
                        out.append(" ");
                    }
                }
                return out.toString();
            }
            return br.readLine();
        }
        
        String next() throws IOException{
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        boolean hasNext() throws IOException{
            while(!st.hasMoreTokens()){
                String line = br.readLine();
                if(line == null){
                    return false;
                }
                if(line.equals("")){
                    spaces++;
                }
                st = new StringTokenizer(line);
            }
            return true;
        }
        
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }
    
}
