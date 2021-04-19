/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.model;

/**
 *
 * @author Michael
 */
public class BlackjackGame extends Game{
    private String gamename; 

    public BlackjackGame(String gamename) {
        super(gamename);
        this.gamename = gamename;
    }
    
    
    
    @Override
    public void play()
    {
    
    }        
            
    @Override
    public void declareWinner(int totalPlayer, int totalDealer) 
    {    
        
        if(totalPlayer > 21) {
            System.out.println("You are over 21, Dealer won");
            
        } 
        else if(totalPlayer == 21) {
            System.out.println("You hit the BLACKJACK!!!!");
            
        } 
        
        else {
        
            if(totalPlayer > totalDealer) {
                System.out.println("You won");
            } 
            else {
                System.out.println("Dealer won");

            }
        }
    
    }        
    
    
}
