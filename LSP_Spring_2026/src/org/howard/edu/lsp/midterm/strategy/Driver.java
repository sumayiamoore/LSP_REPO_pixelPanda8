package org.howard.edu.lsp.midterm.strategy;

/** Demonstrates the Strategy Pattern for pricing. @author Your Name */
public class Driver {
    public static void main(String[] args) {
        double price = 100.0;

        PriceCalculator calc = new PriceCalculator(new RegularDiscount());
        System.out.println("REGULAR: " + calc.calculatePrice(price));

        calc = new PriceCalculator(new MemberDiscount());
        System.out.println("MEMBER: " + calc.calculatePrice(price));

        calc = new PriceCalculator(new VIPDiscount());
        System.out.println("VIP: " + calc.calculatePrice(price));

        calc = new PriceCalculator(new HolidayDiscount());
        System.out.println("HOLIDAY: " + calc.calculatePrice(price));
    }
}