/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        start=0;stop=theArray.length;
        while(layers>1){
            System.out.println(copyOfRange(theArray,start,stop));
            start++;stop--;layers-=2;
            peel(start,stop);
        }
        //this one especially needs some work
        int newLayers=0;int newStart=midIndex-1;int newStop=midIndex+1;
        while(flipArr.length<newLayers){
            System.out.println(copyOfRange(flipArr,newStart,newStop));
            newStart--;newStop++;newLayers+=2;
            peel(newStart,newStop);
        }
    }
}
