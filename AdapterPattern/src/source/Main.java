/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author thanos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyMouseListener myMouseListener = new MyMouseListener();
        MyMouseAdapter adapter = new MyMouseAdapter(myMouseListener);

        // Създаваме фиктивен компонент JPanel
        JPanel panel = new JPanel();

        // Симулираме кликване на бутон
        adapter.mouseClicked(new MouseEvent(panel, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 0, 0, 1, false));


        // Резултатът от тази операция ще бъде изведен в конзолата:
        // Button clicked
    }
    
}
