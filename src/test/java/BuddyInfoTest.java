import org.junit.Before;
import org.junit.Test;
import persistence.BuddyInfo;

import static org.junit.Assert.*;

public class BuddyInfoTest {
	private BuddyInfo buddyInfo;

	@Before
	public void setUp() throws Exception {
		this.buddyInfo = new BuddyInfo("xxx", "xxx-xxx-xxxx");
	}

	@Test
	public void getPhoneNumber() throws Exception {
		assertEquals(buddyInfo.getPhoneNumber(), "xxx-xxx-xxxx");
	}

	@Test
	public void getName() throws Exception {
		assertEquals(buddyInfo.getName(), "xxx");
	}

	@Test
	public void setPhoneNumber() throws Exception {
		buddyInfo.setPhoneNumber("xxx-xxx-xxxx");
		assertEquals(buddyInfo.getPhoneNumber(), "xxx-xxx-xxxx");
	}

	@Test
	public void setName() throws Exception {
		buddyInfo.setName("xxx");
		assertEquals(buddyInfo.getName(), "xxx");
	}

}