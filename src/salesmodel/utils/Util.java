/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.utils;

import java.util.ArrayList;

/**
 *
 * @author faye
 */
public class Util {
    public static ArrayList<String> wrapSpaces(String[] arr){
        ArrayList<String> res = new ArrayList<>();
        for(String s : arr){
            if(!s.trim().isEmpty()){
                res.add(s.trim());
            }
        }
        
        return res; 
    }
    public static boolean isInteger(String str) { 
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
