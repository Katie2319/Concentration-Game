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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import java.util.*; 

public class ConcentrationStart4 extends Application
{
   Font appFont = new Font("Helvetica",24);
   Label myLabel;
   Button [][] buttons;  
   Button [][] images;
   Label resultLabel; 
   GridPane grid;
   GridPane imagegrid;
   int [] coorlist = new int[4];
   int numberoftries = 0;
   int numberoftimeswon = 0;
   int newTurnCount = 0;
   RadioButton smallButton;
   RadioButton mediumButton;
   RadioButton largeButton;
   Scene scene, scene2;
   VBox vbox;
   MemoryGame4 mg = new MemoryGame4();
   
   int boardSize;

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

      
      imagegrid = new GridPane();
       
      myLabel = makeLabel("Welcome to Concentration. Match all the tiles."); 
      
      smallButton = new RadioButton("Small");
      mediumButton = new RadioButton("Medium");
      largeButton = new RadioButton("Large");
      
      smallButton.setSelected(true);
      
      ToggleGroup GridGroup = new ToggleGroup();
      smallButton.setToggleGroup(GridGroup);
      mediumButton.setToggleGroup(GridGroup);
      largeButton.setToggleGroup(GridGroup);
      
      Button calcButton = new Button("Play");
      calcButton.setOnAction(new SecondButtonClickHandler());
      calcButton.setOnAction(e -> stage.setScene(scene2));  

      resultLabel = new Label(" ");
      
      
      buttons = makeAGrid(grid,4); 
      
      vbox = new VBox(myLabel, grid, resultLabel);   
      //vbox.getChildren().addAll(myLabel, grid);
      VBox vbox2 = new VBox(myLabel, smallButton, mediumButton, largeButton, calcButton);

      scene = new Scene(vbox2,400,400);  
      scene2 = new Scene(vbox,500,500); 
      
      scene.getStylesheets().add("cssfile.css"); 
      scene2.getStylesheets().add("cssfile.css");  

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
      iView.setFitWidth(50); 
      iView.setFitHeight(50);
      
