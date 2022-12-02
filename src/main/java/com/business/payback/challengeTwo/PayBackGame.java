package com.business.payback.challengeTwo;

import com.business.payback.challengeTwo.service.PayBackGameService;

import java.util.Scanner;

/**
 * @author : Nargess
 * run the game
 **/
public class PayBackGame {

    public static void main(String[] args) {

        while (true) {
            try {

                // Create a Scanner object
                Scanner myObj = new Scanner(System.in);
                System.out.println("Enter game round please : ");

                // Read user input
                int gameRound = myObj.nextInt();

                //call game starter
                PayBackGameService.startGame(gameRound);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }
}
