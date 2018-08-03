/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package naturallatex.utils;

import static java.io.File.separator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;

/**
 *
 * @author sam
 */
public class DebugUtils {

    private static final Logger logger = Logger.getLogger(DebugUtils.class);
    
    public static String toString(List<?> l) {
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for (Object object : l) {
            String v = ToStringBuilder.reflectionToString(object);
            int start = v.indexOf("[");
            int end = v.indexOf("]");
            String st =  v.substring(start,end+1);
            sb.append(sep).append(st);
            sep = separator;
        }
        return sb.toString();
    }

    public static String toString(Map<?,?> m) {
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for (Object object : m.keySet()) {
            String v = ToStringBuilder.reflectionToString(m.get(object));
            int start = v.indexOf("[");
            int end = v.indexOf("]");
            String st =  v.substring(start,end+1);
            sb.append(sep).append(st);
            sep = separator;
        }
        return sb.toString();
    }

    public static String toString(Set<?> s) {
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for (Object object : s) {
            String v = ToStringBuilder.reflectionToString(object);
            int start = v.indexOf("[");
            int end = v.indexOf("]");
            String st =  v.substring(start,end+1);
            sb.append(sep).append(st);
            sep = separator;
        }
        return sb.toString();
    }

    public static void print(List<?> l) {
        System.out.println(toString(l));    
    }
    public static void print(Map<?,?> m) {
        System.out.println(toString(m));    
    }
    public static void print(Set<?> s) {
        System.out.println(toString(s));    
    }
}
