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
    private int layers2;
    /*array of binary digits*/
    private int[] theArray;
    /*array of flipped binary digits*/
    private int[]flipArr;
    /*the middle index of the binary number*/
    private int midIndex;
    
    /*
     * Edits: PaulMacAllister
     * changed how the midIndex is calculated so that it will get the mid index of an odd number
     * added a param in constructor so that we can get the number we need to change
     */
    public RecursiveBinDig(int layers, int[] theArray){
        this.layers2=theArray.length+1;
        this.layers=layers;
        this.theArray=theArray;
        flipArr=new int[layers];
        midIndex=((layers+1)/2);
    }
    
    private void flippedArr(){
        for(int i=0;i<layers;i++){
            if(theArray[i]==0)flipArr[i]=1;
            if(theArray[i]==1)flipArr[i]=0;
        }
    }
    
    public String peel(){
      return peel(0,theArray.length,"");
    }
    /*Edits: PaulMacAllister
     * added a public peel method, and changed the current one
     * 
     * Changes: it now takes a String param which gets gets added onto with each time it iterates through the method
     * for example at the end the string will look like,
     * 11011
     *  101
     *   0
     *   1
     *  010
     * 00100
     * -----------------------------------------------------------------------------------------------------------
     * It now uses if and else if statements to keep track of what array it has to get values from
     * and where in the array it is.
     * 
     * for getting the first Array it uses layers to test where it is and when it reaches midVal
     * 
     * for getting the second Array it uses layers2 to test where it is and when it reaches the end and
     * begining of the array
     * -----------------------------------------------------------------------------------------------------------
     * stop and start are now initialized in the public method, but the same logic is used to change them through each
     * iteration (First array start++ stop--)(Flipped array start-- stop++)
     * 
     */
    private String peel(int start,int stop,String string){
      /*if layers is less than one it findes theArray[start to stop] and appends those numbers onto string*/
        if(layers>1){
          for(int a=start; a<stop; a++){
            string+=Integer.toString(theArray[a]);
          }
          string+="\n";
          start++;stop--;layers-=2;
          return peel(start,stop,string);
        }
     /*if layers equals 1, theArray[midIndex] is appended onto string
      * layers2 and layers is made to equal 0, to begin getting the flippedArr values
      */
        else if(layers == 1){
          string+=Integer.toString(theArray[midIndex]);
          string+="\n";
          layers=0;
          layers2=0;
          return peel(start,stop,string);
        }
      /*if layers2 equals 0,(which should only happen once) it calls the flippedArr() method,
       * appends the midVal of fliped array to string, and adds 2 onto layers2
       */
        else if(layers2 == 0){
          flippedArr();
          
          string+=Integer.toString(flipArr[midIndex]);
          string+="\n";
          start--;stop++;layers2=3;
          return peel(start,stop,string);
        }
      /*if layers2 is less than theArray.length it finds flipArr[start to stop] and appends those numbers onto string*/
        else if(layers2<=theArray.length){
          for(int a=start; a<stop; a++){
            string+=Integer.toString(flipArr[a]);
          }
          string+="\n";
          start--;stop++;layers2+=2;
          return peel(start,stop,string);
        }
        else{
          return string;
        }
    }
}
