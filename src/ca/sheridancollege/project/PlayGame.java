/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import ca.sheridancollege.project.model.BlackjackGame;
import ca.sheridancollege.project.model.Game;
import ca.sheridancollege.project.model.Player;
import ca.sheridancollege.project.view.CardUI;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class PlayGame {
    public static void main(String[] args){
    CardUI deal = new CardUI();

    deal.initialPlayer();
    deal.initialCardsForPlayer();
    deal.initialCardsForDealer();
    deal.hitorStandFromUser();
    }
      
}
