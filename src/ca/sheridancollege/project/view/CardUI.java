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
import ca.sheridancollege.project.model.Validator;
import ca.sheridancollege.project.model.generateCard;
import ca.sheridancollege.project.model.validPlayer;
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
    validPlayer player;
    Game blackjackGame;

    //int[] dealerPower = new int[2];
    
    /**
     * interact with player by entering the name, and display the message if the name is invalid
     */
    public void initialPlayer(){
        System.out.println("Enter your name");
        String playerName = input.nextLine();
        
        if(Validator.ValidateName(playerName)){
            player = new validPlayer(playerName);
            //Add to playerlist if player is valid
            Validator.addPlayer(player);
        }
        else
            System.out.println("The name is repeated try other name to join the game!");         
    }
    
    /**
     * initial get two hand cards
     */
    public void initialCardsForPlayer(){
        
        player.setHandPlayer(generateCard.dispute(2));
        
        //Singleton, make sure BlackjackGame Object only create once
        blackjackGame = BlackjackGame.getInstance();
        
        System.out.println("Welcome to "+blackjackGame.getName());
            
            //set the playerlist to start playing the game
            blackjackGame.play();
            ArrayList<Player> players = blackjackGame.getPlayers();

            for(Player p: players)
            {    
                System.out.println("Here is your cards, good luck");
                for (Card card : player.getHandPlayer()) {
                    System.out.printf("%s of %s\n", card.getValue(), card.getSuit());
                    // System.out.printf("%d", card.getValue().getPower());

                    player.totalPlayer += card.getValue().getPower();
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

        //int totalPlayer = handPlayer[0].getValue().getPower() + handPlayer[1].getValue().getPower();
        int totalDealer = handDealer[0].getValue().getPower() + handDealer[1].getValue().getPower();
        while(!(hitorstand==1 | hitorstand==2))
        {    
            System.out.println("Enter 1 for hit and 2 for stand for this round.");
            hitorstand = input.nextInt();
            while(hitorstand == 1)
            {
                Card[] addcard = generateCard.dispute(1);
                player.getHandPlayer().add(addcard[0]);
                System.out.println("Here is your adding card");
                System.out.printf("%s of %s\n", addcard[0].getValue(), addcard[0].getSuit()); 
                player.totalPlayer += addcard[0].getValue().getPower();
                //System.out.println(totalPlayer);
                if(player.totalPlayer > 21 | player.totalPlayer == 21) {
                    System.out.println("Here is the dealer second card");                 
                    System.out.printf("%s of %s\n", handDealer[1].getValue(), handDealer[1].getSuit());
                    blackjackGame.declareWinner(player.totalPlayer, totalDealer); 
                    
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
                System.out.println("Your hand in total is: " + player.totalPlayer);
                blackjackGame.declareWinner(player.totalPlayer, totalDealer);
                        
            }
        }
    }
    
}
