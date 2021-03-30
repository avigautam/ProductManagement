/*
 * This code is developed by Avinash Gautam.
 *
 * While preparing for Java 11 certification on Oracle University online platform.
 *
 * For more information connect me on avigautam.knit@gmail.com
 */

package org.avi.productmanagement.products;

import org.avi.productmanagement.constants.Rating;

import java.time.LocalDate;

public class Food extends Product{

    private LocalDate bestBefore;

    public Food(int id, String name, double price, Rating rating, LocalDate bestBefore) {
        this(id, name, price, rating);
        this.bestBefore = bestBefore;
    }

    public Food(int id, String name, double price, Rating rating) {
        super(id, name, price, rating);
    }

    public Food(int id, double price, String name) {
        this(id, name, price, Rateable.DEFAULT_RATING);
    }

    @Override
    public String toString(){
        return super.toString() + " " + bestBefore;
    }

    @Override
    public Product applyRating(Rating rating) {
        return new Food(getId(), getName(), getPrice(), rating, LocalDate.now());
    }
}
