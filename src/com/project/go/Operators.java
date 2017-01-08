package com.project.go;

import java.math.RoundingMode;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Joe K. on 11/29/2016.
 */

//*Class Operators with method operate processes the current stock price and 52 week low and calculates the
    //*percent of 52 week low. If the percent is lower than 10% it is a good buy and will print results to the console, Gui,
    //* and the CSV
public class Operators {
    public static String operate(double price, double low, String company) throws Exception {

        double percent = (price / low - 1) * 100;
        double rpercent = Math.round(percent * 100.0) / 100.0; ///* is this an accurate way to round?
        StringBuilder sb = new StringBuilder(32); //* sb is used to pass information on the the GUI so it can be displayed on screen.

        String concac = "";
        if (rpercent <= 10) {
            System.out.println(company + " is trading at:");
            sb.append(company + "\n");
            System.out.println("the current price is:  " + price);
            sb.append("the current price is:  " + price + "\n");
            System.out.println("the 52 week low is:  " + low);
            sb.append("the 52 week low is:  " + low + "\n");
            System.out.println("percent of 52 week low is:  " + rpercent);
            sb.append("percent of 52 week low is:  " + rpercent + "\n");
            PasstoGui.superString(sb.toString());//*passes sb to a static variable superstring in PasstoApp
            String company1 ="\"" + company + "\"";
            String price1 = String.valueOf(price);
            String low1 = String.valueOf(low);
            String rpercent1 = String.valueOf(rpercent);
            concac = company1 + "," + price1 + "," + low1 + "," + rpercent1;





        }
        return concac;



    }




}
