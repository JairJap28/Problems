
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NumberMaze {
    
    int MAXV = 1001;
    int INF = 10000;
    int n;
    int m;
    int cY[] = {0,1,0,-1};
    int cX[] = {-1,0,1,0};
    
    boolean intree[][];
    int distance[][];
    
    void dijstra(int graph[][], int xStart, int yStart){
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(yStart, xStart, graph[yStart][xStart]));
        int vX, vY;
        int auxX;
        int auxY;
        
        
        distance[xStart][yStart] = graph[xStart][yStart];
        
        while(!q.isEmpty()){
            Node current = q.poll();
            vX = auxX = current.x ;
            vY = auxY = current.y ;
            if(!intree[vY][vX]){
                intree[vY][vX] = true;
                for(int i = 0; i < 4; i++){
                    auxX += cX[i];
                    auxY += cY[i];
                    try{
                        if(!intree[auxY][auxX]){
                            if(distance[auxY][auxX] > (distance[vY][vX] + graph[auxY][auxX])){
                                distance[auxY][auxX] = distance[vY][vX] + graph[auxY][auxX];
                                q.add(new Node(auxY, auxX, distance[auxY][auxX]));
                            }
                        }
                    }catch(Exception e){}    

                    auxX -= cX[i];
                    auxY -= cY[i];
                }
            }
        }
        
    }

    public NumberMaze() throws IOException {
        Scanner sc = new Scanner();
        
        int cases = sc.nextInt();
        for(int c = 0; c < cases; c++){
            n = sc.nextInt(); //rows
            m = sc.nextInt(); //Columns
            int graph[][] = new int[n][m];
            intree = new boolean[n][m];
            distance = new int[n][m];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    graph[i][j] = sc.nextInt();
                    intree[i][j] = false;
                    distance[i][j] = INF;
                }
            }
            
            dijstra(graph, 0, 0);
            System.out.println(distance[n - 1][m - 1]);

        }
    }

    public static void main(String[] args) throws IOException {
        new NumberMaze();
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
    
    class Node implements Comparable<Node>{
        int x;
        int y;
        int w;
        
        public Node(int y, int x, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            if(this.w >= o.w){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
    
}
