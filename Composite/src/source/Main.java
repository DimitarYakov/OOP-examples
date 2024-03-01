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
        // Създаване на компоненти
        Leaf leaf1 = new Leaf("Leaf 1");
        Leaf leaf2 = new Leaf("Leaf 2");
        Leaf leaf3 = new Leaf("Leaf 3");

        // Създаване на компонент-контейнер
        Composite composite = new Composite();
        composite.add(leaf1);
        composite.add(leaf2);

        // Вложено добавяне
        Composite nestedComposite = new Composite();
        nestedComposite.add(leaf3);
        composite.add(nestedComposite);

        // Изпълнение на операция върху цялата структура
        composite.operation();
    }
    
}
