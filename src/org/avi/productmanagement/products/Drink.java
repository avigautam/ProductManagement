/*
 * This code is developed by Avinash Gautam.
 *
 * While preparing for Java 11 certification on Oracle University online platform.
 *
 * For more information connect me on avigautam.knit@gmail.com
 */

package org.avi.productmanagement.products;

import org.avi.productmanagement.constants.Rating;

public class Drink extends Product{
    public Drink(int id, String name, Rating rating) {
        super(id, name, rating);
    }
}
