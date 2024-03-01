/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author thanos
 */
public class MyMouseAdapter extends MouseAdapter{
    private MyMouseListener listener;

    public MyMouseAdapter(MyMouseListener listener) {
        this.listener = listener;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        listener.onClick();
    }
}
