/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 *
 * @author thanos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle circle = new Circle();
        
        String file = "output.txt";
        
        
       String result = circle.getResult();
        
        
        try (FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            
            bufferedWriter.write(result); //Wrine the result on new line every time
            //bufferedWriter.newLine(); //This also write a new line but with \r\n
            bufferedWriter.close(); 
            
            System.out.println("Serialized data is saved in output.txt");
        }
        catch(IOException e){
            e.printStackTrace();
        }

        
        
    }
    
}
