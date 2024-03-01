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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor("Initial text");
        TextEditorCaretaker caretaker = new TextEditorCaretaker();

        caretaker.addMemento(textEditor.save()); // Save initial state

        textEditor.setText("Modified text");
        caretaker.addMemento(textEditor.save()); // Save modified state

        System.out.println("Current text: " + textEditor.getText()); // Current text

        // Restore to initial state
        textEditor.restore(caretaker.getMemento(0));
        System.out.println("Restored text: " + textEditor.getText()); // Restored text
    }
    
}
