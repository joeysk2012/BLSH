package com.project.go;

import java.lang.reflect.Array;

/**
 * Created by Joe  on 12/27/2016.
 */

//*this class has the method superString brings in strings from the result of Operators class and makes a
// concatenated string to be passed to the GUI
public class PasstoGui {


    static StringBuilder ssb;
    public static String superString (String sb) {
        if(ssb == null)
            ssb = new StringBuilder(32);
        ssb = ssb.append(sb);
        return ssb.toString();
    }


}
