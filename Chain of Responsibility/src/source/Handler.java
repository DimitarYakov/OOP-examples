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
public interface Handler {
    void handleRequest(Request request);
    void setNextHandler(Handler nextHandler);
}
