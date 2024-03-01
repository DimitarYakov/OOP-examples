/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thanos
 */
public class TextEditorCaretaker {
    private List<Memento> savedStates = new ArrayList<>();

    public void addMemento(Memento memento) {
        savedStates.add(memento);
    }

    public Memento getMemento(int index) {
        return savedStates.get(index);
    }
}
