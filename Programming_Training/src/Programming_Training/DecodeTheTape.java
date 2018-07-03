/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.util.Scanner;

/**
 *
 * @author Hermanos-Jimenez
 */
public class DecodeTheTape {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        String in = lea.nextLine();
        boolean flag = false;
        if(in.equals("___________")){
            flag = true;
        }
        while(flag){
            in = lea.nextLine();
            if(in.equals("___________")){
                break;
            }
            in = in.replace("| ", "").replace("|", "").replace(".", "").replace("o", "1").replace(" ", "0");
            char a = (char) (Integer.parseInt(in, 2));
            System.out.print(a);
        }
    }
}
