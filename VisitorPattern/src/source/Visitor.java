package source;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thanos
 */
public interface Visitor {
    void visit(Book book);
    void visit(Movie movie);
}
