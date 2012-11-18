package september2012.FenskeSergey.lesson6.dz1.ver1;

/**
 * Однопалубный корабль
 */
public class PatrolBoat extends Ship {

    PatrolBoat(int x, int y) {
        cells = new Cell[PATROL_BOAT_SIZE];
        cells[0] = new Cell(x, y, this);
    }
    
    public int getShipSize() {
		return 1;
	}
    
    public boolean setIsKilled() {
    	return this.isKilled = true;
    }
    
    public boolean isKilled() {
    	return isKilled;
    }
}
