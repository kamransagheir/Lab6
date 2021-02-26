import javax.swing.*;
import java.awt.event.ActionListener;

public class AddressBookJButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActionListener actionListener;

	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	public void init() {
		this.addActionListener(actionListener);
		this.setText("Add Buddy");
	}
}
