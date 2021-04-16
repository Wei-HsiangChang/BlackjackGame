/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.view;

import ca.sheridancollege.project.model.Card;
import ca.sheridancollege.project.model.Card.Suit;
import ca.sheridancollege.project.model.Card.Value;
import ca.sheridancollege.project.model.generateCard;
import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class CardUI {
    Scanner input;
    
    public CardUI() {
        input = new Scanner(System.in);
    }
    
    /**
     * initial get two hand cards
     */
    public void initialCardsForPlayer(){
        
        Value[] cardValues = Value.values();
        Suit[] cardSuits = Suit.values();

        Card[] handplayer = generateCard.dispute(2, cardValues, cardSuits);
        Card[] handdealer = generateCard.dispute(2, cardValues, cardSuits);

        System.out.println("Here are the cards for the player in the desk");
        for (Card card : handplayer) {
            System.out.printf("%s of %s\n", card.getValue(), card.getSuit());
        }
        System.out.println("Here are the cards for the dealer in the desk");
        for(Card card : handdealer) {
            System.out.printf("%s of %s\n", card.getValue(), card.getSuit());
        }
        
    
    }
    
//    public Object hitorStandFromUser(){
//    
//    
//    }
    
}
