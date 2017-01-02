package com.project.go;

import java.lang.reflect.Array;

/**
 * Created by Morgan on 12/27/2016.
 */
public class PasstoApp {


    static StringBuilder ssb;
    public static String superString (String sb) {
        if(ssb == null)
            ssb = new StringBuilder(32);
        ssb = ssb.append(sb);
        return ssb.toString();
    }


}
