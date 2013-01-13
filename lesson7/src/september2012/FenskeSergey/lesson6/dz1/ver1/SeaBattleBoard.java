package september2012.FenskeSergey.lesson6.dz1.ver1;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.*;


import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;


public class SeaBattleBoard extends JPanel implements MouseListener, MouseMotionListener {
	private JFrame frame;
    public static final int PIXEL_MULTIPLICATOR = 30;
    public static final int X_PIXEL_SHIFT = 415;
    public static final int X_SHIFT = 55;
    public static final int Y_SHIFT = 53;

    public static final int FIELD_SIZE = 10;

    public Cell[][] internalUserFieldMap;
    public Cell[][] internalComputerFieldMap;
    public boolean enemyField = true;
    public boolean isGameOver = false;
    
    private Image fieldImage;
    private Image shipImage;
    private Image missImage;
    private Image killImage;
    private Image fireImage;
    private Image cellOfFieldImage;
    
    Cell[][] userFieldMap;
    Cell[][] computerFieldMap;
    private Graphics2D g2d;
  
    public SeaBattleBoard(JFrame frame) {
    	this.frame = frame;
    	
    	ImageIcon fieldIcon = new ImageIcon(this.getClass().getResource("/september2012/FenskeSergey/lesson6/dz1/ver1/images/sea_battle_2fields.png"));
        fieldImage = fieldIcon.getImage();

        ImageIcon shipIcon = new ImageIcon(this.getClass().getResource("/september2012/FenskeSergey/lesson6/dz1/ver1/images/ship.png"));
        shipImage = shipIcon.getImage();

        ImageIcon missIcon = new ImageIcon(this.getClass().getResource("/september2012/FenskeSergey/lesson6/dz1/ver1/images/miss.png"));
        missImage = missIcon.getImage();

        ImageIcon killIcon = new ImageIcon(this.getClass().getResource("/september2012/FenskeSergey/lesson6/dz1/ver1/images/kill.png"));
        killImage = killIcon.getImage();

        ImageIcon fireIcon = new ImageIcon(this.getClass().getResource("/september2012/FenskeSergey/lesson6/dz1/ver1/images/fire.png"));
        fireImage = fireIcon.getImage();
        
        ImageIcon cellOfFieldIcon = new ImageIcon(this.getClass().getResource("/september2012/FenskeSergey/lesson6/dz1/ver1/images/cellOfField.png"));
        cellOfFieldImage = cellOfFieldIcon.getImage();
        
        addMouseListener(this);
        addMouseMotionListener(this);
        generateFileds();
    }
    
    public void generateFileds() {
    	Field userFieldMap2 = new Field();
    	userFieldMap2.regenerateForGame();
    	Field computerFieldMap2 = new Field();
        computerFieldMap2.regenerateForGame();
        userFieldMap = userFieldMap2.getFieldMap(); 
        computerFieldMap = computerFieldMap2.getFieldMap();
	}

