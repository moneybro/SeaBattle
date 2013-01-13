package september2012.FenskeSergey.lesson6.dz1.ver1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.*;

public class SeaBattleWindowsComponents implements MouseListener {
	
	public static JLabel xPixCoordinate = new JLabel("");
	public static JLabel yPixCoordinate = new JLabel("");
	public static JLabel xFieldCoordinate = new JLabel("");
	public static JLabel yFieldCoordinate = new JLabel("");
	public static JLabel alarmMessege = new JLabel("<html><font color = red></font>");
	static JTextArea myShootingLog = new JTextArea(24, 5);
	static JTextArea pcShootingLog = new JTextArea(24, 5);
	
	public SeaBattleWindowsComponents() {
		addMouseListener(this);
	}
	
	private static String statusString = "Привет"; 
	 
	
	private void addMouseListener(
			SeaBattleWindowsComponents seaBattleWindowsComponents) {
		// TODO Auto-generated method stub
		
	}
	

	public static void getStatusBar(JPanel southPanel) {
		
		southPanel.setLayout(new BorderLayout());
    	JPanel sPan = new JPanel();  
    	sPan.setLayout(new FlowLayout());
    	sPan.setBorder(new EtchedBorder());
    	JLabel xPixLabel = new JLabel("Xpix: ");
    	JLabel yPixLabel = new JLabel("Ypix: ");
    	JLabel xFieldLabel = new JLabel("Xf: ");
    	JLabel yFieldLabel = new JLabel("Yf: ");
    	
    	sPan.add(xPixLabel);
    	sPan.add(xPixCoordinate);
    	sPan.add(yPixLabel);
    	sPan.add(yPixCoordinate);
    	sPan.add(xFieldLabel);
    	sPan.add(xFieldCoordinate);
    	sPan.add(yFieldLabel);
    	sPan.add(yFieldCoordinate);
    	sPan.add(alarmMessege);
    	xPixCoordinate.setText("   ");
    	yPixCoordinate.setText("   ");
    	xFieldCoordinate.setText("   ");
    	yFieldCoordinate.setText("   ");
    	
    	JPanel wPan = new JPanel();
    	
    	wPan.add(new JScrollPane(myShootingLog));
    	wPan.add(new JScrollPane(pcShootingLog));
    	
    	southPanel.add(sPan,BorderLayout.SOUTH);
    	southPanel.add(wPan,BorderLayout.EAST);
    }
	
	public static void updateLog(String str, boolean enemyField) {
		if (enemyField) 
			pcShootingLog.append(str);
		else
			myShootingLog.append(str);
	}
	
	public static void setXCoordinate(int i, int i1) {
		xPixCoordinate.setText("" + i);
		xFieldCoordinate.setText("" + i1);
	}
	
	public static void setYCoordinate(int i, int i1) {
		yPixCoordinate.setText("" + i);
		yFieldCoordinate.setText("" + i1);
	}
	
	public static void showAlarmMessage(String str) {
		alarmMessege.setText("<html><font color = red>" + str + "</font>");
		
		ActionListener taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alarmMessege.setText("");
			}
        };
        
        javax.swing.Timer tmr = new javax.swing.Timer(2000, taskPerformer);
        tmr.setRepeats(false);
        tmr.start();
	}
	
	public static void clearLog() {
		myShootingLog.setText(null);
		pcShootingLog.setText(null);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		statusString = "Забежала";
		System.out.println("мышь забежала");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		statusString = "Выбежала";
		System.out.println("мышь выбежала");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
