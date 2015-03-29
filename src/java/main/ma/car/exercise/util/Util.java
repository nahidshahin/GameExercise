package ma.car.exercise.util;

import java.util.Random;
import ma.car.exercise.model.*;

/** Author: Nahid Mahbub<br>
 * Date: 04-OCT-2014 */

public class Util {
    private static Random rand = new Random();

    public static int getRandomNumber(int min, int max) {
	return rand.nextInt((max-min) + 1) + min;
    }

    //returns manhattan distance between two players
    public static int getDistance(Player p1, Player p2) {
	return (int)Math.abs( p1.getPosition().getX() - p2.getPosition().getX() ) 
	    + (int)Math.abs( p1.getPosition().getY() - p2.getPosition().getY() ) ;
    }    
}
