package ca.tru;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating 4 Product Records");
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product("X001"));
        products.add(new Product("A001"));
        products.add(new Product("B002"));
        products.add(new Product("C003"));

        String masterPassword = "XYZ987";
        System.out.print("Setting up password, Password is: " + masterPassword);

    }
}