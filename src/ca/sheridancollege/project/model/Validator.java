/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @author Wei-Hsiang Chang
 */
package ca.sheridancollege.project.model;

import java.util.ArrayList;

/**
 * @author Wei-Hsiang Chang 
 */
public class Validator {
    
    static boolean isValidPlayer =true;
    public static ArrayList<Player> playerlist = new ArrayList();
    
    /**
     * @Examine whether the name of the player repeated to set valid or not.  
     */
    public static boolean ValidateName(String playername)
    {
        if(!playerlist.isEmpty())
        for(Player player : playerlist)
        {
            if(player.getName() == playername)
            {   
                isValidPlayer = false;
                break;
            }               
        }
        return isValidPlayer;
    } 

    
    public static ArrayList<Player> addPlayer(Player validPlayer)
    {        
    if(ValidateName(validPlayer.getName()))
        playerlist.add(validPlayer);
    return playerlist;
    }
    
    
    
    
    
   
    
}

