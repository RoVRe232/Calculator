package MainPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {
	protected MainDisplay mainDisplay;
	protected MainFrame mainFrame;
	private HashMap<String, JButton> buttonsMap;

	public ButtonsPanel(MainDisplay mainDisplay, MainFrame mainFrame) {
		super();
		this.mainDisplay = mainDisplay;
		this.mainFrame = mainFrame;
		buttonsMap = new HashMap<String, JButton>();
	}

	public void addControl(String cmd, JButton button, String listenerType) {

		Font font = new Font("Arial", Font.BOLD, 26);
		button.setFont(font);
		button.setForeground(Color.red);
		button.setFocusPainted(false);
		button.setBackground(Color.BLACK);
		this.add(button);
		buttonsMap.put(cmd, button);

		if (listenerType == "inserter")
			button.addActionListener(new InserterActionListener());
		else if (listenerType == "changer")
			button.addActionListener(new ChangeActionListener());
		else if(listenerType == "opener")
			button.addActionListener(new OpenActionListener());
		else {
			System.out.println("Wrong listenerType, setting to inserter by default");
			button.addActionListener(new InserterActionListener());
		}
	}

	class InserterActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mainDisplay.addString(e.getActionCommand());
		}

	}

	class ChangeActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "<-")
				mainDisplay.removeChar();
			if (e.getActionCommand() == "CE")
				mainDisplay.clear();
			if (e.getActionCommand() == "=") {
				double rez = Calculator.getInstance().calculate(mainDisplay.getEquation());
				mainDisplay.clear();
				mainDisplay.setDisplayText(String.valueOf(rez));
			}
			if (e.getActionCommand() == "sqrt") {
				double rez = Math.sqrt(Double.valueOf(mainDisplay.getEquation()));
				mainDisplay.clear();
				mainDisplay.setDisplayText(String.valueOf(rez));
			}

		}
	}
	
	class OpenActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand() == "GPlotter")
			{
				GraphicPlotter gp = new GraphicPlotter();
				mainDisplay.add(gp);
				//gp.setVisible(true);
			}
			
		}
		
	}
	
	

}
