/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @author Wei-Hsiang Chang
 */
package ca.sheridancollege.project.model;

/**
 * @author Wei-Hsiang Chang 
 */
public class ValidatePlayer {
    
    static boolean isValidPlayer =true;
    
    /**
     * @Examine whether the name of the player repeated to set valid or not.  
     */
    public static boolean ValidateName(String playername, String[] playerlist)
    {
        for(int i=0; i<playerlist.length; i++)
        {
            if(playerlist[i] == playername)
            {    
                isValidPlayer = false;
                break;
            }               
        }
        return isValidPlayer;
    } 
    
   
    
}

