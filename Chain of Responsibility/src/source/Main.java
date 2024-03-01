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
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        
        handler1.setNextHandler(handler2);
        
        Request request1 = new Request(RequestType.TYPE1, "Request 1");
        Request request2 = new Request(RequestType.TYPE2, "Request 2");
        
        handler1.handleRequest(request1);
        handler2.handleRequest(request2);
        
    }
    
}
