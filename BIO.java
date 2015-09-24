// File [BIO_java.html] MAS - last created: Thu 05 Feb 2015 19:35:20 GMT

import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;

/*
 *  To use in a BlueJ project
 *  Create a class called BIO with this file as the contents
 */


public class BIO
{
  private static final int EOF  = -1;
  private static final int NONE = -2;
  private static int nextChar = NONE;
  private static boolean eofDetected = false;

  protected static String getLineBASE()
  {
    String line = "";                                 // Line read  
    int    ch;                                        // Read ch  

    try
    {
      ch = System.in.read();                          // No next char  

      if ( ch == EOF ) 
      {
        System.out.println();
        System.out.println("**** END OF FILE " + 
                           "detected on input -- EXIT ****" );
        System.exit(-1);
      }
      while( ch != '\n'  )                            // Read loop  
      {
        if ( ch == EOF )
        {
          eofDetected = true;
          return line;                                //  exit  
        }
        line = line + (char) ch;                      //  form line  
        ch = System.in.read();                        //  next ch  
      }
      return line;                                    // return line  
    }
    catch( IOException exp )                          // Problem  
    {
      System.exit(-1);                                // Exit **  
    }
    return "";                                        // Blank line  
  }


  protected static String getLine()
  {
    String line = getLineBASE();                      // Read line  
    //System.out.println( line );  
    return line;
  }


  public static String getString()
  {
    String line = getLine();                          // Read line  
    return line.trim();
  }

  public static double getDouble()
  {
    String res = getLine();                           // Read line  
    double value = 0.0;                               //  
    try
    {
      value = Double.parseDouble( res.trim() );       // Convert  
    }
    catch ( NumberFormatException ex )                // Problem  
    {                                                 //  ignore  
    }
    return value;                                     // return  
  }

  public static int getInt()
  {
    String res = getLine();                           // Read line  
    int value = 0;                                    //  
    try
    {
      value = Integer.parseInt( res.trim() );         // Convert  
    }
    catch ( NumberFormatException ex )                // Problem  
    {                                                 //  ignore  
    }
    return value;                                     // return  
  }

}
