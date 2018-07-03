/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class LazyJem {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {

            int cases = lea.nextInt();
            for (int t = 0; t < cases; t++) {
                int n = lea.nextInt();
                int b = lea.nextInt();
                long m = lea.nextInt();

                long sum = 0;
                long aux;
                while (n > 1) {
                    if (n % 2 == 1) {
                        aux = ((n + 1) / 2);
                        sum += aux * m;
                    } else {
                        aux = (n / 2);
                        sum += aux * m;
                    }

                    m *= 2;
                    sum += b;
                    n -= aux;
                }

                sum += m;
                so.println(sum);
            }

        }
    }

    static class Scanner {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");

        public String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public int nextLong() throws IOException {
            return (int) Long.parseLong(next());
        }
    }

}
