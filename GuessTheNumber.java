import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        //initializing the colors
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String purple = "\u001B[35m";
        String cyan = "\u001B[36m";
        String reset = "\u001B[0m";
        Scanner scanner = new Scanner(System.in);
        int highScore = 0;
        int scnd = 0;
        int thrd = 0;
        int userChoice = 1;
        do {
            System.out.println(green + "Welcome to Guess the Number!" + reset);
            System.out.println(yellow + "1st." + highScore + "\n2nd." + scnd + "\n3rd." + thrd + reset);
            System.out.println(purple + "I have randomly chosen a number between 1 and 100.");
            System.out.println("Try to guess it!" + reset);
            System.out.println(cyan + "Enter the desired difficulty(1,2,3)\n"+  yellow + "1.Easy (1-50)\n2.Medium (1-100)\n3.Hard (1-200)" + reset); 
            int difficulty;
            int score = 11;
            difficulty = scanner.nextInt();
            int numberToGuess;
            switch (difficulty) {
                case 1:
                    numberToGuess = (int) (Math.random() * 50) + 1;    
                    break;
                case 2:
                    numberToGuess = (int) (Math.random() * 100) + 1;
                    break;
                case 3:
                    numberToGuess = (int) (Math.random() * 200) + 1;
                    break;
                default:
                    System.err.println(red + "Enter a valid difficulty number" + reset);
                    continue;
            }

            int userInput;
            int attemps = 0;
            do {
                System.out.print(cyan + "Enter your guess: " + reset);
                userInput = scanner.nextInt();
                attemps++;
                score--;
                if (userInput < numberToGuess) {
                    System.out.println(red + "Too low! Try again." + reset); 
                } else if (userInput > numberToGuess) {
                    System.out.println(red + "Too high! Try again." + reset);
                } else {
                    System.out.println(green+ "Congratulations! You guessed the number in " + attemps + " attemps! And your score is " + score + purple +" (Max score is 10)" + reset);
                
                if (score > highScore){
                    thrd = scnd;
                    scnd = highScore;
                    highScore = score;
                    System.out.println(purple + "New High Score! " + highScore + reset);
                //} else if (score < highScore){
                //    scnd = score;
                //    System.out.println("New Second Best! " + scnd);
            } else if (score > scnd) {
                // Update second-best
                    thrd = scnd;
                    scnd = score;
                    System.out.println(purple + "New Second Best! " + scnd + reset);
                } else if (score > thrd) {
                    thrd = score;
                    System.out.println(purple + "New Third Best! " + thrd + reset);
                }
            }
    } while (userInput != numberToGuess);
    System.out.println(cyan + "Do you want to play again?(1,2)\n" + yellow + "1.Yes\n2.No" + reset);
    userChoice = scanner.nextInt();    
        }while (userChoice == 1);
        scanner.close(); 
    } 
}