/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_9;

import java.util.ArrayList;
import utils.Link;


/**
 *
 * @author dynnammo
 */
public class Game {
    int lastMarbleWorth = 0;
    int playerNumber = 0;
    Link currentMarble;
    ArrayList<Player> players = new ArrayList<>();

    public Game(int givenPlayerNumber, int givenMarblesNumber) {
        lastMarbleWorth = givenMarblesNumber;
        playerNumber = givenPlayerNumber;
        for (int i = 0; i < playerNumber; i++)
            players.add(new Player());
    }
    
    private void initGame(){
        currentMarble =  new Link(0);
    }
    

    public void execute(){
        initGame();
        Player currentPlayer;
        for (int marbleValue = 1; marbleValue <= lastMarbleWorth ;marbleValue++) { 
            currentPlayer = players.get((marbleValue-1) % playerNumber);
            makeTurn(currentPlayer,marbleValue);
        }
        System.out.println("Game ended");
    }

    private void makeTurn(Player currentPlayer, int marbleValue) {
        if (marbleValue % 23 == 0) {
            Link marbleToRemove = currentMarble.getPrevious(7);
            currentPlayer.score += marbleValue + marbleToRemove.value;
            marbleToRemove.removeLink();
            currentMarble = currentMarble.getPrevious(6);
        } else {
            currentMarble = currentMarble.getNext().addLink(marbleValue);
        }
    }
    
    public long[] getWinner(){
        long max = 0;
        long winnerIndex = 0;
        for (long i = 0; i < players.size(); i++) {
            Player player = players.get((int) i);
            if (player.score > max){
                winnerIndex = i;
                max = player.score;
            }
        }
        return new long[]{winnerIndex,max};
    }
}
