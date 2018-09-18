
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class Beepers {
       
    int MAX = 11;
    int INF = 1 << 30;
    int[] xCoordinate = new int[MAX];
    int[] yCoordinate = new int[MAX];
    int[][] distance = new int[MAX][MAX];
    int[][] DPMemo = new int[MAX][1 << MAX];
    
    int numBeepers;
    
    int solve(int index, int mask){ //TCP algorithm
        if(mask == (1 << (numBeepers + 1)) - 1){
            return distance[index][0];
        }
        if(DPMemo[index][mask] != -1){
            return DPMemo[index][mask];
        }
        DPMemo[index][mask] = INF;
        
        for(int i = 0; i <= numBeepers; i++){
            if(i != index && (mask & (1 << i)) == 0){
                DPMemo[index][mask] = Math.min(DPMemo[index][mask], solve(i, mask ^ (1 << i)) + distance[index][i]);
            }
        }    
        
        return DPMemo[index][mask];
    }
    
    void init(){
        for(int i = 0; i < MAX; i++){
            for(int j = 0; j < MAX; j++){
                distance[i][j] = 0;
            }
        }
        
        Arrays.fill(xCoordinate, 0);
        Arrays.fill(yCoordinate, 0);
    }
    
    public Beepers() throws IOException {
        Scanner sc = new Scanner();
        
        int t = sc.nextInt();
        for(int cases = 0; cases < t; cases++){
            int xSize = sc.nextInt();
            int ySize = sc.nextInt();

            init();
            
            xCoordinate[0] = sc.nextInt();
            yCoordinate[0] = sc.nextInt();

            numBeepers = sc.nextInt();

            //It starts from 1 because the 0 position is the Karel position
            for(int i = 1; i <= numBeepers; i++){ 
                xCoordinate[i] = sc.nextInt();
                yCoordinate[i] = sc.nextInt();
            }

            for(int i = 0; i <= numBeepers; i++){
                for(int j = 0; j <= numBeepers; j++){
                    distance[i][j] = Math.abs(xCoordinate[i] - xCoordinate[j]) + Math.abs(yCoordinate[i] - yCoordinate[j]);
                }
            }

            for(int i = 0; i <= 10; i++){
                for(int j = 0; j <= 1025; j++){
                    DPMemo[i][j] = -1;
                }
            }

            System.out.println("The shortest path has length " + solve(0, 1));
        }
    }
    
    public static void main(String[] args) throws IOException {
        Beepers beepers = new Beepers();
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        
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
