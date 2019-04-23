import java.util.*; 

class MemoryGame implements Game{
  boolean isWinner;
  boolean isMatch;
  boolean isValid;
  String gameStatus;
  int boardSize;
  int turnCount;
  int[][] card1 = new int[boardSize][boardSize];
  int[][] card2 = new int[boardSize][boardSize]; 
  int[][] secretBoard = new int[boardSize][boardSize]; 
   
   //Default constructor
   public void setUp(){
      isWinner = false;
      boardSize = 2;
      turnCount = 0;
      secretBoard[0][0] = 1;
      secretBoard[0][1] = 1;
      secretBoard[1][0] = 2;
      secretBoard[1][1] = 2;
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
