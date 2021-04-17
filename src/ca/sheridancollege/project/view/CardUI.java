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
 *
 * @author Michael
 */
public class CardUI {
    GroupOfCards groupCards = new GroupOfCards();
    Scanner input = new Scanner(System.in);;
    Value[] cardValues = Value.values();
    Suit[] cardSuits = Suit.values();
    
    
    /**
     * initial get two hand cards
     */
    public void initialCardsForPlayer(){
        
        Card[] handPlayer = generateCard.dispute(2);
        
        Game blackjackGame = new BlackjackGame("Blackjack");
           
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
        
        for(Player p: players)
        {    
            System.out.println("Here are the cards for "+p.getName()+" in the desk");
            for (Card card : handPlayer) {
                System.out.printf("%s of %s\n", card.getValue(), card.getSuit());
            }
        }
        
        
         
    }
    
    public void initialCardsForDealer(){
        
        Card[] handDealer = generateCard.dispute(2);
        Card opencardDealer = handDealer[0];
        System.out.println("Here is one card showing, and the other one folded for the dealer in the desk");   
        System.out.printf("%s of %s\n", opencardDealer.getValue(), opencardDealer.getSuit());
        
    }
    
    public void hitorStandFromUser(){
        int hitorstand =3 ;
        while(!(hitorstand==1 | hitorstand==2))
        {    
            System.out.println("Enter 1 for hit and 2 for stand for this round.");
            hitorstand = input.nextInt();
            while(hitorstand == 1)
            {
                Card[] addcard = generateCard.dispute(1);
                System.out.println("Here is your adding card");
                System.out.printf("%s of %s\n", addcard[0].getValue(), addcard[0].getSuit()); 
                System.out.println("Enter 1 for hit and 2 for stand for this round.");
                hitorstand = input.nextInt();
                
            }    
            if(hitorstand == 2)
            {
                System.out.println("You choose stand for this round");           
            }
        }
    }
    
}
