package ma.car.exercise.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ma.car.exercise.util.Util;
import ma.car.exercise.model.*;

public class RefereeTest {
    private Player p1, p2;
    private PlayingArea pa;
    private Referee referee;

    @Before
    public void setUp() throws Exception {
	p1 = new Player(1);
	p2 = new Player(2);
	p1.setPosition( new Cell(1,1) );
	p2.setPosition( new Cell(1,3) );
	pa = new PlayingArea(100, 100);
	referee = new Referee(pa);
    }

    @After
    public void tearDown() throws Exception {
    }


    /**
     * Assert check the Util methods
     */
    @Test
    public void testMotods() {
	p1.setNumOfYellowCards(1);
	assertTrue( referee.canPlay(p1) );

	referee.giveYellowCard(p1);
	assertTrue( referee.canPlay(p1) ); // Added to already ejectedPlayers list

	//Now can't play
	assertFalse( referee.canPlay(p1) );
    }

}

