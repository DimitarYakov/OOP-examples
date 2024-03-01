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
        ChatMediator mediator = new ChatMediatorImpl();

        User user1 = new User(mediator, "User1");
        User user2 = new User(mediator, "User2");
        User user3 = new User(mediator, "User3");

        user1.sendMessage("Hello from User1");
    }
    
}
