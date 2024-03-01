/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

/**
 *
 * @author thanos
 * @param <T>
 */
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
