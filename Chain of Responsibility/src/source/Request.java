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
public class Request {
    private final RequestType type;
    private final String content;

    public Request(RequestType type, String content) {
        this.type = type;
        this.content = content;
    }

    public RequestType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
