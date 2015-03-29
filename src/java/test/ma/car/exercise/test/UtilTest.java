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

public class UtilTest {
    private Player p1, p2;

    @Before
    public void setUp() throws Exception {
	p1 = new Player(1);
	p2 = new Player(2);
	p1.setPosition( new Cell(1,1) );
	p2.setPosition( new Cell(2,2) );
    }

    @After
    public void tearDown() throws Exception {
    }


    /**
     * Assert check the Util methods
     */
    @Test
    public void testGameUtil() {
	assertTrue( Util.getRandomNumber(100,100) == 100 );
	int randNum = Util.getRandomNumber(1,100);
	assertTrue( randNum >= 1 && randNum <= 100 );
	assertTrue( Util.getDistance(p1,p2) == 2 );
    }

}

