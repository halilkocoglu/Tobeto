package org.example;

public class Main {
    public static void main(String[] args) {
        //Variables
        //Text based
        String midText = "İlginizi çekebilir.";
        String subText = "Vade Süresi";

        System.out.println("Midtext: " + midText);
        System.out.println("Subtext: " + subText);
        //Nums
        Integer expiry = 12;
        System.out.println(expiry);

        double dolarYesterday = 18.14;
        double dolarNow = 18.10;
        // True false Boolean
        boolean isDolarDecrease = false;

        String arrowDestination = "";

        //Conditions

        if ( dolarYesterday > dolarNow ) {
            arrowDestination = "down.svg";
            System.out.println(arrowDestination);
            System.out.println("Dolar azaldı");
        }else if (dolarYesterday == dolarNow) {
            arrowDestination = "equal.svg";
            System.out.println(arrowDestination);
            System.out.println("Dolar değişmedi");
        }else {
            arrowDestination = "up.svg";
            System.out.println(arrowDestination);
            System.out.println("Dolar arttı.");
        }

        //Arrays
        String [] credits = {"Fast", "Salary From Halkbank", "Happy retired"};
        //For loop
        for ( int i = 0; i < credits.length; i++){
            System.out.println(credits[i]);
        };

        System.out.println("-------------------------------");

        for (String credit : credits) {
            System.out.println(credit);
        };

    }
}