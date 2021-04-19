/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.model;

/**
 *
 * @author Wei-Hsiang Chang
 */
public class BlackjackCard extends Card{

    public BlackjackCard(Value value, Suit suit) {
        super(value, suit);
    }
    
    
    
    public String toString()
    {
        return"BlackjackCards";
    }        
    
}
