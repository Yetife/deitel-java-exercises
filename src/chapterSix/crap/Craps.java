package chapterSix.crap;

import java.security.SecureRandom;

public class Craps {
    private static final SecureRandom randomNumbers = new SecureRandom();

    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args) {
        int myPoint = 0;
        Status gameStatus;
        int sum0fDice = rollDice();

        switch (sum0fDice) {
            case SEVEN, YO_LEVEN -> gameStatus = Status.WON;
            case SNAKE_EYES, TREY, BOX_CARS -> gameStatus = Status.LOST;
            default -> {
                gameStatus = Status.CONTINUE;
                myPoint = sum0fDice;
                System.out.printf("Point is %d%n", myPoint);
            }
        }
        while(gameStatus == Status.CONTINUE){
            sum0fDice = rollDice();
            if(sum0fDice == myPoint){
                gameStatus = Status.WON;
            }
            else if(sum0fDice == SEVEN){
                gameStatus = Status.LOST;
            }
        }

        if ( gameStatus == Status.WON)
            System.out.println("Player wins");
        else
            System.out.println("Player loses");
    }

    private static int rollDice() {
        int numberOfDice1 = 1 + randomNumbers.nextInt(6);
        int numberOfDice2 = 1 + randomNumbers.nextInt(6);
        int sum;
        sum = numberOfDice1 + numberOfDice2;

        System.out.printf("Player rolled %d + %d = %d%n",
                numberOfDice1, numberOfDice2, sum);
        return sum;
    }
}
