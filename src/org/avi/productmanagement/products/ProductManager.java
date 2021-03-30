/*
 * This code is developed by Avinash Gautam.
 *
 * While preparing for Java 11 certification on Oracle University online platform.
 *
 * For more information connect me on avigautam.knit@gmail.com
 */

package org.avi.productmanagement.products;

import org.avi.productmanagement.constants.Rating;

import java.io.File;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.stream.Collectors;

public class ProductManager {

    private ResourceFormatter formatter;
    private Map<Product, List<Reviews>> products = new HashMap<>();

    Map<String, ResourceFormatter> formatters = Map.of(
            "en-GB", new ResourceFormatter(Locale.UK),
            "en-US", new ResourceFormatter(Locale.US),
            "fr_FR", new ResourceFormatter(Locale.FRANCE)
    );

    public ProductManager(Locale locale){
        this(locale.toLanguageTag());
    }

    public ProductManager(String languageTag){
        changeLocale(languageTag);
    }

    public void changeLocale(String langTag){
        formatter = formatters.getOrDefault(langTag, formatters.get("en-GB"));
    }

    public Product createProduct(int id, String name, double price, Rating rating, LocalDate bestBefore){
        Product product = new Food(id, name, price, rating, bestBefore);
        products.putIfAbsent(product,new ArrayList<>());
        return product;
    }

    public Product createProduct(int id, String name, double price, Rating rating){
        Product product = new Drink(id, name, price, rating);
        products.putIfAbsent(product,new ArrayList<>());
        return product;
    }

    public void printProduct(){
        StringBuilder sb = new StringBuilder();
        products.keySet().stream()
                .map(p -> sb.append(formatter.formatProduct(p) + "\n"))
                .collect(Collectors.joining());
        System.out.println(sb.toString());

    }

    private static class ResourceFormatter{

        private Locale locale;
        private ResourceBundle rb;
        private NumberFormat moneyFormat;
        private DateTimeFormatter dtf;

        private ResourceFormatter(Locale locale){
            this.locale = locale;
            rb = ResourceBundle.getBundle("format", locale);
            dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(locale);
            moneyFormat = NumberFormat.getCurrencyInstance(locale);
        }

        private String formatProduct(Product product){
            return MessageFormat.format(rb.getString("format.product"), product.getName(), moneyFormat.format(product.getPrice()),
                    product.getRating().getStars());
        }

        private String formatReview(Reviews review){
            return MessageFormat.format(rb.getString("format.review"), review.getRating().getStars(), review.getComments());
        }

        private String getString(String key){
            return rb.getString(key);
        }
    }

}
