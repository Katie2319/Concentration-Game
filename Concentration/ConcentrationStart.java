import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color; 
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.*; 

public class ConcentrationStart extends Application
{

   Font appFont = new Font("Helvetica",24);
   Label myLabel;
   Button [][] buttons;  
   Label resultLabel; 
   GridPane grid;
   
   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }
   
   @Override
   public void start(Stage stage)
   {  
      // Make new GridPane.
      grid = new GridPane( );
      grid.setAlignment(Pos.BASELINE_CENTER);
      int size = 2;
      
      buttons = makeAGrid(grid,size); 
      
       
      myLabel = makeLabel("Welcome to Concentration. Match all the tiles."); 
             

      VBox vbox = new VBox(myLabel,grid); 

      Scene scene = new Scene(vbox,500,500);      

      stage.setScene(scene);    

      stage.setTitle("Concentration/Memory Match Game");

      stage.show();
   }
   
   Label makeLabel(String s){
      Label label = new Label(s); 
      label.setFont(appFont); 
      return(label); 
   }
   
   Button makeButton(Image img){
       // create a button with an image on it
      // Create an ImageView component to decorate Button
      ImageView iView = new ImageView(img);
      iView.setFitWidth(100); 
      iView.setFitHeight(100);
      
      Button newButton =  new Button("",iView);
      return(newButton); 
   }

   
   Button [][]  makeAGrid(GridPane grid, int size){
   // square grid, size x size
      Button [][] b = new Button[size][size];
   
      for(int r=0;r<size;r++){ 
         for(int c = 0;c<size;c++){
            if((r+c)%2 ==0)
               b[r][c] = makeButton(new Image("file:black.jpg"));
            else
               b[r][c] = makeButton(new Image("file:black.jpg"));
         // add b to the grid
            grid.add(b[r][c],c, r);
         // Register the event handler.
            //b[r][c].setOnAction(new ButtonClickHandler());
         } 
      }
      return(b);   
   }
  
        
 
   
} // class

