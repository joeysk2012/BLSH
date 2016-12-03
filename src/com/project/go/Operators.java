package com.project.go;

import java.math.RoundingMode;



/**
 * Created by Joe K. on 11/29/2016.
 */

//*this Class Operators method operate processes the current stock price and 52 week low and calculates the
    //*percent of low.
public class Operators {

    public static void operate(double price, double low, String tracker){

        double percent = (price/low-1)*100;
        double rpercent = Math.round(percent * 100.0) / 100.0; ///* is this an accurate way to round?

        if(rpercent <= 10) {
            System.out.println(tracker + " is trading at:");
            System.out.println("the current price is:  " + price);
            System.out.println("the 52 week low is:  " + low);
            System.out.println("percent of 52 week low is:  " + rpercent);
        }



    }




}
