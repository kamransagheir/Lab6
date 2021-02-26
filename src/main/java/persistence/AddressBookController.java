package persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {
	private AddressBookRepository addressBookRepo;

	@Autowired
	public AddressBookController(AddressBookRepository addressBookRepo) {
		this.addressBookRepo = addressBookRepo;
	}

	@RequestMapping(value = "/addressBook", method = RequestMethod.GET)
	public AddressBook getAddressBook(@RequestParam("id") Long id) {
		return addressBookRepo.findOne(id);
	}

	@RequestMapping("/addressBook")
	public AddressBook createAddressBook() {
		AddressBook addressBook = new AddressBook();
		addressBookRepo.save(addressBook);
		return addressBook;
	}

}
