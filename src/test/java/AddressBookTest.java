import org.junit.Before;
import org.junit.Test;
import persistence.AddressBook;
import persistence.BuddyInfo;

import static org.junit.Assert.*;

public class AddressBookTest {
	private AddressBook addressBook;

	@Test
	public void addBuddy() throws Exception {
		addressBook.addBuddy(new BuddyInfo("xxx", "xxx-xxx-xxxx"));
		BuddyInfo buddyInfo = addressBook.getBuddy(0);
		assertEquals(buddyInfo.getName(), "xxx");
		assertEquals(buddyInfo.getPhoneNumber(), "xxx-xxx-xxxx");
		addressBook.removeBuddy(0);
	}

	@Before
	public void setUp() throws Exception {
		this.addressBook = new AddressBook();
	}
}