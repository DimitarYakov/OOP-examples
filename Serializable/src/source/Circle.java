/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import sun.java2d.pipe.BufferedOpCodes;

/**
 *
 * @author thanos
 */
public class Circle extends Shape{
    @Override
    void draw(){
        System.out.println("Drawing a circle");
    }
    
    public static String getResult(){
        Circle circle = new Circle();
        StringBuilder sb = new StringBuilder();
        
        circle.draw();
        sb.append("Result: Drawing a circle\n"); 
        return sb.toString(); 
    }
}
