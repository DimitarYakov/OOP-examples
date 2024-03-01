/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

/**
 *
 * @author thanos
 */
public class Memento {
     private String text;

    public Memento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
