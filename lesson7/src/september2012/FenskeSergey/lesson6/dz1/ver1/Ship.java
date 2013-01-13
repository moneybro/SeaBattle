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
    public int x,y,rotation;

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
    
    public void setshipPlacement(int x, int y, int rotation) {
    	this.x = x;
    	this.y = y;
    	this.rotation = rotation;
    	//System.out.println(x + "," + y + " " + "rot " + rotation + "  size " + getShipSize());
    }
    
    public int getX() {
    	return x;
    }
    public int getY() {
    	return y;
    }
    
    public int getRotation() {
    	return rotation;
    }
    
    }
