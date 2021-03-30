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

import org.avi.productmanagement.constants.Rating;

public class Reviews {
    private Rating rating;
    private String comments;

    public Reviews(Rating rating, String comments) {
        this.rating = rating;
        this.comments = comments;
    }

    public Rating getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }
}
