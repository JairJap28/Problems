/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author Hermanos-Jimenez
 */
public class GrammarEvaluation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        
        
        ScriptEngineManager mqr = new ScriptEngineManager();
        ScriptEngine engine = mqr.getEngineByName("JavaScript");
        String in = lea.next();
        try {
            System.out.println(engine.eval(in));
        } catch (ScriptException ex) {
            System.out.println("Error");
        }
    }
    
    
    
}
