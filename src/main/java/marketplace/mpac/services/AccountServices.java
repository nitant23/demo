package marketplace.mpac.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marketplace.mpac.entity.Account;
import marketplace.mpac.entity.Contact;
import marketplace.mpac.jpa.UpsertAccount;
import marketplace.mpac.requests.AccountRequest;
import marketplace.mpac.requests.ContactRequest;
import marketplace.mpac.responses.AccountContactsResponse;
import marketplace.mpac.responses.AccountResponse;
import marketplace.mpac.responses.ContactResponse;

@Service
public class AccountServices {

	@Autowired
	UpsertAccount upsertAccount;

	/* Save the new contact information */
	public void create(AccountRequest accountRequest) {

		Account account = new Account();
		account.setCompanyName(accountRequest.getCompanyName());
		account.setAddress(accountRequest.getAddress());

		account.setContact(this.buildContacts(account, accountRequest.getContacts()));
		upsertAccount.save(account);
	}

	/* Update the existing account information */
	public void update(AccountRequest accountRequest) {

		Account account = upsertAccount.findById(accountRequest.getId()).get();
		account.setId(accountRequest.getId());
		account.setCompanyName(accountRequest.getCompanyName());
		account.setAddress(accountRequest.getAddress());

		account.setContact(this.buildContacts(account, accountRequest.getContacts()));
		upsertAccount.save(account);
	}

	/*
	 * Gets the account information along with the associated contacts based on the
	 * Account Id
	 */
	public AccountContactsResponse getAccountWithContactsById(Long id) {

		Account account = upsertAccount.findById(id).get();
		AccountContactsResponse response = new AccountContactsResponse();

		response.setId(account.getId());
		response.setCompanyName(account.getCompanyName());
		response.setAddress(account.getAddress());

		List<ContactResponse> contacts = new ArrayList<>();
		List<Contact> accountContacts = account.getContact();

		for (Contact accountContact : accountContacts) {
			ContactResponse contact = new ContactResponse();
			contact.setAccountId(account.getId());
			contact.setFirstName(accountContact.getFirstName());
			contact.setLastName(accountContact.getLastName());
			contact.setEmail(accountContact.getEmail());
			contact.setId(accountContact.getId());
			contact.setAddress(accountContact.getAddress());
			contacts.add(contact);
		}

		response.setContacts(contacts);

		return response;
	}

	/*
	 * Gets the account information based on the Account Id
	 */
	public AccountResponse getAccountById(Long id) {

		Account account = upsertAccount.getOne(id);
		AccountResponse response = new AccountResponse();

		response.setId(account.getId());
		response.setCompanyName(account.getCompanyName());
		response.setAddress(account.getAddress());

		return response;
	}

	/**
	 * Build contacts list for persistence
	 * 
	 * @param account
	 * @param accountContacts
	 * @return
	 */
	private final List<Contact> buildContacts(Account account, List<ContactRequest> accountContacts) {

		List<Contact> contacts = new ArrayList<>();

		for (ContactRequest accountContact : accountContacts) {
			Contact contact = new Contact();
			contact.setFirstName(accountContact.getFirstName());
			contact.setLastName(accountContact.getLastName());
			contact.setEmail(accountContact.getEmail());
			contact.setAddress(accountContact.getAddress());

			Account contactAccount = new Account();
			contactAccount.setId(account.getId());
			contact.setAccount(account);
			contacts.add(contact);
		}

		return contacts;
	}
}