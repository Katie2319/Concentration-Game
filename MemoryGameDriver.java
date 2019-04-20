import java.util.*;

class MemoryGameDriver{
   public static void main(String argv[]){
      Scanner sc = new Scanner(System.in); 
   
      int xcoor1;
      int ycoor1;
      int xcoor2;
      int ycoor2;  
      
      
      MemoryGame mg = new MemoryGame(); 
      
      
       while (!mg.isWinner()){
       
        int [] coor;
      do{ 
        if (mg.getTurnCnt()%2 ==0){//flipping first card
              System.out.println("What place do you want to play? Enter [row]");
               xcoor1 = sc.nextInt(); 
             System.out.println("What place do you want to play? Enter [column]");
               ycoor1 = sc.nextInt(); 
               coor[0] = xcoor1;
               coor[1] = ycoor1;}
               
        else {// flipping second card 
           System.out.println("What place do you want to play? Enter [row]");
               xcoor2 = sc.nextInt(); 
             System.out.println("What place do you want to play? Enter [column]");
               ycoor2 = sc.nextInt(); 
               coor[2] = xcoor2;
                coor[3] = ycoor2;}
        }while(!mg.isValidInput(coor));
                 mg.takeTurn(coor);} 
       
     String result = mg.gameOverStatus();
     System.out.println(result);
      
      
   } // main
} // class