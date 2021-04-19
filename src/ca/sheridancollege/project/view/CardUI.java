/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.view;

import ca.sheridancollege.project.model.BlackjackGame;
import ca.sheridancollege.project.model.Card;
import ca.sheridancollege.project.model.Card.Suit;
import ca.sheridancollege.project.model.Card.Value;
import ca.sheridancollege.project.model.Game;
import ca.sheridancollege.project.model.GroupOfCards;
import ca.sheridancollege.project.model.Player;
import ca.sheridancollege.project.model.ValidatePlayer;
import ca.sheridancollege.project.model.generateCard;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Furkan Gonul
 * @author Michael
 */
public class CardUI {
    GroupOfCards groupCards = new GroupOfCards();
    Scanner input = new Scanner(System.in);;
    Value[] cardValues = Value.values();
    Suit[] cardSuits = Suit.values();
    Card[] handDealer ;
    Card[] handPlayer ;
    Game blackjackGame;
    int[] playerPower = new int[2];
    //int[] dealerPower = new int[2];
    /**
     * initial get two hand cards
     */
    public void initialCardsForPlayer(){
        
        Card[] handPlayer = generateCard.dispute(2);
        
        blackjackGame = new BlackjackGame("Blackjack World");
        
        System.out.println("Welcome to "+blackjackGame.getName());
           
        System.out.println("Enter your name");
        String playerName = input.nextLine();
        
        if(ValidatePlayer.ValidateName(playerName))
        {    
            Player player = new ValidatePlayer(playerName);
            //Add to playerlist if player is validate, otherwise not added. 
            ValidatePlayer.addPlayer(player);
            blackjackGame.setPlayers(ValidatePlayer.playerlist);
        }
        else
            System.out.println("The name is invalid, you can't join the game");
        
        ArrayList<Player> players = blackjackGame.getPlayers();
        int i = 0;
        for(Player p: players)
        {    
            System.out.println("Here is your cards "+p.getName() + " good luck");
            for (Card card : handPlayer) {
                System.out.printf("%s of %s\n", card.getValue(), card.getSuit());
               // System.out.printf("%d", card.getValue().getPower());
               
               playerPower[i] = card.getValue().getPower();
               i++;
               
            }
        }
        
        
         
    }
    
    public void initialCardsForDealer(){
        
        handDealer = generateCard.dispute(2);
        System.out.println("Here is one card in Dealer Hand");   
        System.out.printf("%s of %s\n", handDealer[0].getValue(), handDealer[0].getSuit());
        //System.out.printf("%s of %s\n", handDealer[1].getValue(), handDealer[1].getSuit());
        
    }
    
    public void hitorStandFromUser(){
        int hitorstand = 3;
        int totalPlayer = playerPower[0] + playerPower[1];
        //int totalPlayer = handPlayer[0].getValue().getPower() + handPlayer[1].getValue().getPower();
        int totalDealer = handDealer[0].getValue().getPower() + handDealer[1].getValue().getPower();
        while(!(hitorstand==1 | hitorstand==2))
        {    
            System.out.println("Enter 1 for hit and 2 for stand for this round.");
            hitorstand = input.nextInt();
            while(hitorstand == 1)
            {
                Card[] addcard = generateCard.dispute(1);
                System.out.println("Here is your adding card");
                System.out.printf("%s of %s\n", addcard[0].getValue(), addcard[0].getSuit()); 
                totalPlayer += addcard[0].getValue().getPower();
                //System.out.println(totalPlayer);
                if(totalPlayer > 21 | totalPlayer == 21) {
                    blackjackGame.declareWinner(totalPlayer, totalDealer);
                    break;
                }
                else 
                {
                    System.out.println("Enter 1 for hit and 2 for stand for this round.");
                    hitorstand = input.nextInt();
                                   
                }
                
             }    
            if(hitorstand == 2)
            {   
                
                System.out.println("You choose stand for this round");    
                System.out.println("Here is the dealer second card");                 
                System.out.printf("%s of %s\n", handDealer[1].getValue(), handDealer[1].getSuit());   
                System.out.println("Dealer hand in total is: " + totalDealer);
                System.out.println("Your hand in total is: " + totalPlayer);
                blackjackGame.declareWinner(totalPlayer, totalDealer);
                        
            }
        }
    }
    
}
