package ma.car.exercise.emulator;

import java.util.List;
import java.util.ArrayList;
import ma.car.exercise.model.*;
import ma.car.exercise.util.Util;

/** Author: Nahid Mahbub<br>
 * Date: 04-OCT-2014 */

public class GameEmulator {
    private PlayingArea playingArea;
    private Referee referee;

    public GameEmulator() {
	playingArea = new PlayingArea(100, 100);
	referee = new Referee( playingArea );
    }
    
    public void emulate() throws Exception {
	while(playingArea.getPlayers().size() > 1 ) {
	    List<Player> playerNextRound = new ArrayList<Player>();
	    for(Player curpl : playingArea.getPlayers() ) {

		if( curpl.getOffFrom() > 0 ) {
		    // the player is ejected from the game for 10 seconds
		    if( playingArea.getTime() - curpl.getOffFrom() < 10 ) {
			System.out.println(curpl + " is ejected at " + curpl.getOffFrom() + " sec" );
			playerNextRound.add(curpl);
			continue;
		    } else {
			curpl.setOffFrom(0);
			if( !referee.canPlay( curpl ) ) {
			    //skip this player
			    System.out.println(curpl + " removed");
			    continue;
			}
			curpl.setNumOfYellowCards(0);
		    }
		} 
		int nextMove = Util.getRandomNumber(0,3);
		while( !playingArea.varifyMove(curpl, nextMove) ) {
		    nextMove = Util.getRandomNumber(0,3);
		}
		curpl.makeAMove( nextMove );

		System.out.println(curpl + " moved to " + curpl.getPosition() );

		boolean validMove = true;
		for(Player pl : playingArea.getPlayers() ) {
		    if( curpl.getNumber() == pl.getNumber() || pl.getOffFrom() > 0 ) {
			continue;
		    }
		    if( !playingArea.isInSafeDistance(curpl, pl) ) {
			validMove = false;
			break;
		    } 
		}

		if( !validMove ) {
		    referee.giveYellowCard( curpl );
		}
		playerNextRound.add(curpl);
	    }
	    playingArea.setPlayers(playerNextRound);
	    playingArea.setTime( playingArea.getTime() + 1 );
	    System.out.println( "Playing time : " + playingArea.getTime() );
	    Thread.sleep(1000);
	}
	System.out.println(playingArea.getPlayers().get(0) + " win" );
    }

    public static void main(String[] args) throws Exception {
	(new GameEmulator()).emulate();
    }
 
}
