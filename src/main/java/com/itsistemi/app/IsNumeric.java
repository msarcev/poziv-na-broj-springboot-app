package com.itsistemi.app;

/**
 * Created by msarcevic on 26.8.2015..
 */
public class IsNumeric {
    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
