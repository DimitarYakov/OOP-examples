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
        // Създаване на основен компонент
        Component component = new ConcreteComponent();

        // Декориране на компонента с различни декоратори
        Component decoratedComponentA = new ConcreteDecoratorA(component);
        Component decoratedComponentB = new ConcreteDecoratorB(decoratedComponentA);

        // Извикване на операцията на декорираните компоненти
        decoratedComponentA.operation();
        decoratedComponentB.operation();
    }
    
}
