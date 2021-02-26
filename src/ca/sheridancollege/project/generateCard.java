/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Suit;
import ca.sheridancollege.project.Card.Value;




/**
 *
 * @author Wei-Hsiang Chang
 */
public class generateCard {
    public Card[] dispute(int cards_num, Value[] cardValues, Suit[] cardSuits)
    {
        
        Card[] handcard = new Card[cards_num];
        
        for(int i=0;i<handcard.length;i++)
        {
            int randomValue = (int)Math.random()*(cardValues.length);
            int rnadomSuit = (int)Math.random()*(cardValues.length);
            Card.Value handValue = cardValues[randomValue];
            Card.Suit handSuit = cardSuits[rnadomSuit];
            
            BlackjackCards BlackjackCard = new BlackjackCards(handValue,handSuit);          
            handcard[i]= BlackjackCard;
            
        }
        return handcard;
        
                
    }
    
    public String toString()
    {
        return"";
    }     
    
}
