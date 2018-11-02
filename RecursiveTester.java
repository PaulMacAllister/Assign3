

public class RecursiveTester{
  public static void main(String[] args){
    int[] array = new int[7];
    
    for(int a=0; a<7; a++){
      array[a] = 0;
    }
    
    RecursiveBinDig test = new RecursiveBinDig(7,array);
    System.out.print(test.peel());
  }
}