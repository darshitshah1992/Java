/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg121;

import java.util.Hashtable;

/**
 *
 * @author Darshit
 */
public class PairOfNumbersAddingSum {
    public static void main(String[] args){
        int[] array = {3, 2, 3};
        //Time Complexity O(n)
        System.out.println("-----------Time Complexity O(n)----------");
        int[] soln = getSolutionOn(array, 6);
        if(soln[0]==-1)
            System.out.println("Solution is not available");
        else
            System.out.println("Solution indexes are: "+ soln[0] + ", "+ soln[1]);
                
        //Time Complexity O(n^2)
        System.out.println("-----------Time Complexity O(n^2)----------");
        int[] soln1 = getSolutionOn2(array, 6);
        if(soln1[0]==-1)
            System.out.println("Solution is not available");
        else
            System.out.println("Solution indexes are: "+ soln1[0] + ", "+ soln1[1]);        
    }
    
    public static int[] getSolutionOn(int[] array, int target){
        int[] result = new int[2];
        result[0]=-1;
        Hashtable hashtable = new Hashtable();
        
        for(int i=0;i<array.length;i++){
            if(hashtable.containsKey(target-array[i])){
                result[0] = Integer.parseInt(hashtable.get(target-array[i]).toString());
                result[1] = i;
                break;
            }
            else
                hashtable.put(array[i], i);
        }
        
        return result;
    }
    
    public static int[] getSolutionOn2(int[] array, int target){
        int[] result = new int[2];
        result[0] = -1;
        boolean flag = false;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i] + array[j]==target){
                    result[0] = i;
                    result[1] = j;
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }
        
        return result;
    }
}
