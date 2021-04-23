/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * separate the task to Validator, follow single responsibility principle
 * @author Wei-Hsiang Chang
 */
public class validPlayer extends Player{
    public static ArrayList<Card> handPlayer;
    public static int totalPlayer = 0;
    
    public validPlayer(String name) {
        super(name);
           
    }
    
    @Override
    public void play()
    {
        System.out.println("Hi, "+super.getName()+", Enjoy the game!");
    } 

    public ArrayList<Card> getHandPlayer() {
        return handPlayer;
    }

    public void setHandPlayer(Card[] handPlayer) {
        this.handPlayer = new ArrayList<Card>(Arrays.asList(handPlayer));
    }

    public int getTotalPlayer() {
        return totalPlayer;
    }

    public void setTotalPlayer(int totalPlayer) {
        this.totalPlayer = totalPlayer;
    }
    
    
}
