import java.util.*;
public class numbergame
{
    public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 int chances=8;

 int finals=0;
 boolean playAgain = true;  
 System.out.println("welcome Buddy!"); 
 System.out.println("Hey Buddy you have about   " + chances + "   to win the game");
 while(playAgain)
 {
   int rand = getrandN(1,100);
   boolean guess = false;
   for(int i=0;i<chances;i++)
   {
     System.out.println("chance"+(i+1)+"  Enter your guess");
     int user=sc.nextInt();
     if(user==rand){
        guess=true;
        finals+=1;
         System.out.println("You won it");
         break;
     }
     else if(user>rand)
     {
         System.out.println("Too High");

     }
     else
     {
         System.out.println("Too Low");
     }
   }
   if(guess==false)
   {
     System.out.println("Sorry BUddy. You lost the chances.the number is "+ rand);
   } 
    System.out.println("Do you want to play Again(yes/no)");
    String pA=sc.next();
    playAgain = pA.equalsIgnoreCase("yes");
 }
 System.out.println("That's it Buddy,Hope You enjoyed it");
  System.out.println("Here is your Score"+ finals);
}
  public static int getrandN(int min,int max)
  {
    return(int)(Math.random()*(max-min+1)+min);
  }
}

