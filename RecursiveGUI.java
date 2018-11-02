import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.stage.Stage;  
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RecursiveGUI extends Application {
  
  int size;
  int[] theArray;
  TextField txt;
  Label label;
  RecursiveBinDig binNum;
  
   @Override 
   public void start(Stage stage) {
      
      txt = new TextField();
      label = new Label("Enter your binary number");
      
      label.setLayoutX(300);
      label.setLayoutY(50);
      
      txt.setLayoutX(100);
      txt.setLayoutY(100);
      
      txt.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
          theArray = new int[txt.getText().length()];
          for(int a=0; a<txt.getText().length(); a++){
            theArray[a] = Character.getNumericValue(txt.getText().charAt(a));
          }
          binNum = new RecursiveBinDig(theArray);
          String n = binNum.peel();
          label.setText(n);
          }
      });
     
     
     
     
     
     
     
     
     
      Group root = new Group(label,txt);
      Scene scene = new Scene(root, 600, 300);  
      stage.setTitle("recursive binary number");
      stage.setScene(scene); 
      stage.show(); 
   } 
   public static void main(String args[]){ 
      launch(args); 
   } 
}