package com.project.go;

/**
 * Created by Joe K. on 11/24/2016.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
//*this class is for testing code that's to be used for the htmlParser.

public class HtmlTestor {

    public static void main(String[] args) throws Exception {

        parser(); //*calls the method as an object
    }

    public static void parser() throws IOException {
        String baseUrl = "http://finance.yahoo.com/quote/";
        String postfix = "?ltr=1";
        String url = baseUrl + "HBAN" + postfix;
        Document doc = Jsoup.connect(url).timeout(10 * 1000).get(); //*this gets the yahoo finance page for Apple

        Elements tables = doc.select("table"); //*table and tables is unused for this method.
        Element table = null;
        Elements div = doc.select("div [class = D(ib) Fw(200) Mend(20px)]");
        Element divs = null;//*gets the span elements from the website.
        Elements rows = doc.select("td");//*gets the td element from the website.
        Element row = null;
        String sprice = ""; //*sprice or string price is the current price in string form that needs to be converted
        String slow = ""; //* slow or string low is the range of the 52 week low (i.e. 45.11-56.45) that needs to be truncated and converted to a number
        Elements name = doc.select("div [class = D(ib) ]");
        String company ="";

        company = name.first().text();
        System.out.println(company);

       sprice = div.select("span").get(0).text();
                System.out.println(sprice);




        if (rows.hasClass("Ta(end) Fw(b)")) {//*this code gets the 52 week range on yahoo.com
            row = rows.get(13);
            slow = row.text();
            System.out.println(slow);
        }


    }
}





//*doc.getElementById("quote-market-notice").parent().child(0).text() this code marks out a stable element by id then does a few modifiers to get to the stock price.

//*if (spans.hasClass("Fw(b) D(ib) Fz(36px) Mb(-4px)"));

//* This is a for loop that was used to get all the rows from the table but it evolved into just an index
//* for the 52 week range.
//*for(int i =0; i < rows.size();  i++){
//*if(rows.hasClass("Ta(end) Fw(b)")){
//* row = rows.get(13);
//*String info =row.text();
//*System.out.println("52 week Range " + info);


//* this code is an enhanced for loop that gets all the values from the table.

//*for(Element rowElement : rows){
//*    if(rowElement.hasClass("Ta(end) Fw(b)")){
//*      row = rowElement;
//*     String info =row.text();
//*     System.out.println("ROWS: " + info);






//*copied stack overflow an iterator not sure what it does.

//*Iterator<Element> ite = table.select("<tr>").iterator();

//*System.out.println("Value 1: " + ite.next().text());
//*System.out.println("Value 2: " + ite.next().text());
//*System.out.println("Value 3: " + ite.next().text());
//*System.out.println("Value 4: " + ite.next().text());

//*copied from stack over flow and it is the opriginal code i was working with turned out it doesn't work since jsoup hates
//* classes with the % sign.
//*Elements table = doc.select("table.W(100%)");
//*Element row = table.select("tr").get(5);

//*final String number = row.select("td").text();
//*System.out.println(number);h