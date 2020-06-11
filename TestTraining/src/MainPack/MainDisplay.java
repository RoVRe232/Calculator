package MainPack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MainDisplay extends JPanel {

	private JLabel displayText, prevText;
	private JFrame mainFrame;

	public MainDisplay(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		displayText = new JLabel();
		prevText = new JLabel();

		// init displayText variable
		displayText.setFont(new Font("TimesRoman", Font.BOLD, 35));
		displayText.setText(" ");
		displayText.setForeground(Color.WHITE);
		prevText.setFont(new Font("TimesRoman", Font.ITALIC, 32));
		prevText.setText(" ");
		prevText.setForeground(Color.LIGHT_GRAY);
		
		
		// initialize the main display looks
		Dimension preferredSize = new Dimension(mainFrame.getWidth()-(10/100)*mainFrame.getWidth(),
				mainFrame.getHeight()-(20/100)*mainFrame.getHeight());
		
		this.setSize(preferredSize);
		this.setMinimumSize(preferredSize);
		this.setMaximumSize(preferredSize);
		this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		this.setLayout(new BorderLayout());
		this.add(displayText, BorderLayout.SOUTH);
		this.add(prevText,BorderLayout.NORTH);
		
		this.setBackground(Color.black);
		
	}

	public MainDisplay(JLabel displayText, JFrame mainFrame) {
		super();
		this.displayText = displayText;
		this.mainFrame = mainFrame;
	}

	public void addString(String c) {
		displayText.setText(displayText.getText() + c);
	}

	public void removeChar() {
		displayText.setText(displayText.getText().substring(0, displayText.getText().length()-1));
	}
	public void clear()
	{
		prevText.setText(displayText.getText());
		displayText.setText(" ");
	}
	
	public String getEquation()
	{
		return displayText.getText();
	}
	
	public void setDisplayText(String text)
	{
		displayText.setText(text);
	}
	
	
}
