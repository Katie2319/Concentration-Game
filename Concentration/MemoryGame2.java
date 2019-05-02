import java.util.*; 

class MemoryGame2 implements Game{
  boolean isWinner;
  boolean isMatch;
  boolean isValid;
  String gameStatus;
  int boardSize = 2;
  int turnCount;
  boolean match;
  
  int[][] card1 = new int[boardSize][boardSize];
  int[][] card2 = new int[boardSize][boardSize]; 
  int[][] secretBoard = new int[boardSize][boardSize]; 
     
   //Default constructor
   public void setUp(){
      isWinner = false;
      boardSize = 2;
      turnCount = 0;
   }
   
   //Input Constructor
   public void setUp(int x){
      isWinner = false;
      boardSize = x;
      turnCount = 0;
   }
   
   public void setBoard2(){
      secretBoard[0][0] = 1;
      secretBoard[0][1] = 1;
      secretBoard[1][0] = 2;
      secretBoard[1][1] = 2;
   }
      
   //Set up the hidden board 
   public void setBoard4(){
   
      for(int i=0; i<4;i++){
         secretBoard[0][i] = 1;}
                        
      for(int i=0; i<4;i++){
         secretBoard[2][i] = 1;}

      for(int i=0; i<4;i++){
         secretBoard[1][i] = 2;}
         
      for(int i=0; i<4;i++){
         secretBoard[3][i] = 2;}   
  }
  
  //Set up the hidden board 
   public void setBoard8(){

      for(int i=0; i<8;i++){
         secretBoard[0][i] = 1;}
                        
      for(int i=0; i<8;i++){
         secretBoard[2][i] = 1;}
         
      for(int i=0; i<8;i++){
         secretBoard[4][i] = 1;}
 
      for(int i=0; i<8;i++){
         secretBoard[6][i] = 1;}   

      for(int i=0; i<8;i++){
         secretBoard[1][i] = 2;}
         
      for(int i=0; i<8;i++){
         secretBoard[3][i] = 2;}
         
      for(int i=0; i<8;i++){
         secretBoard[5][i] = 2;}
 
      for(int i=0; i<8;i++){
         secretBoard[7][i] = 2;}      
  } 
      
   //Accessors
   public boolean isWinner(){
      if(match == true){
         return isWinner;
      }
      else 
      return false;
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
      if(secretBoard[x[0]][x[1]] == secretBoard[x[2]][x[3]]){
        match = true;
        return match;  
      }
      else 
        match = false;
        return match;
     } 
  public boolean getIsMatch(){
     return match;
  }
}// Game class