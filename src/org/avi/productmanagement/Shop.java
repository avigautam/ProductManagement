/*
 * This code is developed by Avinash Gautam.
 *
 * While preparing for Java 11 certification on Oracle University online plateform.
 *
 * For more information connect me on avigautam.knit@gmail.com
 */

package org.avi.productmanagement;

import org.avi.productmanagement.constants.Rating;
import org.avi.productmanagement.products.Food;
import org.avi.productmanagement.products.ProductManager;

import java.time.LocalDate;
import java.util.Locale;

public class Shop {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager(Locale.US);
        pm.createProduct(101, "Chocolate", 2.5, Rating.FIVE_STAR, LocalDate.of(2022,12, 01));
        pm.createProduct(102, "Bread", 1.5, Rating.THREE_STAR, LocalDate.of(2022,12, 01));
        pm.createProduct(103, "Cola", 0.75, Rating.NOT_RATED);
        pm.printProduct();
        //System.out.println(f1.toString());
    }
}
