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
public class MinRowMaxColumn {
    
    public static void main(String[] args){
        int[][] array = {{3,2,1},{4,5,6},{7,8,9}};
        //321
        //456
        //789
        
        int column = -1;
        int min = 99999999;
        int max = -1;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if(array[i][j]<min){
                    min = array[i][j];
                    column = j;
                }
            }
        }
        
        for(int i=0;i<array.length;i++){
            if(array[i][column]>max){
                max = array[i][column];
            }            
        }
        
        System.out.println("Minimum Number in Row: "+min);
        System.out.println("Maximum number in Column: "+max);
        
    }
    
}
