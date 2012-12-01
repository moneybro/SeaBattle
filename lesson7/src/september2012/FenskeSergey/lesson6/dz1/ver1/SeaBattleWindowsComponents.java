package september2012.FenskeSergey.lesson6.dz1.ver1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.*;

public class SeaBattleWindowsComponents implements MouseListener {
	
	public SeaBattleWindowsComponents() {
		addMouseListener(this);
	}
	
	private static String statusString = "Привет"; 
	static JPanel jp_status = new JPanel(); 
	
	private void addMouseListener(
			SeaBattleWindowsComponents seaBattleWindowsComponents) {
		// TODO Auto-generated method stub
		
	}

	public static void getStatusBar(SeaBattleBoard jframe) {
		
		jp_status.setLayout(new BorderLayout());
		JLabel statusLabel = new JLabel(statusString);
		jp_status.add(statusLabel, BorderLayout.SOUTH);
		//jp_status.setBorder(new BevelBorder(BevelBorder.LOWERED)); // рисует рамку вокруг панели
		
		jframe.add(jp_status,BorderLayout.WEST);
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
