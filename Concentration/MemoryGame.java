import java.util.*; 

class MemoryGame implements Game{
  boolean isWinner;
  boolean isMatch;
  boolean isValid;
  String gameStatus;
  int boardSize;
  int turnCount;
  int[][] card1 = new int[2][2];
  int clickedCard1;
  int[][] card2 = new int[2][2]; 
  int clickedCard2;
  int[][] secretBoard = new int[2][2]; 
   
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
      card1[x[0]][x[1]] = 1;
      card2[x[2]][x[3]] = 1;
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
   public boolean isMatch(int[] x){
      if(card1[x[0]][x[1]] == secretBoard[x[0]][x[1]])
        return true;  
      else 
        return false;
     }  
}// Game class
