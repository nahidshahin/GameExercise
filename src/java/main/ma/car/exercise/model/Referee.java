package ma.car.exercise.model;

import java.util.List;
import java.util.ArrayList;

/** Author: Nahid Mahbub<br>
 * Date: 04-OCT-2014 */

public class Referee {
    private PlayingArea playingArea;

    private List<Player> ejectedPlayers;

    public Referee(PlayingArea playingArea) {
	this.playingArea = playingArea;
	ejectedPlayers = new ArrayList();
    }

    public void giveYellowCard(Player curpl) {
	System.out.println(curpl + " shown a Yellow Card" );
	curpl.setNumOfYellowCards( curpl.getNumOfYellowCards() + 1 );

	if( curpl.getNumOfYellowCards() >= 2 ) {
	    curpl.setOffFrom( playingArea.getTime() );
	}
    }

    //ask for permission
    public boolean canPlay(Player curpl) {
	if( curpl.getNumOfYellowCards() >= 2 ) {
	    for( Player pl : ejectedPlayers ) {
		if( pl.getNumber() == curpl.getNumber() ) {
		    //Player is ejected once so can't play
		    return false;
		}
	    }
	    ejectedPlayers.add( curpl );
	}
	return true;
    }

}
