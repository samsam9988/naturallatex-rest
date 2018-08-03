/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package naturallatex.utils;
 
import java.util.Random;

/**
 *
 * @author sam
 */
public class RandomNumberUtil {

    private final static int BIGMIN = 1000;
    private final static int BIGMAX = 999999;
    
    private final static int TINYMIN = 1;
    private final static int TINYMAX = 9999;
    
    public static int tinyId() {
        Random r = new Random();
        int i = TINYMIN + r.nextInt(TINYMAX-TINYMIN);
        return i;
    }
    
    public static int bigId() {
        Random r = new Random();
        int i = BIGMIN + r.nextInt(BIGMAX-BIGMIN);
        return i;
    }
}
