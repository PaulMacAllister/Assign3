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
  int[] flipArray;
  TextField txt;
  Label label;
  
   @Override 
   public void start(Stage stage) {
      
      txt = new TextField();
      label = new Label("How large is your binary number going to be");
      
      label.setLayoutX(100);
      label.setLayoutY(50);
      
      txt.setLayoutX(100);
      txt.setLayoutY(100);
      
      txt.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
          
          //label.setText("How large is your binary number going to be");
          
          size = Integer.parseInt(txt.getText());
          label.setText("Enter your binary number");
          
          txt.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
              if(txt.getText().length() != size){
                label.setText("Please make sure the number you enter is the correct size");
              }
              else{
                
              }
            }
          });
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