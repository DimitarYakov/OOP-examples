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
public class Facade {
    private SubSystem1 subsystem1;
    private SubSystem2 subsystem2;

    public Facade() {
        this.subsystem1 = new SubSystem1();
        this.subsystem2 = new SubSystem2();
    }

    // Обобщен метод, който скрива сложността на вътрешните операции
    public void operation() {
        subsystem1.operation1();
        subsystem2.operation1();
    }
}
