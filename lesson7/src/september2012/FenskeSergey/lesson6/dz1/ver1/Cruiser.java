package september2012.FenskeSergey.lesson6.dz1.ver1;

/**
 * Двухпалубный корабль
 */
public class Cruiser extends Ship {

    Cruiser(int x1, int y1, int x2, int y2) {
        cells = new Cell[CRUISER_SIZE];
        cells[0] = new Cell(x1, y1, this);
        cells[1] = new Cell(x2, y2, this);
    }
    
    public int getShipSize() {
		return 2;
	}
    
}
