package ma.car.exercise.model;

import ma.car.exercise.util.Util;

/** Author: Nahid Mahbub<br>
 * Date: 04-OCT-2014 */

public class Player {
    private Cell position;
    private int number; // player number
    private int offFrom; // time, from when the player is off 
    private int numOfYellowCards;

    public Player(int number) {
	//this.position = PlayingArea.getRandomPosition();
	this.number = number;
    }

    public void makeAMove(int move) {
	this.position.setX( this.position.getX() + PlayingArea.dx[move] );
	this.position.setY( this.position.getY() + PlayingArea.dy[move] );
    }

    public int getNumber() {
	return this.number;
    }

    public int getNumOfYellowCards() {
	return this.numOfYellowCards;
    }

    public void setNumOfYellowCards(int numOfYellowCards) {
	this.numOfYellowCards = numOfYellowCards;
    }

    public Cell getPosition() {
	return this.position;
    }

    public void setPosition(Cell position) {
	this.position = position;
    }

    public int getOffFrom() {
	return this.offFrom;
    }

    public void setOffFrom(int offFrom) {
	this.offFrom = offFrom;
    }

    public String toString() {
	return "Player " + this.number;
    }
}
