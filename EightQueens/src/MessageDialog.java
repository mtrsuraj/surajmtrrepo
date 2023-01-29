import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MessageDialog extends Dialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label lblMessage;

	public MessageDialog(Frame parent) {
		super(parent);
		initComponents();
	}
	public MessageDialog(Frame parent,boolean modal) {
		super(parent,modal);
		initComponents();
	}
	public void setMessage(String message) {
		lblMessage.setText(message);
	}
	private void initComponents() {
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setBackground(Color.white);
		setForeground(Color.black);
		setSize(295, 111);
		setTitle("User Notification");
		setLocation(50,50);
		
		add(getLblMessage());
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent event) {
				setVisible(false);
				dispose();
			}
		});
	}
	private Label getLblMessage() {
		if (lblMessage == null) {
			lblMessage = new Label();
		}
		return lblMessage;
	}
}