import java.util.*;

class GuessNumber{
    public static int Number_of_Guessings=20;

    public static void Game(){
        System.out.println("---------------------------------------***----------------------------------------");

        Scanner sc=new Scanner(System.in);
        //creating object of Random class for generating random numbers
        Random random=new Random();

        System.out.println("\n\nlet's start the Game\n\n");
        int num=random.nextInt(1,100);
        int count=0;

        System.out.println("Number : ***\n");
        System.out.println("GUESS THE NUMBER  (between 1 to 100)\n");

        //looping until guess the correct Number

        while(count<Number_of_Guessings)
        {
            count++;
            int guess=sc.nextInt();
            if(guess==num)
            {
                System.out.println("Congratulations You won the Game\n");
                System.out.println("\nHere is Your Score "+count+"/"+Number_of_Guessings);
                break;
            }
            else if(guess<num)
            {
                System.out.println("\nIts Too low !");
                System.out.println("\nTry again...");
            }
            else{
                System.out.println("\nIts Too High !");
                System.out.println("\nTry again");
            }
        }
        //if number of guessing completed
        if(count==Number_of_Guessings)
        {
            System.out.println("\nYou Lost the Game .........");
            System.out.println("\nHere is Your Score:  0/"+Number_of_Guessings);
            System.out.println("\nBetter luck next Time ");
        }
        System.out.println("---------------------------------------***----------------------------------------");

        System.out.println("\n\n1.Restart Game \n\n2.Close the Game\n");
        if(sc.nextInt()==1)
        {
            System.out.println("\nRestarting......");
            Game();
        }
        else{
            return;
        }

    }
    public static void main(String args[]) {
        Game();
        System.out.println("\nclosing the game........");
    }
}