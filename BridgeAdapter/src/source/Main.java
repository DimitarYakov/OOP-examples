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
        // Създаване на устройства
        Device tv = new TV();
        Device radio = new Radio();

        // Създаване на адаптери за управление
        Remote tvRemote = new TVRemote(tv);
        Remote radioRemote = new RadioRemote(radio);

        // Използване на адаптерите за включване на устройствата
        tvRemote.power(); // Включване на телевизора
        radioRemote.power(); // Включване на радиото
    }
    
}
