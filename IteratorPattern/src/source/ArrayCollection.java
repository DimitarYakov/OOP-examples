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
public class ArrayCollection<T> implements Aggregate<T> {
    private T[] array;

    public ArrayCollection(T[] array) {
        this.array = array;
    }

    @Override
    public Iterator<T> createIterator() {
        return new ArrayIterator<>(array);
    }
}
