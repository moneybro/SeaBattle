package september2012.FenskeSergey.lesson6.dz1.ver1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.*;

public class SeaBattle extends JFrame {

    private SeaBattleBoard board;

    public SeaBattle() {
        board = new SeaBattleBoard(this);
        add(board);
        setTitle("SeaBattle");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(850, 450);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private void drawGameField() {
        board.printBattleField();
    }
    
    private void addMenuBar() {
    	
    	board.setBackground(java.awt.Color.WHITE);
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("Файл");
        JMenu menuHelp = new JMenu("Справка");
        JMenuItem menuItem = new JMenuItem("");
        menuFile.setMnemonic(KeyEvent.VK_F);

        JMenuItem eMenuFileItemExit = new JMenuItem("Выход");
        eMenuFileItemExit.setMnemonic(KeyEvent.VK_C);
        eMenuFileItemExit.setToolTipText("Выход из приложения");
        eMenuFileItemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
      
        JMenuItem eMenuFileItemRestartGame = new JMenuItem("Новая игра");
        eMenuFileItemRestartGame.setMnemonic(KeyEvent.VK_C);
        eMenuFileItemRestartGame.setToolTipText("Перезапуск игры");
        eMenuFileItemRestartGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	board.generateFileds();
            	drawGameField();
            }

        });
        
        JMenuItem eMenuHelpItemAbout = new JMenuItem("О программе");
        eMenuHelpItemAbout.setMnemonic(KeyEvent.VK_C);
        eMenuHelpItemAbout.setToolTipText("О программе");
        eMenuHelpItemAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                final AboutProgrammWindow about = new AboutProgrammWindow();
                about.createAndShowGUI();
            }
        });
        
        menuFile.add(eMenuFileItemRestartGame);
        menuFile.add(eMenuFileItemExit);
        menuHelp.add(eMenuHelpItemAbout);
        
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        
        setContentPane(board);
        setJMenuBar(menuBar);
        setVisible(true);
    }

    public static void main(String[] args) {
    	
	    SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SeaBattle seaBattle = new SeaBattle();
                seaBattle.addMenuBar();
                seaBattle.drawGameField();
            }
        });
    }    
}
