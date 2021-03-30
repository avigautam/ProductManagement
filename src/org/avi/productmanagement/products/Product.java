/*
 * This code is developed by Avinash Gautam.
 *
 * While preparing for Java 11 certification on Oracle University online platform.
 *
 * For more information connect me on avigautam.knit@gmail.com
 *
 * @author  Avinash Gautam
 * @version 1.0
 *
 *
 */

package org.avi.productmanagement.products;

import org.avi.productmanagement.constants.Constants;
import org.avi.productmanagement.constants.Rating;

public abstract class Product implements Rateable<Product>{
    private static int srNo = 0;
    private int id;
    private String name;
    private double price;
    private Rating rating;

    public Product( int id, String name, double price, Rating rating) {
         ++srNo;
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public static int getSrNo() {
        return srNo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public Rating getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount(){
        return price* Constants.DEFAULT_DISCOUNT;
    }

    @Override
    public String toString(){
        return srNo +" " + id +" "+ name +" "+ price +" "+ rating.getStars();
    }
}
