import java.util.*;
import java.util.ArrayList; 

class MemoryGameDriver{
   public static void main(String argv[]){
      Scanner sc = new Scanner(System.in); 
   
      int xcoor1;
      int ycoor1;
      int xcoor2;
      int ycoor2;  
      
      
      MemoryGame mg = new MemoryGame(); 
      

      
       while (!mg.isWinner()){
       int [] coor  = new int [4]; 
       do{ 
              System.out.println("What place do you want to play? Enter [row]");
               xcoor1 = sc.nextInt(); 
             System.out.println("What place do you want to play? Enter [column]");
               ycoor1 = sc.nextInt(); 
               coor[0] = xcoor1;
               coor[1] = ycoor1; //flipping first card
               System.out.println("What place do you want to play? Enter [row]");
               xcoor2 = sc.nextInt(); 
               System.out.println("What place do you want to play? Enter [column]");
               ycoor2 = sc.nextInt(); 
                coor[2] = xcoor2;
                coor[3] = ycoor2;}//flipping first card
        while(!mg.isValidInput(coor));
                 mg.takeTurn(coor);} 
       
     String result = mg.gameOverStatus();
     System.out.println(result);  
      
   } // main
} // class