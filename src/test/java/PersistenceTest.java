import org.junit.Test;
import persistence.AddressBook;
import persistence.BuddyInfo;

import static org.junit.Assert.*;

import javax.persistence.*;

import java.util.List;

public class PersistenceTest {
	@Test
	public void test() {
		BuddyInfo buddyInfo = new BuddyInfo();
		buddyInfo.setName("xxx");
		buddyInfo.setPhoneNumber("xxx-xxx-xxxx");

		BuddyInfo buddyInfo2 = new BuddyInfo();
		buddyInfo2.setName("xxxx");
		buddyInfo2.setPhoneNumber("xxx-xxx-xxxx");

		AddressBook addressBook = new AddressBook();
		addressBook.addBuddy(buddyInfo);
		addressBook.addBuddy(buddyInfo2);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();
		entityManager.persist(buddyInfo);
		entityManager.persist(buddyInfo2);
		entityManager.persist(addressBook);
		transaction.commit();

		Query q = entityManager.createQuery("SELECT buddyInfo FROM BuddyInfo buddyInfo");
		Query q2 = entityManager.createQuery("SELECT addressBook FROM AddressBook addressBook");

		List<BuddyInfo> results = q.getResultList();
		List<AddressBook> results2 = q2.getResultList();

		System.out.println("Products\n----------------");
		for (BuddyInfo buddyInfo1 : results) {
			System.out.println(buddyInfo1);
		}
		assertEquals(results2.get(0), addressBook);
		for (AddressBook addressBook1 : results2) {
			System.out.println(addressBook1);
		}
		entityManager.close();

		emf.close();

	}
}
