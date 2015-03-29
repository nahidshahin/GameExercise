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

public class PlayingAreaTest {
    private Player p1, p2, p3;
    private PlayingArea pa;

    @Before
    public void setUp() throws Exception {
	p1 = new Player(1);
	p2 = new Player(2);
	p3 = new Player(3);
	p1.setPosition( new Cell(1,1) );
	p2.setPosition( new Cell(1,3) );
	p3.setPosition( new Cell(1,4) );
	pa = new PlayingArea(100, 100);
    }

    @After
    public void tearDown() throws Exception {
    }


    /**
     * Assert check the Util methods
     */
    @Test
    public void testMotods() {
	assertFalse( pa.isInSafeDistance(p1, p2) );
	assertFalse( PlayingArea.isInSafeDistance(p1, p2 ) );
	assertTrue( PlayingArea.isInSafeDistance(p1, p3 ) );
	
	p2.makeAMove(3); // down
	assertTrue( PlayingArea.isInSafeDistance(p1, p2 ) );
    }

    @Test
    public void testMoves() {
	//Check left move
	assertFalse( pa.varifyMove(p1, 0) ); 
	//Check right move
	assertTrue( pa.varifyMove(p1, 1) ); 
	//Check up move
	assertFalse( pa.varifyMove(p1, 2) ); 
	//Check down move
	assertTrue( pa.varifyMove(p1, 3) ); 
    }

}

