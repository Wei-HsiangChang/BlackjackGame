/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.model;

import ca.sheridancollege.project.model.Card.Suit;
import ca.sheridancollege.project.model.Card.Value;
import java.util.ArrayList;
import java.util.Random;




/**
 * // follow single responsibility principle, focus only one thing.
 * @author Wei-Hsiang Chang
 */
public class generateCard {
    
    
    
    public static Card[] dispute(int cards_num)
    {
        
        
        Card[] handcard = new Card[cards_num];
        Random random = new Random();
        
        for(int i=0;i<handcard.length;i++)
        {
            int j=0;
            ArrayList<Card> deckCards = GroupOfCards.getCards();              
            handcard[i] = deckCards.get(j);
            //remove 1 card when dispute the card
            deckCards.remove(j);
        }
        return handcard;
        
                
    }   
    
}
