package org.example;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product();
        product1.setName("Delonghi Coffe Machine");
        product1.setUnitPrice(7500d);
        product1.setDiscount(7d);
        product1.setUnitsInStock(3);
        product1.setImgUrl("whatever.jpeg");

        //System.out.println(product1.discount);

        Product product2 = new Product();

        product2.setName("Smeg Coffe Machine");
        product2.setUnitPrice(6500d);
        product2.setDiscount(7d);
        product2.setUnitsInStock(2);
        product2.setImgUrl("whatever2.jpeg");

        Product product3 = new Product();

        product3.setName("Kitchen Aid Coffe Machine");
        product3.setUnitPrice(4500d);
        product3.setDiscount(7d);
        product3.setUnitsInStock(4);
        product3.setImgUrl("whatever3.jpeg");

        Product[] products = {product1, product2, product3};

        for (Product product : products) {
            System.out.println(product.getName());
        };
        //Inheritance

        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setId(1);
        individualCustomer.setCustomerNumber("12345");
        individualCustomer.setPhoneNumber("0543231232");
        individualCustomer.setFirstName("Halil");
        individualCustomer.setLastName("Kocoglu");

        CorporateCustomer corporateCustomer = new CorporateCustomer();
        corporateCustomer.setId(2);
        corporateCustomer.setCustomerNumber("12344");
        corporateCustomer.setPhoneNumber("08234234");
        corporateCustomer.setCustomerNumber("5441123");
        corporateCustomer.setTaxNumber("111111111111");
        corporateCustomer.setCompanyName("Kodlama.io");

        Customer [] customers = {individualCustomer, corporateCustomer};
    }
}