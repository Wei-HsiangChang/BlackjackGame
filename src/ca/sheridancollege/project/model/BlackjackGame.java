/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.model;

import java.util.ArrayList;

/**
 * Follow Liskov Substitution principle as a reasonable substitute for superclass
 * @author Wei-Hsiang Chang
 */
public class BlackjackGame extends Game{
    private static String gamename; 
    private static Game instance = null;
    
    /**
     * Use Singleton pattern to create only one instance at a time
     */
    public static Game getInstance(){
        
            if(instance == null){
                instance = new BlackjackGame("Blackjack World");
            }
            return instance;
        }
    

    private BlackjackGame(String gamename) {
        super(gamename);
        this.gamename = gamename;
    }
    
    
    /**
     * When players are validate, and add to playerlist, game start playing
     */
    @Override
    public void play()
    {  
        setPlayers(Validator.playerlist);
        //invoke Player.play method
        for(Player p : getPlayers())
            p.play();
    }        
    
    /**
     * Terminate the Game, Use the method to display the winner, and end the game.
     */
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
