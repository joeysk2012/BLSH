package com.project.go;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.project.go.HtmlParser.concac1;
import static com.project.go.Wikiparser.*;

 //*The main class handles the console menu options and scans for user input.
// It pulls up stocks that make up the dow jones and S&P 500 that are within 10% of thier 52 week low seperated by sectors
// (All, Health Care, Inustrial, Tech, Consumer, Financial, etc..). In the future
// I would like to add historical data in order to test how this strategy would work if
// I had traded on it 100 days ago. For now it just pulls up todays date and current time.
// The HtmlParser class has the method parser that reads html from each stock's yahoo page and get's
// current price and 52 week low. It feeds the tracker symbol, price and low to the class Operator
// which has the method operate that calculates the % of 52 week low and determines if that is 10% of lower.
// The ouput is printed out in console, the results are recorded to CSV format using the CSVUtil class, and passed on to a
// GUI that I have made. The App class has all of the GUI code made Using JAVAFX.



public class Main {

    public static void main(String[] args) throws IOException {

	System.out.println("Welcome to Buy Low Sell High (BLSH)");
        DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
        Date dateobj = new Date();
        System.out.println("today's date is: " + df.format(dateobj)); //*pulls up today's date

        System.out.println("Pulling up today's information press enter."); //*asks for report date
        Scanner sc = new Scanner(System.in); //*new scanner
        String a = sc.nextLine(); //Placeholder for now. Used for historical data functionality in the future.


        //*The next portion asks for the sector in which you are wanting your report.
        System.out.println("What industry? All (A), Consumer Discretionary (D) Consumer Staples (S), Energy (E)");
        System.out.println("Financial (F), Healthcare (H) Industrial (I), Real Estate (R) Info. Tech. (T), Utilities (U)");
        String b = sc.nextLine();

        //*intializes the csv writer and file
        System.out.println("CSV writer is initialized");
        FileWriter writer = new FileWriter("./output.csv"); //creates a a dummy file output for writing. we will cleanup dummy in order to make a clean csv file.
        CSVUtils.writeLine(writer, Arrays.asList("Today's date is", df.format(dateobj))); //the first row of the csv file.
        CSVUtils.writeLine(writer, Arrays.asList("Company", "Current Price", "52 Week Low", "Percent of 52 Week Low")); //writes the column headings for the csv file.

        //go into swithch statement for each of the different company sectors in the S&P 500

        switch (b) {
            case "A": //All 506 compnaies in the S&P 500
                System.out.println("Pulling up All");
                //pulls up all
                String [] sym = getAllSymbols(); //Goes into Wikiparser class and gets all symbols.
                for (int i = 1 ; i <getAllSymbols().length; i++){ //loop through all tracker symbols
                    String x = sym[i];
                    HtmlParser.parser(x);
                    CSVUtils.writeLine(writer, Arrays.asList(concac1)); //This code writes a line in the dummy csv file with all data.
                    // Concac1 is  a static variable of added strings.
                }

                break;

            case "D":
                System.out.println("Pulling up Consumer Disc."); //Similar to above case except using tracker symbols from consumer discretionary companies.
                String [] sym1 = getDSymbols();
                for (int i = 1 ; i < getDSymbols().length ; i++){
                    String x = sym1[i];
                    HtmlParser.parser(x);
                    CSVUtils.writeLine(writer, Arrays.asList(concac1));
                }

                break;

            case "S":
                System.out.println("Pulling up Consumer Staples"); //Similar to above but with different tracker symbols.
                String [] sym2 = getSSymbols();
                for (int i = 1 ; i < getSSymbols().length ; i++){
                    String x = sym2[i];
                    HtmlParser.parser(x);
                    CSVUtils.writeLine(writer, Arrays.asList(concac1));
                }

                break;

            case "E":
                System.out.println("Pulling up Energy"); //Similar to above but with different tracker symbols.
                String [] sym3 = getESymbols();
                for (int i = 1 ; i < getESymbols().length ; i++){
                    String x = sym3[i];
                    HtmlParser.parser(x);
                    CSVUtils.writeLine(writer, Arrays.asList(concac1));
                }

                break;

            case "F":
                System.out.println("Pulling up Financial"); //Similar to above but with different tracker symbols.
                String [] sym4 = getFSymbols();
                for (int i = 1 ; i < getFSymbols().length ; i++){
                    String x = sym4[i];
                    HtmlParser.parser(x);
                    CSVUtils.writeLine(writer, Arrays.asList(concac1));
                }

                break;

            case "H":
                System.out.println("Pulling up Health Care"); //Similar to above but with different tracker symbols.
                String [] sym5 = getHSymbols();
                for (int i = 1 ; i < getHSymbols().length ; i++){
                    String x = sym5[i];
                    HtmlParser.parser(x);
                    CSVUtils.writeLine(writer, Arrays.asList(concac1));
                }

                break;

            case "I":
                System.out.println("Pulling up Industrial"); //Similar to above but with different tracker symbols.
                String [] sym6 = getISymbols();
                for (int i = 1 ; i < getISymbols().length ; i++){
                    String x = sym6[i];
                    HtmlParser.parser(x);
                    CSVUtils.writeLine(writer, Arrays.asList(concac1));
                }

                break;

            case "R":
                System.out.println("Pulling up Real Estate"); //Similar to above but with different tracker symbols.
                String [] sym7 = getRSymbols();
                for (int i = 1 ; i < getRSymbols().length ; i++){
                    String x = sym7[i];
                    HtmlParser.parser(x);
                    CSVUtils.writeLine(writer, Arrays.asList(concac1));
                }

                break;

            case "T":
                System.out.println("Pulling up Information Technology"); //Similar to above but with different tracker symbols.
                String [] sym8 = getTSymbols();
                for (int i = 1 ; i < getTSymbols().length ; i++){
                    String x = sym8[i];
                    HtmlParser.parser(x);
                    CSVUtils.writeLine(writer, Arrays.asList(concac1));
                }
                writer.flush();
                writer.close();
                spaceRemover();

                break;

            case "U":
                System.out.println("Pulling up Utilities"); //Similar to above but with different tracker symbols.
                String [] sym9 = getUSymbols();
                for (int i = 1 ; i < getUSymbols().length ; i++){
                    String x = sym9[i];
                    HtmlParser.parser(x);
                    CSVUtils.writeLine(writer, Arrays.asList(concac1));
                }

                break;

            default: System.out.println("not a valid sector");
                //*this is an error message you get when you input a wrong sector.

                break;

        }//end of switch

        writer.flush(); //flushes anything in the CSV writer to the dummy.
        writer.close(); //closes the writer.
        spaceRemover(); //removes blank lines created by null strings in the dummy CSV file and adds a date to the file name.

    }//end of main method

    //this method is for a blank row remover as a post processing of the CSV  dummy file and to add a date to the file name.
    public static void spaceRemover() throws IOException {

        Scanner file;
        PrintWriter writer;
        DateFormat df1 = new SimpleDateFormat("MM-dd-yy"); //*this date is for the CSV writer file
        Date dateobj1 = new Date();
        String csvOut = "./results/"+df1.format(dateobj1)+"output.csv";

        try {

            file = new Scanner(new File("./output.csv"));
            writer = new PrintWriter(csvOut);

            while (file.hasNext()) {
                String line = file.nextLine();
                if (!line.isEmpty()) {
                    writer.write(line);
                    writer.write("\n");
                }
            }

            file.close();
            writer.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    } //end of spaceRemover method


}//end of class

