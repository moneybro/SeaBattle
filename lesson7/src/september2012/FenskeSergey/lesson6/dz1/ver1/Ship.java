package september2012.FenskeSergey.lesson6.dz1.ver1;

/**
 * Прототип корабля
 */
public class Ship {
    public static final int PATROL_BOAT_SIZE = 1;
    public static final int CRUISER_SIZE = 2;
    public static final int DESTROYER_SIZE = 3;
    public static final int BATTLESHIP_SIZE = 4;
    
    public boolean isKilled = false;

    protected Cell[] cells;
    
    public int getShipSize() {
		return 0;
	}
    
    public boolean setIsKilled() {
    	return isKilled = true;
    }
    
    public boolean isKilled() {
    	return isKilled;
    }
    
    }
