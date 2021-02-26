import persistence.AddressBook;
import persistence.BuddyInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookActionListener implements ActionListener {
	private AddressBookJTextField text1;
	private AddressBookJTextField text2;
	private AddressBook addressBook;

	public AddressBookActionListener(AddressBook addressBook, AddressBookJTextField text1,
			AddressBookJTextField text2) {
		this.addressBook = addressBook;
		this.text1 = text1;
		this.text2 = text2;
	}

	public void actionPerformed(ActionEvent e) {
		addressBook.addBuddy(new BuddyInfo(text1.getText(), text2.getText()));
		System.out.println(addressBook);
	}
}
