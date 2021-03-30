/*
  This code is developed by Avinash Gautam.

  While preparing for Java 11 certification on Oracle University online platform.

  For more information connect me on avigautam.knit@gmail.com

  @author Avinash Gautam
 * @version 1.0

 */

package org.avi.productmanagement.products;

import org.avi.productmanagement.constants.Rating;

public interface Rateable<T> {

    Rating DEFAULT_RATING = Rating.NOT_RATED;

    /**
     * This will apply the given rating
     * @param rating rating given by User {@link Rating}
     * @return T
     *
     */
    T applyRating(Rating rating);

    /**
     * This will provide the default rating for new products
     * @return {@link Rating}
     *
     */
    default Rating getRating(){
        return DEFAULT_RATING;
    }

    /**
     * This will provide the default rating for new products
     *
     * @param stars rating given by User in numbers
     * @return {@link Rating}
     *
     */
    static Rating convertRating(int stars){
        //Rating.values()[] brings the sequential constructors
        return (stars >= 0 && stars <=5) ? Rating.values()[stars] : DEFAULT_RATING;
    }

    /**
     * This will provide the default rating for new products
     *
     * @param stars rating given by User in numbers
     * @return T
     *
     */
    default T applyRating(int stars){
        // Here we are calling abstract method -> T applyRating(Rating rating);
        // This implies that the functioning of this method will be determined by the
        // Future implementation of -> T applyRating(Rating rating);
        return applyRating(convertRating(stars));
    }
}