    @Override
    public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            this.g2d = (Graphics2D)graphics;
            g2d.drawString("A        Б       В       Г       Д       Е        Ж       З        И        К", 65, 50);
        	g2d.drawString("A        Б       В       Г       Д       Е        Ж       З        И        К", 485, 50);
        	for (int i=1; i < 11 ; i++) {
        		g2d.drawString(String.valueOf(i), 40, (45 + i * 30));
        		g2d.drawString(String.valueOf(i), 455, (45 + i * 30));
        	}
        	printBattleField();
    }
    
    public void printBattleField() {
    	repaint();
    	if(g2d != null) {
    	for(int j=0; j < Field.FIELD_COL_SIZE; j++) {
            for(int i=0; i < Field.FIELD_ROW_SIZE; i++) {
            	
            	Cell cell = userFieldMap[j][i];
            	Cell cell2 = computerFieldMap[j][i];
            	
            	if(cell.isShip()) {
            		if(cell.isFired()) {
            			if(cell.getShipType().isKilled()) {
            				g2d.drawImage(killImage, convertXtoPixels(j, false), convertYtoPixels(i, false), null);
            			} else {
            				g2d.drawImage(fireImage, convertXtoPixels(j, false), convertYtoPixels(i, false), null);
            			}
            		} else {
            			g2d.drawImage(shipImage, convertXtoPixels(j, false), convertYtoPixels(i, false), null);
            		}
                } else if(cell.isFired()) {
                	g2d.drawImage(cellOfFieldImage, convertXtoPixels(j, false), convertYtoPixels(i, false), null);
                	g2d.drawImage(missImage, convertXtoPixels(j, false) + 5, convertYtoPixels(i, false) + 5, null);
                } else {
                	g2d.drawImage(cellOfFieldImage, convertXtoPixels(j, false), convertYtoPixels(i, false), null);
                }
            	
            	
            	if(cell2.isShip()) {
            		if(cell2.isFired()) {
            			if(cell2.getShipType().isKilled()) {
            				g2d.drawImage(killImage, convertXtoPixels(j, true), convertYtoPixels(i, true), null);
            			} else {
            				g2d.drawImage(fireImage, convertXtoPixels(j, true), convertYtoPixels(i, true), null);
            			}
            		} else {
            			g2d.drawImage(shipImage, convertXtoPixels(j, true), convertYtoPixels(i, true), null);
            			//g2d.drawImage(cellOfFieldImage, convertXtoPixels(j, true), convertYtoPixels(i, true), null);
            		}
                } else if(cell2.isFired()) {
                	g2d.drawImage(cellOfFieldImage, convertXtoPixels(j, true), convertYtoPixels(i, true), null);
                	g2d.drawImage(missImage, convertXtoPixels(j, true) + 5, convertYtoPixels(i, true) + 5, null);
                } else {
                	g2d.drawImage(cellOfFieldImage, convertXtoPixels(j, true), convertYtoPixels(i, true), null);
                }
            }
        }
    	}
    }
    
    public int convertXtoPixels(int x, boolean isComputerField) {
        if(isComputerField) {
            x = x*PIXEL_MULTIPLICATOR+X_PIXEL_SHIFT;
        } else {
            x = x*PIXEL_MULTIPLICATOR;
        }

        x += X_SHIFT;

        return x;
    }

    public int convertYtoPixels(int y, boolean isComputerField) {
        if(isComputerField) {
            y = y*PIXEL_MULTIPLICATOR;
        } else {
            y = y*PIXEL_MULTIPLICATOR;
        }

        y += Y_SHIFT;

        return y;
    }

    public boolean isPixelsFromComputerField(int pixels) {
        int x = (pixels - X_SHIFT)/PIXEL_MULTIPLICATOR;

        boolean isComputerField = false;
        if(x > FIELD_SIZE) {
            isComputerField = true;
        }

        return isComputerField;
    }

    public int convertPixelsToX(int pixels) {
        int x = (pixels - X_SHIFT)/PIXEL_MULTIPLICATOR;

        if(x > FIELD_SIZE) {
            x -= 14;
        }

        return x;
    }
    
    public int convertPixelsToY(int pixels) {
        return  (pixels - Y_SHIFT)/PIXEL_MULTIPLICATOR;
    }
    
    public void shooting (int coordinatePixX, int coordinatePixY) {
    	int coordinateFieldX = convertPixelsToX(coordinatePixX);
    	int coordinateFieldY = convertPixelsToY(coordinatePixY);
    	
    	Cell variableCell = null;
    	Ship variableShip;
    	
    	if(isPixelsFromComputerField(coordinatePixX)) {
    		variableCell = computerFieldMap[coordinateFieldX][coordinateFieldY];
    		enemyField = true;
    	} else {
    		variableCell = userFieldMap[coordinateFieldX][coordinateFieldY];
    		enemyField = false;
    	}
    	
    	variableShip = variableCell.getShipType();
    	
    		if (coordinateFieldX >= 0 && coordinateFieldX < 10 &&
    				coordinateFieldY >= 0 && coordinateFieldY < 10) {
    			if(variableCell.isShip()) {
    				g2d.drawImage(fireImage, coordinatePixX, coordinatePixY, null);
    						SeaBattleWindowsComponents.updateLog("x=" + coordinateFieldX +
    	    	    				" " + "y=" + coordinateFieldY + " " + "\n", enemyField);
    	    				variableCell.setWasFired();
    	                	checkTheShipIsLife(coordinatePixX, coordinatePixY, variableShip);
    	    	} else {
    				SeaBattleWindowsComponents.updateLog("x=" + coordinateFieldX +
    	    				" " + "y=" + coordinateFieldY + " " + "\n", enemyField);
    				g2d.drawImage(missImage, coordinatePixX, coordinatePixY, null);
    			}
    			variableCell.setWasFired();
    		}
    		repaint();
    }
    
    private void checkTheShipIsLife(int x, int y, Ship ship) {
    	
    	
    	int flag = 0;
    	int counterOfShipBoards;
    	Cell[][] variableCell;
    	
    	if(isPixelsFromComputerField(x)) {
    		variableCell = computerFieldMap;
    		enemyField = true;
    	} else {
    		variableCell = userFieldMap;
    		enemyField = false;
    	}
    	
    	counterOfShipBoards = ship.getShipSize();
    	
    	for(int i=0; i < Field.FIELD_COL_SIZE; i++) {
            for(int j=0; j < Field.FIELD_ROW_SIZE; j++) {
            	if (variableCell[i][j].isShip()) {
            		if (ship.equals(variableCell[i][j].getShipType())) {
            			if(variableCell[i][j].isFired()) {
            				counterOfShipBoards--;
            				if(counterOfShipBoards == 0) {
            					SeaBattleWindowsComponents.updateLog("убит\n", enemyField);
            					ship.setIsKilled();
            					setFiredCellsAroundKiledShip(ship, enemyField);
            					printBattleField();
            					GameOver();
            				} 
            				} else {
        						if (flag < 1 && !ship.isKilled())
        						SeaBattleWindowsComponents.updateLog("ранен\n", enemyField);
        					flag++;
            			}
            		}
				}
            }
    	}
    }
    
    private void setFiredCellsAroundKiledShip (Ship ship, boolean enemyField) {
    	
    	Cell[][] variableCell;
    	if(enemyField) {
    		variableCell = computerFieldMap;
    	} else {
    		variableCell = userFieldMap;
    	}
    	
    	int x = ship.getX();
    	int y = ship.getY();
    	int rotation = ship.getRotation();
    	int boatSize = ship.getShipSize();
    	//System.out.print(ship + " " + x + "," + y + " " + "rot " + rotation + "  size " + boatSize);
    	
    	int cx,cy; // координаты обследуемого пространства
		int i,j;   // переменные размера обследыемого пространства
		
		// положения корабля всего 2, поэтому проверяем одно условие, по else присваиваются 
		// другие значения
		if (rotation == 1) {
			i = boatSize;
			j = 1;
		} else {
			i = 1;
			j = boatSize;
		}
		//System.out.println(" i=" + i + " j=" + j);
		for(cx = -1; cx <= i; cx++)
			for(cy = -1; cy <= j;cy++) {
				if ((x+cx)>=0 & (x+cx)<=9 & (y+cy)>=0 & (y+cy)<=9) 
						variableCell[x + cx][y + cy].setWasFired();
			}
    }
    
    private void GameOver() {
    	int allShipComputerBoardCounter = 20;
    	int allShipUserBoardCounter = 20;
    	
    	for(int i=0; i < Field.FIELD_COL_SIZE; i++) {
            for(int j=0; j < Field.FIELD_ROW_SIZE; j++) {
            	Cell cell = userFieldMap[j][i];
            	Cell cell2 = computerFieldMap[j][i];
            	if (cell2.isShip()) {
            		if(cell2.isFired()) {
            			allShipComputerBoardCounter--;
            			if(allShipComputerBoardCounter == 0) {
            				isGameOver = true;
            				Object[] options = {"Да", "Нет"};
            	                int result = JOptionPane.showOptionDialog(frame, "Вы выиграли!!!\nХотите сыграть еще раз ?", "Игра окончена",
            	                		JOptionPane.YES_NO_CANCEL_OPTION,
            	                        JOptionPane.QUESTION_MESSAGE,
            	                        null,
            	                        options,
            	                        options[1]);

            	                if(result == 0) {
            	                	isGameOver = false;
            	                	generateFileds();
            	                	printBattleField();
            	                	SeaBattleWindowsComponents.clearLog();
            	                }
            	                
            	                if(result == 1) {
            	                	System.exit(0);
            	                }
            	        }
            		}
            	}
            	if (cell.isShip()) {
            		if(cell.isFired()) {
            			allShipUserBoardCounter--;
            			if(allShipUserBoardCounter == 0) {
            				Object[] options = {"Да", "Нет"};
        	                int result = JOptionPane.showOptionDialog(frame, "Я выиграл!!!\nХотите сыграть еще раз ?", "Игра окончена",
        	                		JOptionPane.YES_NO_CANCEL_OPTION,
        	                        JOptionPane.QUESTION_MESSAGE,
        	                        null,
        	                        options,
        	                        options[1]);

        	                if(result == 0) {
        	                	generateFileds();
        	                	printBattleField();
        	                	SeaBattleWindowsComponents.clearLog();
        	                }
        	                
        	                if(result == 1) {
        	                	System.exit(0);
        	                }
            				
            				return;
            			}
            		}
            	}
            }
    	}
    }
    
    private static int getRandomCoordinate() {
 		Random random = new Random();
 		return random.nextInt(10);
 	}
    
    private void computerShoot() {
    	if (!isGameOver) {
	    	int x = getRandomCoordinate();
	    	int y = getRandomCoordinate();
	    	Cell cell = userFieldMap[x][y];
	    	if(!cell.isFired()) {
	    	shooting (convertXtoPixels(x, false),convertYtoPixels(y, false));
	    	} else {
	    		computerShoot();
	    	}
    	}
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
    	
    	if(isPixelsFromComputerField(event.getX())) {
    		if (convertPixelsToX(event.getX()) >= 0 && convertPixelsToX(event.getX()) < 10 &&
    			convertPixelsToY(event.getY()) >= 0 && convertPixelsToY(event.getY()) < 10) {
    			Cell cell2 = computerFieldMap[convertPixelsToX(event.getX())][convertPixelsToY(event.getY())];
    				if(!cell2.isFired()) {
    					shooting(event.getX(),event.getY());
    					computerShoot();
    				}
    		} else {
    			SeaBattleWindowsComponents.showAlarmMessage("Мимо поля, попробуй еще раз");
    			//System.out.println("Мимо поля, попробуй еще раз");
    		}
    	} else {
    		SeaBattleWindowsComponents.showAlarmMessage("Мимо поля, попробуй еще раз");
			//System.out.println("Мимо поля, попробуй еще раз");
		}
    }

    public void mousePressed(MouseEvent event) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    	//System.out.println("мышь забежала");
    }

    @Override
    public void mouseExited(MouseEvent e) {
    	//System.out.println("мышь выбежала");
    }


	public void setJMenuBar(JMenuBar menubar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		SeaBattleWindowsComponents.setXCoordinate(e.getX(),convertPixelsToX(e.getX()));
		SeaBattleWindowsComponents.setYCoordinate(e.getY(),convertPixelsToY(e.getY()));
	}
}
