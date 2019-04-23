import java.util.*; 

class MemoryGame implements Game{
  boolean isWinner;
  boolean isMatch;
  boolean isValid;
  String gameStatus;
  int boardSize;
  int turnCount; 
   
   //Default constructor
   public void setUp(){
      isWinner = false;
      boardSize = 2;
      turnCount = 0;
      }
      
   //Accessors
   public boolean isWinner(){
      return isWinner;
   }
   
   public int getTurnCnt(){
      return turnCount;
   }
   //Mutators
   //needs work
   public void takeTurn(int[] x){
      turnCount++;
   }
   
   public boolean isValidInput(int [] x){
      isValid = true;
      return isValid;
   }   
         
   public String gameOverStatus(){
      if(isWinner == true)
         return("won");
      else
         return("NA");
   }
         
}// Game class