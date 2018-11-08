import java.awt.*;


public class LShape extends AbstractPiece {

	/**
	 * An L-Shape piece in the Tetris Game.
	 *
	 * This piece is made up of 4 squares in the following configuration:
	 *
	 * Sq <br>
	 * Sq <br>
	 * Sq Sq <br>
	 *
	 * The game piece "floats above" the Grid. The (row, col) coordinates are the
	 * location of the middle Square on the side within the Grid
	 *
	 *
	 */

	/**
	 * Creates an L-Shape piece. See class description for actual location of r
	 * and c
	 *
	 * @param r row location for this piece
	 * @param c column location for this piece
	 * @param g the grid for this game piece
	 */
	public LShape(int r, int c, Grid g) {
		grid = g;
		square = new Square[PIECE_COUNT];
		ableToMove = true;

		// Create the squares
		square[0] = new Square(g, r - 1, c, Color.magenta, true);
		square[1] = new Square(g, r, c, Color.magenta, true);
		square[2] = new Square(g, r + 1, c, Color.magenta, true);
		square[3] = new Square(g, r + 1, c + 1, Color.magenta, true);
	}

	public void rotate() {

		Point[] tempPts = this.getLocations();
		int rp0,cp0, rp1, cp1, rp2, cp2, rp3, cp3;
		// box #1
		rp0 = (int)tempPts[0].getX();
		cp0 = (int)tempPts[0].getY();
		// box #2
		rp1 = (int)tempPts[1].getX();
		cp1 = (int)tempPts[1].getY();
		// box #3
		rp2 = (int)tempPts[2].getX();
		cp2 = (int)tempPts[2].getY();
		// box #4
		rp3 = (int)tempPts[3].getX();
		cp3 = (int)tempPts[3].getY();

		//CODE TO MODIFY//
		if(cp0==cp2&&cp2+1==cp3)
		{
			square[0].move(Direction.RIGHT);
			square[0].move(Direction.DOWN);
			square[2].move(Direction.LEFT);
			square[2].move(Direction.UP);
			square[3].move(Direction.LEFT);
			square[3].move(Direction.LEFT);
		}
		if (rp0 ==rp2&&rp1+1==rp3)
		{
			square[0].move(Direction.DOWN);
			square[0].move(Direction.LEFT);
			square[2].move(Direction.UP);
			square[2].move(Direction.RIGHT);
			square[3].move(Direction.UP);
			square[3].move(Direction.UP);
		}
		if(cp0==cp2&&cp2-1==cp3)
		{
			square[0].move(Direction.LEFT);
			square[0].move(Direction.UP);
			square[2].move(Direction.RIGHT);
			square[2].move(Direction.DOWN);
			square[3].move(Direction.RIGHT);
			square[3].move(Direction.RIGHT);
		}
		if(rp0 ==rp2&&rp1-1==rp3)
		{
			square[0].move(Direction.UP);
			square[0].move(Direction.RIGHT);
			square[2].move(Direction.DOWN);
			square[2].move(Direction.LEFT);
			square[3].move(Direction.DOWN);
			square[3].move(Direction.DOWN);
		}


	}
}

