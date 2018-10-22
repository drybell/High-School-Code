// Authors: Marty Stepp, Stuart Reges, Amanda O'Neal
//
// Stone objects are displayed as S and always stay put.
// They always pick ROAR in a fight.
//
// 2/20/16 - Amanda O'Neal - Added @Override
//
import java.awt.*;

public class Stone extends Critter {
	/**
	* Returns a stone's attack
	*
	* @return a stone's attack
	*/
	@Override
	public Attack fight(String opponent) {
		return Attack.ROAR;    // good ol' ROAR... nothing beats that!
	}

	/**
	* Returns a stone's color
	*
	* @return the color of a stone
	*/
	@Override
	public Color getColor() {
		return Color.GRAY;     // stones are gray in color
	}

	/**
	* Returns a stone's String representation
	* for the CritterMain board.
	*
	* @return String version of the stone
	*/
	@Override
	public String toString() {
		return "S";            // the game displays a stone as an S
	}
}
