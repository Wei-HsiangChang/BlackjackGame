/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.model;

import ca.sheridancollege.project.model.Card.Suit;
import ca.sheridancollege.project.model.Card.Value;
import java.util.Random;




/**
 *
 * @author Wei-Hsiang Chang
 */
public class generateCard {
    public static Card[] dispute(int cards_num, Value[] cardValues, Suit[] cardSuits)
    {
        
        Card[] handcard = new Card[cards_num];
        Random random = new Random();
        
        for(int i=0;i<handcard.length;i++)
        {
            Card.Value value = cardValues[random.nextInt(cardValues.length)];
            Card.Suit suit = cardSuits[random.nextInt(cardSuits.length)];

            BlackjackCards card = new BlackjackCards(value, suit);
            handcard[i] = card;
            
        }
        return handcard;
        
                
    }   
    
}
