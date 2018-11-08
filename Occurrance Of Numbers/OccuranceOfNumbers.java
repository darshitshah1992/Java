/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Darshit
 */
public class OccuranceOfNumbers {
    
    public static void main(String[] args){
        int[] array = {4, 4, 4, 5, 5, 5, 6};
        occuranceOfNumbersAndGetMin(array);
    }
    
    public static void occuranceOfNumbersAndGetMin(int[] array){
        HashMap map = new HashMap();
        ArrayList<Integer> keys = new ArrayList<Integer>();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                int a = Integer.parseInt(map.get(array[i]).toString());
                a++;
                map.put(array[i], a);
            }
            else{
                map.put(array[i], 1);
                keys.add(array[i]);
            }
        }
        
        int min = 999999999;
        int minkey = 0;
        for(int i=0;i<keys.size();i++){
            
            System.out.println(keys.get(i) + " - " + map.get(keys.get(i)));           
            if(Integer.parseInt(map.get(keys.get(i)).toString())<min){
                minkey = keys.get(i);                
            }
        }
        System.out.println("Minimum occurrance number is: ");
        System.out.println(minkey + " - " + map.get(minkey));
    }    
}



