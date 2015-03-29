package ma.car.exercise.model;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import ma.car.exercise.util.Util;

/** Author: Nahid Mahbub<br>
 * Date: 04-OCT-2014 */

public class PlayingArea {
    public static int[] dx = new int[]{ -1, 1,  0, 0}; //moves are Left=0, Right=1, Up=2, Down=3  
    public static int[] dy = new int[]{  0, 0, -1, 1};

    private Cell dim;
    private int time; // current playing time
    private List<Player> players;

    public PlayingArea(int dimx, int dimy) {
	this.time = 1;
	this.dim = new Cell(dimx, dimy);
	players = new ArrayList();
	for(int i=1; i<=10 ; i++) {
	    Player pl = new Player(i);
	    pl.setPosition( this.getRandomPosition() );
	    players.add( pl );
	}
    }

    public boolean varifyMove(Player pl, int move) {
	int nextx = pl.getPosition().getX() + dx[move];
	int nexty = pl.getPosition().getY() + dy[move];
	return (nextx >= 1 && nextx <= dim.getX() ) && (nexty >= 1 && nexty <= dim.getY() );
    }

    public Cell getRandomPosition() {
	return new Cell( Util.getRandomNumber(1,dim.getX()), Util.getRandomNumber(1,dim.getY()) );
    }

    public static boolean isInSafeDistance(Player p1, Player p2) {
	int distance = Util.getDistance(p1, p2);
	return distance > 2;
    }

    public int getTime() {
	return this.time;
    }

    public void setTime(int time) {
	this.time = time;
    }

    public List<Player> getPlayers() {
	return this.players;
    }

    public void setPlayers(List<Player> players) {
	this.players = players;
    }
}
