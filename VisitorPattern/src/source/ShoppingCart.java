/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thanos
 */
public class ShoppingCart {
    private List<Element> items = new ArrayList<>();

    public void addItem(Element item) {
        items.add(item);
    }

    public void accept(Visitor visitor) {
        for (Element item : items) {
            item.accept(visitor);
        }
    }
}
