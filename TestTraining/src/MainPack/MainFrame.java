package MainPack;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public MainFrame() {
		super();
		this.setSize(400, 600);
		this.setTitle("Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.BLACK);

	}

	public static void main(String[] args) {
		
		//ArrayList<String> buttonsPanelControls = new ArrayList<>();
		//ArrayList<String> buttonsPanelControlType = new ArrayList<>();
		
		MainFrame mainFrame = new MainFrame();
		MainDisplay mainDisplay = new MainDisplay(mainFrame);
		mainFrame.add(mainDisplay, BorderLayout.NORTH);

		ButtonsPanel buttonsPanel = new ButtonsPanel(mainDisplay, mainFrame);
		GPButtonsPanel gpbuttonsPanel = new GPButtonsPanel(mainDisplay, mainFrame);

		buttonsPanel.setLayout(new GridLayout(0, 4));

		buttonsPanel.addControl("1", new JButton("1"), "inserter");
		buttonsPanel.addControl("2", new JButton("2"), "inserter");
		buttonsPanel.addControl("3", new JButton("3"), "inserter");
		buttonsPanel.addControl("+", new JButton("+"), "inserter");
		buttonsPanel.addControl("4", new JButton("4"), "inserter");
		buttonsPanel.addControl("5", new JButton("5"), "inserter");
		buttonsPanel.addControl("6", new JButton("6"), "inserter");
		buttonsPanel.addControl("-", new JButton("-"), "inserter");
		buttonsPanel.addControl("7", new JButton("7"), "inserter");
		buttonsPanel.addControl("8", new JButton("8"), "inserter");
		buttonsPanel.addControl("9", new JButton("9"), "inserter");
		buttonsPanel.addControl("*", new JButton("*"), "inserter");
		buttonsPanel.addControl("CE", new JButton("CE"), "changer");
		buttonsPanel.addControl("0", new JButton("0"), "inserter");
		buttonsPanel.addControl("=", new JButton("="), "changer");
		buttonsPanel.addControl("/", new JButton("/"), "inserter");
		buttonsPanel.addControl("<-", new JButton("<-"), "changer");
		buttonsPanel.addControl(".", new JButton("."), "inserter");
		buttonsPanel.addControl("sqrt", new JButton("sqrt"), "changer");
		buttonsPanel.addControl("^", new JButton("^"), "inserter");
		buttonsPanel.addControl("(", new JButton("("), "inserter");
		buttonsPanel.addControl(")", new JButton(")"), "inserter");
		mainFrame.add(buttonsPanel, BorderLayout.CENTER);
		
		gpbuttonsPanel.setLayout(new GridLayout(0,3));
		
		gpbuttonsPanel.addControl("x", new JButton("x"), "inserter");
		gpbuttonsPanel.addControl("y", new JButton("y"), "inserter");
		gpbuttonsPanel.addControl("GPlotter", new JButton("GPlotter"), "opener");
		
		mainFrame.add(gpbuttonsPanel, BorderLayout.SOUTH);
		
		
		mainFrame.setVisible(true);
		
	}

}
