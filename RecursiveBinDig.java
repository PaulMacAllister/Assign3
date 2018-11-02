/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.IllegalArgumentException;

/**
 *
 * @author elizadoering
 * @author paulmacallister
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
     * checks the entered array to make sure it has an odd number of elements,
     * if it does it throws an illegalArgumentException, im not sure what exception to use here though
     * 
     * added a param in constructor so that we can get the number we need to change
     * removed the layers param, since we can get that from the entered array
     * 
     */
    public RecursiveBinDig(int[] theArray){
      if(theArray.length%2==0){
        throw new IllegalArgumentException("Array must have odd number of elements");
      }
      else{
        this.layers2=0;
        this.layers=theArray.length;
        this.theArray=theArray;
        flipArr=new int[layers];
        midIndex=(layers/2);
      }
    }
  /*Edits:
   * changed the testing in the for method to theArray.length, since layers is changed throughout the peel method
   */
    private void flippedArr(){
        for(int i=0;i<theArray.length;i++){
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
     * -----------------------------------------------------------------------------------------------------------
     * I added a 
     * 
     *    int x = layers;
          while(x<theArray.length){
            string+=" ";
            x+=2;
          }
     *
     * to each if statement, so that the string is formatted correctly with spaces, I think there is a better way to
     * do this but its what i came up with
     * 
     */
    private String peel(int start,int stop,String string){
      /*if layers is less than one it findes theArray[start to stop] and appends those numbers onto string*/
        if(layers>1){
          
          int x = layers;
          while(x<theArray.length){
            string+=" ";
            x+=2;
          }
          
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
          
          int x = layers;
          while(x<theArray.length){
            string+=" ";
            x+=2;
          }
          
          string+=Integer.toString(theArray[midIndex]);
          string+="\n";
          layers=0;
          layers2=1;
          return peel(start,stop,string);
        }
      /*if layers2 equals 0,(which should only happen once) it calls the flippedArr() method,
       * appends the midVal of fliped array to string, and adds 2 onto layers2
       */
        else if(layers2 == 1){
          
          flippedArr();
          
          int x = layers2;
          while(x<flipArr.length){
            string+=" ";
            x+=2;
          }
          
          string+=Integer.toString(flipArr[midIndex]);
          string+="\n";
          start--;stop++;layers2=3;
          return peel(start,stop,string);
        }
      /*if layers2 is less than theArray.length it finds flipArr[start to stop] and appends those numbers onto string*/
        else if(layers2<=theArray.length){
          
          int x = layers2;
          while(x<flipArr.length){
            string+=" ";
            x+=2;
          }
          
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