      Button newButton =  new Button("",iView);
      return(newButton); 
   }

   Button [][]  makeAGrid(GridPane grid, int size){
   // square grid, size x size
      Button [][] b = new Button[size][size];
   
      for(int r=0;r<size;r++){ 
         for(int c = 0;c<size;c++){
            if((r+c)%2 ==0)
               b[r][c] = makeButton(new Image("file:mark.jpg"));
            else
               b[r][c] = makeButton(new Image("file:mark.jpg"));
         // add b to the grid
            grid.add(b[r][c],c, r);
         // Register the event handler.
            b[r][c].setOnAction(new ButtonClickHandler());
         } 
      }
      return(b);}  
      
   Button [][]  makeAnImageGrid(GridPane imagegrid, int size){
   // square grid, size x size
      Button [][] b = new Button[size][size];
      
      if(size == 2){
         b[0][0] = makeButton(new Image("file:Vanna.JPG"));
         imagegrid.add(b[0][0],0, 0);
      
         b[0][1] = makeButton(new Image("file:Vanna.JPG"));
         imagegrid.add(b[0][1],1, 0);
         
         b[1][0] = makeButton(new Image("file:TrebekNow.JPG"));
         imagegrid.add(b[1][0],0, 1);
      
         b[1][1] = makeButton(new Image("file:TrebekNow.JPG"));
         imagegrid.add(b[1][1],1, 1);
      }
      
      if(size ==4){
         b[0][0] = makeButton(new Image("file:TrebekY.JPG"));
         imagegrid.add(b[0][0],0, 0);
      
         b[0][1] = makeButton(new Image("file:TrebekNow.JPG"));
         imagegrid.add(b[0][1],1, 0);
      
         b[0][2] = makeButton(new Image("file:TrebekB.JPG"));
         imagegrid.add(b[0][2],2, 0);
      
         b[0][3] = makeButton(new Image("file:Vanna.JPG"));
         imagegrid.add(b[0][3],3, 0);
       
         b[1][0] = makeButton(new Image("file:TrebekY.JPG"));
         imagegrid.add(b[1][0],0, 1);
      
         b[1][1] = makeButton(new Image("file:TrebekNow.JPG"));
         imagegrid.add(b[1][1],1, 1);
      
         b[1][2] = makeButton(new Image("file:TrebekB.JPG"));
         imagegrid.add(b[1][2],2, 1);
      
         b[1][3] = makeButton(new Image("file:Vanna.JPG"));
         imagegrid.add(b[1][3],3, 1);
      
         b[2][0] = makeButton(new Image("file:Brady.JPG"));
         imagegrid.add(b[2][0],0, 2);
      
         b[2][1] = makeButton(new Image("file:Carey.JPG"));
         imagegrid.add(b[2][1],1, 2);
      
         b[2][2] = makeButton(new Image("file:BarkerOld.JPG"));
         imagegrid.add(b[2][2],2, 2);
      
         b[2][3] = makeButton(new Image("file:BarkerY.JPG"));
         imagegrid.add(b[2][3],3, 2);
      
         b[3][0] = makeButton(new Image("file:Brady.JPG"));
         imagegrid.add(b[3][0],0, 3);
      
         b[3][1] = makeButton(new Image("file:Carey.JPG"));
         imagegrid.add(b[3][1],1, 3); 
      
         b[3][2] = makeButton(new Image("file:BarkerOld.JPG"));
         imagegrid.add(b[3][2],2, 3); 
      
         b[3][3] = makeButton(new Image("file:BarkerY.JPG"));
         imagegrid.add(b[3][3],3, 3);  
      }
      if(size == 8){
         b[0][0] = makeButton(new Image("file:TrebekY.JPG"));
         imagegrid.add(b[0][0],0, 0);
      
         b[0][1] = makeButton(new Image("file:TrebekNow.JPG"));
         imagegrid.add(b[0][1],1, 0);
      
         b[0][2] = makeButton(new Image("file:TrebekB.JPG"));
         imagegrid.add(b[0][2],2, 0);
      
         b[0][3] = makeButton(new Image("file:Vanna.JPG"));
         imagegrid.add(b[0][3],3, 0);
       
         b[0][4] = makeButton(new Image("file:Brady.JPG"));
         imagegrid.add(b[0][4],4, 0);
         
         b[0][5] = makeButton(new Image("file:Carey.JPG"));
         imagegrid.add(b[0][5],5, 0);
         
         b[0][6] = makeButton(new Image("file:MHall.JPG"));
         imagegrid.add(b[0][6],6, 0);
         
         b[0][7] = makeButton(new Image("file:Sayjak.JPG"));
         imagegrid.add(b[0][7],7, 0);
         
         b[1][0] = makeButton(new Image("file:TrebekY.JPG"));
         imagegrid.add(b[1][0],0, 1);
      
         b[1][1] = makeButton(new Image("file:TrebekNow.JPG"));
         imagegrid.add(b[1][1],1, 1);
      
         b[1][2] = makeButton(new Image("file:TrebekB.JPG"));
         imagegrid.add(b[1][2],2, 1);
      
         b[1][3] = makeButton(new Image("file:Vanna.JPG"));
         imagegrid.add(b[1][3],3, 1);
         
         b[1][4] = makeButton(new Image("file:Brady.JPG"));
         imagegrid.add(b[1][4],4, 1);
      
         b[1][5] = makeButton(new Image("file:Carey.JPG"));
         imagegrid.add(b[1][5],5, 1);
      
         b[1][6] = makeButton(new Image("file:MHall.JPG"));
         imagegrid.add(b[1][6],6, 1);
      
         b[1][7] = makeButton(new Image("file:Sayjak.JPG"));
         imagegrid.add(b[1][7],7, 1);
      
         b[2][0] = makeButton(new Image("file:BarkerOld.JPG"));
         imagegrid.add(b[2][0],0, 2);
      
         b[2][1] = makeButton(new Image("file:BarkerY.JPG"));
         imagegrid.add(b[2][1],1, 2);
      
         b[2][2] = makeButton(new Image("file:HarveyY.JPG"));
         imagegrid.add(b[2][2],2, 2);
      
         b[2][3] = makeButton(new Image("file:HarveyNow.JPG"));
         imagegrid.add(b[2][3],3, 2);
      
         b[2][4] = makeButton(new Image("file:Stiles.JPG"));
         imagegrid.add(b[2][4],4, 2);
      
         b[2][5] = makeButton(new Image("file:Mochrie.JPG"));
         imagegrid.add(b[2][5],5, 2);
      
         b[2][6] = makeButton(new Image("file:Howie.JPG"));
         imagegrid.add(b[2][6],6, 2);
      
         b[2][7] = makeButton(new Image("file:Banker.JPG"));
         imagegrid.add(b[2][7],7, 2);
         
         b[3][0] = makeButton(new Image("file:BarkerOld.JPG"));
         imagegrid.add(b[3][0],0, 3);
      
         b[3][1] = makeButton(new Image("file:BarkerY.JPG"));
         imagegrid.add(b[3][1],1, 3); 
      
         b[3][2] = makeButton(new Image("file:HarveyY.JPG"));
         imagegrid.add(b[3][2],2, 3); 
      
         b[3][3] = makeButton(new Image("file:HarveyNow.JPG"));
         imagegrid.add(b[3][3],3, 3);
         
         b[3][4] = makeButton(new Image("file:Stiles.JPG"));
         imagegrid.add(b[3][4],4, 3);
      
         b[3][5] = makeButton(new Image("file:Mochrie.JPG"));
         imagegrid.add(b[3][5],5, 3); 
      
         b[3][6] = makeButton(new Image("file:Howie.JPG"));
         imagegrid.add(b[3][6],6, 3); 
      
         b[3][7] = makeButton(new Image("file:Banker.JPG"));
         imagegrid.add(b[3][7],7, 3); 
         
         b[4][0] = makeButton(new Image("file:Robinson.JPG"));
         imagegrid.add(b[4][0],0, 4);
         
         b[4][1] = makeButton(new Image("file:Mandel.JPG"));
         imagegrid.add(b[4][1],1, 4);
         
         b[4][2] = makeButton(new Image("file:V&S.JPG"));
         imagegrid.add(b[4][2],2, 4);
         
         b[4][3] = makeButton(new Image("file:Trebeck.JPG"));
         imagegrid.add(b[4][3],3, 4);
         
         b[4][4] = makeButton(new Image("file:Fez.JPG"));
         imagegrid.add(b[4][4],4, 4);
         
         b[4][5] = makeButton(new Image("file:Summers.JPG"));
         imagegrid.add(b[4][5],5, 4);
         
         b[4][6] = makeButton(new Image("file:Koshy.JPG"));
         imagegrid.add(b[4][6],6, 4);
         
         b[4][7] = makeButton(new Image("file:Amanda.JPG"));
         imagegrid.add(b[4][7],7, 4);
         
         b[5][0] = makeButton(new Image("file:Robinson.JPG"));
         imagegrid.add(b[5][0],0, 5);
         
         b[5][1] = makeButton(new Image("file:Mandel.JPG"));
         imagegrid.add(b[5][1],1, 5);
         
         b[5][2] = makeButton(new Image("file:V&S.JPG"));
         imagegrid.add(b[5][2],2, 5);
         
         b[5][3] = makeButton(new Image("file:Trebek.JPG"));
         imagegrid.add(b[5][3],3, 5);
         
         b[5][4] = makeButton(new Image("file:Fez.JPG"));
         imagegrid.add(b[5][4],4, 5);
         
         b[5][5] = makeButton(new Image("file:Summers.JPG"));
         imagegrid.add(b[5][5],5, 5);
         
         b[5][6] = makeButton(new Image("file:Koshy.JPG"));
         imagegrid.add(b[5][6],6, 5);
         
         b[5][7] = makeButton(new Image("file:Amanda.JPG"));
         imagegrid.add(b[5][7],7, 5);
         
         b[6][0] = makeButton(new Image("file:JWinner.JPG"));
         imagegrid.add(b[6][0],0, 6);
         
         b[6][1] = makeButton(new Image("file:Robinson2.JPG"));
         imagegrid.add(b[6][1],1, 6);
         
         b[6][2] = makeButton(new Image("file:V&SY.JPG"));
         imagegrid.add(b[6][2],2, 6);
         
         b[6][3] = makeButton(new Image("file:BarkerLove.JPG"));
         imagegrid.add(b[6][3],3, 6);
         
         b[6][4] = makeButton(new Image("file:CareyOld.JPG"));
         imagegrid.add(b[6][4],4, 6);
         
         b[6][5] = makeButton(new Image("file:TrebekHot.JPG"));
         imagegrid.add(b[6][5],5, 6);
         
         b[6][6] = makeButton(new Image("file:Trump.JPG"));
         imagegrid.add(b[6][6],6, 6);
         
         b[6][7] = makeButton(new Image("file:HOTTrebek.JPG"));
         imagegrid.add(b[6][7],7, 6);
         
         b[7][0] = makeButton(new Image("file:JWinner.JPG"));
         imagegrid.add(b[7][0],0, 7);
         
         b[7][1] = makeButton(new Image("file:Robinson2.JPG"));
         imagegrid.add(b[7][1],1, 7);
         
         b[7][2] = makeButton(new Image("file:V&SY.JPG"));
         imagegrid.add(b[7][2],2, 7);
         
         b[7][3] = makeButton(new Image("file:BarkerLove.JPG"));
         imagegrid.add(b[7][3],3, 7);
         
         b[7][4] = makeButton(new Image("file:CareyOld.JPG"));
         imagegrid.add(b[7][4],4, 7);
         
         b[7][5] = makeButton(new Image("file:TrebekHot.JPG"));
         imagegrid.add(b[7][5],5, 7);
         
         b[7][6] = makeButton(new Image("file:Trump.JPG"));
         imagegrid.add(b[7][6],6, 7);
         
         b[7][7] = makeButton(new Image("file:HOTTrebek.JPG"));
         imagegrid.add(b[7][7],7, 7);
      }     
      return(b);}
  
   class ButtonClickHandler implements EventHandler<ActionEvent> {
   
      @Override
      
      public void handle(ActionEvent event) {
      
         images = makeAnImageGrid(imagegrid, mg.getBoardSize());// added function here
      
         if(numberoftries < 32){
         
            for(int r=0;r<mg.getBoardSize();r++){ //added getSize func here
               for(int c = 0;c<mg.getBoardSize();c++){//added getSize here
                  if(event.getSource().equals(buttons[r][c])){ 
                     if(newTurnCount%2==0){
                        grid.getChildren().remove(buttons[r][c]);
                        grid.add(images[r][c],c, r);
                        coorlist[0] = r;
                        coorlist[1] = c;
                        newTurnCount++;}
                     else {
                        grid.add(images[r][c],c, r);
                        coorlist[2] = r;
                        coorlist[3] = c;
                        newTurnCount++;} 
                  }}}
            
         
            if(newTurnCount%2==0){   
            
               mg.takeTurn(coorlist); 
               boolean row = mg.isMatch(coorlist);
            
               if(row){
                  numberoftimeswon = numberoftimeswon + 1;
                  numberoftries = numberoftries + 1;
                  resultLabel.setText("MATCH!" + "\n" + "You tried: " + numberoftries + " time(s).");
                  if(numberoftimeswon == (mg.getBoardSize())){//Addes Size func here
                     resultLabel.setText("You won the game!");} 
               }
               
               else if(!row){  
                  numberoftries = numberoftries + 1;
                  resultLabel.setText("NOT A MATCH!" + "\n" + "Click the buttons again to flip them over." + "\n" + "You tried: " + numberoftries + " time(s).");
               
                  buttons[coorlist[0]][coorlist[1]] = makeButton(new Image("file:mark.jpg"));
                  grid.add(buttons[coorlist[0]][coorlist[1]],coorlist[1],coorlist[0]); 
                  buttons[coorlist[0]][coorlist[1]].setOnAction(new ButtonClickHandler());
               
                  buttons[coorlist[2]][coorlist[3]] = makeButton(new Image("file:mark.jpg")); 
                  buttons[coorlist[2]][coorlist[3]].setOnAction(new ButtonClickHandler());
                  grid.add(buttons[coorlist[2]][coorlist[3]],coorlist[3],coorlist[2]);}
            
            }}
         
         else
            resultLabel.setText("You tried more than 32 times. GAME OVER.");
      
      }}

// class
class SecondButtonClickHandler implements EventHandler<ActionEvent> {

   @Override
   
   public void handle(ActionEvent event) {
   
   if(smallButton.isSelected()){
     boardSize = 2;
     mg.setBoard(boardSize);
      
      }
   else if(mediumButton.isSelected()){
      boardSize = 4;
     mg.setBoard(boardSize);
     

      }
   else if(largeButton.isSelected()){
      boardSize = 8;
     mg.setBoard(boardSize);
     
      }

}
}}

// class