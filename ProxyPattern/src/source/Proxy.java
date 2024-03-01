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
public class Proxy implements Subject{
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        // Допълнителна логика преди или след извикването на реалния обект
        System.out.println("Proxy: Pre-processing request.");
        realSubject.request();
        System.out.println("Proxy: Post-processing request.");
    }
}
