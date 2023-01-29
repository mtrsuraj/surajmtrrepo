import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class ChessBoard extends Frame implements WindowListener, ActionListener {
	private Button buttons[] = new Button[64];
	private ChessBoardRenderer renderer = new ChessBoardRenderer();
	private GameStrategy gameStrategy = new GameStrategy();
	private MessageDialog dialog = new MessageDialog(this);
	private int numQueens = 0;
	
	public ChessBoard() {
		setLayout(new GridLayout(8,8));
		
		for(int i=0;i<64;++i) {
			buttons[i] = new Button();
			buttons[i].addActionListener(this);
			
			boolean flag = renderer.isBlackSquare(i);
			
			if(flag)
				buttons[i].setBackground(Color.BLACK);
			
			add(buttons[i]);
		}		
		
		setResizable(false);
		
		addWindowListener(this);
	}

	@Override
	public void windowActivated(WindowEvent arg0) { 	}

	@Override
	public void windowClosed(WindowEvent arg0) {	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {	}

	@Override
	public void windowIconified(WindowEvent arg0) { 	}

	@Override
	public void windowOpened(WindowEvent arg0) {	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Button clickedButton = (Button) event.getSource();
		
		int i = 0;
		for(;i<64;++i) {
			if(clickedButton == buttons[i])
				break;
		}
		
		try {
			boolean flag = gameStrategy.isValidPosition(i);
			
			if(flag) {
				clickedButton.setForeground(Color.RED);
				setFont(new Font("Dialog", Font.PLAIN, 27));
				clickedButton.setLabel("\\^^/");
				++numQueens;
				
				if(numQueens == 8) {
					dialog.setMessage(" Great Stuff, we have a winner!");
					dialog.setResizable(false);
					dialog.setVisible(true);
				}
				else {
					int queensRemaining = 8 - numQueens;
					if(numQueens > 5) {
						dialog.setMessage(" You are almost there. Just " + queensRemaining + " more to go");
						dialog.setResizable(false);
						dialog.setVisible(true);
					}
				}
			}
			else {
				dialog.setMessage(" Invalid Move");
				dialog.setResizable(false);
				dialog.setVisible(true);
			}
		} catch (GameOverException e) {
			dialog.setMessage("Game Over dude, You have already won!");
			dialog.setResizable(false);
			dialog.setVisible(true);
		}
	}
}






















