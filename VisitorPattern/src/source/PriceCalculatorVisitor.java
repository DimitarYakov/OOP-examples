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
public class PriceCalculatorVisitor implements Visitor {
    private double totalPrice = 0;

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public void visit(Book book) {
        totalPrice += book.getPrice();
    }

    @Override
    public void visit(Movie movie) {
        totalPrice += movie.getPrice();
    }
}
