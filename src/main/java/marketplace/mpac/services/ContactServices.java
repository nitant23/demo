package marketplace.mpac.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marketplace.mpac.entity.Account;
import marketplace.mpac.entity.Contact;
import marketplace.mpac.jpa.UpsertContact;
import marketplace.mpac.requests.ContactRequest;
import marketplace.mpac.responses.ContactResponse;

@Service
public class ContactServices {

	@Autowired
	UpsertContact upsertContact;

	/* Save the new contact information */
	public void create(ContactRequest contactRequest) {

		Contact contact = new Contact();
		contact.setFirstName(contactRequest.getFirstName());
		contact.setLastName(contactRequest.getLastName());
		contact.setEmail(contactRequest.getEmail());
		contact.setAddress(contactRequest.getAddress());

		upsertContact.save(contact);
	}

	/* Update the existing contact information */
	public void update(ContactRequest contactRequest) {

		Contact contact = upsertContact.findById(contactRequest.getId()).get();
		contact.setFirstName(contactRequest.getFirstName());
		contact.setLastName(contactRequest.getLastName());
		contact.setEmail(contactRequest.getEmail());
		contact.setAddress(contactRequest.getAddress());

		if (!contactRequest.isNewContact() && contactRequest.getAccountId() != null) {
			Account account = new Account();
			account.setId(contactRequest.getAccountId());
			contact.setAccount(account);
		}

		upsertContact.save(contact);
	}

	/* Gets the contact information based on the Contact Id */
	public ContactResponse getContactById(Long id) {

		Contact contact = upsertContact.getOne(id);

		ContactResponse response = new ContactResponse();
		response.setId(contact.getId());
		response.setFirstName(contact.getFirstName());
		response.setLastName(contact.getLastName());
		response.setEmail(contact.getEmail());

		Account contactAccount = contact.getAccount();
		if (contactAccount != null) {
			response.setAccountId(contact.getAccount().getId());
		}

		response.setAddress(contact.getAddress());
		return response;
	}
}