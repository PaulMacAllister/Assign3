/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignments.Assignment3;

import static java.util.Arrays.copyOfRange;

/**
 *
 * @author elizadoering
 */
public class RecursiveBinDig {
    //data fields 
    /*the size of the array*/
    private int layers;
    /*array of binary digits*/
    private int[] theArray;
    private int[]flipArr;
    private int midIndex;
    public RecursiveBinDig(int layers){
        this.layers=layers;
        theArray=new int[layers];
        flipArr=new int[layers];
        midIndex=layers/2;
    }
    public void flippedArr(){
        for(int i=0;i<layers;i++){
            if(theArray[i]==0)flipArr[i]=1;
            if(theArray[i]==1)flipArr[i]=0;
        }
    }
    public void peel(int start,int stop){
        while(layers>1){
            start=0;stop=layers;
            System.out.println(copyOfRange(theArray,start,stop));
            start++;stop--;layers-=2;
            peel(start,stop);
        }
        while(flipArr.length<layers){
            start=midIndex-1;stop=midIndex+1;
            System.out.println(copyOfRange(flipArr,start,stop));
            start--;stop++;layers+=2;
            peel(start,stop);
        }
    }
}
