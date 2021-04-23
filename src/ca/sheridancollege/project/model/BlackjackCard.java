/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.model;

/**
 * Follow Liskov Substitution principle as a reasonable substitute for superclass
 * @author Wei-Hsiang Chang 
 */


public class BlackjackCard extends Card{
    
    // Use arg constructor to call superclas data field, reduce repeat method and data promotes DRY principle
    public BlackjackCard(Value value, Suit suit) {
        super(value, suit);
    }
    
    
    
    public String toString()
    {
        return"BlackjackCards";
    }        
    
}
