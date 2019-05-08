import java.util.*; 

class MemoryGame4 implements Game{
  boolean isWinner;
  boolean isMatch;
  boolean isValid;
  String gameStatus;
  int boardSize;
  int turnCount;
  boolean match;
  int matchCount = 0;
  
  int[][] card1 = new int[boardSize][boardSize];
  int[][] card2 = new int[boardSize][boardSize]; 
  int[][] secretBoard = new int[boardSize][boardSize];
 
   //Default constructor
   public void setUp(){
      isWinner = false;
      
      turnCount = 0;
   }
  //Set up the hidden board 
   public void setBoard(int boardSize1){
     boardSize = boardSize1;
    if(boardSize1==2){
      secretBoard[0][0] = 1;
      secretBoard[0][1] = 1;
      secretBoard[1][0] = 2;
      secretBoard[1][1] = 2;
    }
    if(boardSize1==4){
         secretBoard[0][0] = 0;
         secretBoard[0][1] = 1;
         secretBoard[0][2] = 2;
         secretBoard[0][3] = 3;
         
         secretBoard[1][0] = 0;
         secretBoard[1][1] = 1;
         secretBoard[1][2] = 2;
         secretBoard[1][3] = 3;           
      
         secretBoard[2][0] = 4;
         secretBoard[2][1] = 5;
         secretBoard[2][2] = 6;
         secretBoard[2][3] = 7;
         
         secretBoard[3][0] = 4;
         secretBoard[3][1] = 5;
         secretBoard[3][2] = 6;
         secretBoard[3][3] = 7;   
  }  
    if(boardSize1 ==8){
         secretBoard[0][0] = 0;
         secretBoard[0][1] = 1;
         secretBoard[0][2] = 2;
         secretBoard[0][3] = 3;
         
         secretBoard[1][0] = 0;
         secretBoard[1][1] = 1;
         secretBoard[1][2] = 2;
         secretBoard[1][3] = 3;           
      
         secretBoard[2][0] = 4;
         secretBoard[2][1] = 5;
         secretBoard[2][2] = 6;
         secretBoard[2][3] = 7;
         
         secretBoard[3][0] = 4;
         secretBoard[3][1] = 5;
         secretBoard[3][2] = 6;
         secretBoard[3][3] = 7; 
         
         secretBoard[4][0] = 8;
         secretBoard[4][1] = 9;
         secretBoard[4][2] = 10;
         secretBoard[4][3] = 11;
         
         secretBoard[5][0] = 8;
         secretBoard[5][1] = 9;
         secretBoard[5][2] = 10;
         secretBoard[5][3] = 11;
         
         secretBoard[6][0] = 12;
         secretBoard[6][1] = 13;
         secretBoard[6][2] = 14;
         secretBoard[6][3] = 15;
         
         secretBoard[7][0] = 12;
         secretBoard[7][1] = 13;
         secretBoard[7][2] = 14;
         secretBoard[7][3] = 15;
    }         
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
   public int getBoardSize(){
      return boardSize;
   }//getBoardSize
         
   //Mutators
   public void setBoardSize(int x){
      boardSize = x;
   }//setBoardSize   
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
      else {
        match = false;
        return match;
       }
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