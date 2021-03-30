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

    private LocalDate expiryDate;

    public Food(int id, String name, Rating rating, LocalDate expiryDate) {
        super(id, name, rating);
        this.expiryDate = expiryDate;
    }
}
