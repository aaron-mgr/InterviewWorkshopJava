package com.aharon.workshop.design;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * Product	Price	Discount
 * A	10	N + M i.e. (2 + 1)
 * B	20	3 => 50
 * C	30
 */
public class ProductPriceCalculator {


    private Map<Integer, Product> products = new HashMap<Integer, Product>();

    public static class Product {
        int id;
        String name;
        double basePrice;
        IStrategy discountStrategy;

        public double calculate(Integer number) {
            return discountStrategy.calculate(basePrice, number);
        }
    }

    double calculate(Map<Integer, Integer> cart) {

        double result = 0;

        for (Map.Entry<Integer, Integer> entry: cart.entrySet()) {

            Product product = products.get(entry.getKey());
            double price = product.calculate(entry.getValue());
            result += price;

        }
        return result;
    }



    public interface IStrategy {
        double calculate(double basePrice, Integer number);
    }


    /**
     * Discount by Number of products
     */
    public static class Strategy1 implements IStrategy {

        int N, M; // 3, 2

        public double calculate(double basePrice, Integer number) {

            int numOfsets = number/(N+M); // 9
            double result = numOfsets*basePrice*N;

            int rest = number - numOfsets*(N+M);
            rest = Math.min(rest, N);
            result += rest * basePrice;
           /** if (rest < N) {
                result += rest * basePrice;
            } else {
                result += N*basePrice;
            }*/
            return result;
        }
    }

    /**
     * Discount by amount of products
     */
    public static class Strategy2 implements IStrategy {

        int discountAmount, discountPrice; // 3, 50

        public double calculate(double basePrice, Integer number) {
            int numOfsets = number/discountAmount;
            double result = numOfsets*discountPrice;

            int rest = number - numOfsets * discountAmount;
            result += rest * basePrice;

            return result;
        }
    }

}
