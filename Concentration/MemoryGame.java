import java.util.*; 

class MemoryGame implements Game{
  boolean isWinner;
  boolean isMatch;
  boolean isValid;
  String gameStatus;
  int boardSize = 2;
  int turnCount;
  boolean match;
  int matchCount = 0;
  
  int[][] card1 = new int[boardSize][boardSize];
  int[][] card2 = new int[boardSize][boardSize]; 
  int[][] secretBoard = new int[boardSize][boardSize];
 
   //Default constructor
   public void setUp(){
      isWinner = false;
      boardSize = 2;
      turnCount = 0;
   }
  //Set up the hidden board 
   public void setBoard(){ 
      secretBoard[0][0] = 1;
      secretBoard[0][1] = 1;
      secretBoard[1][0] = 2;
      secretBoard[1][1] = 2; 
  }  
   
   //Accessors
   public boolean isWinner(){
         return isWinner;
   }//isWinner
   
   public int getTurnCnt(){
      return turnCount;
   }//getTurnCount
   
   public int getMatchCount(){
      return matchCount;
   }//getMatchCount
      
   //Mutators

   public void takeTurn(int[] x){
      turnCount++;
   }//takeTurn
         
   public boolean isValidInput(int [] x){
      isValid = true;
      return isValid;
   } //isValidInput  
         
   public String gameOverStatus(){
      if(isWinner == true)
         return("won");
      else
         return("NA");
   }//gameOverStatus
   
   public boolean isMatch(int[] x){
      if(secretBoard[x[0]][x[1]] == secretBoard[x[2]][x[3]]){
        match = true;
        return match;  
      }
      else 
        match = false;
        return match;
   }//isMatch
   
   public int matchCount(){
      if(match == true){
         matchCount++;
      }   
      return matchCount;
   }
        
   public void checkWinner(){
      if(matchCount >= 2){
         isWinner = true;
      }
      else
         isWinner = false;
   }//checkWinner  
     
}// Game class
