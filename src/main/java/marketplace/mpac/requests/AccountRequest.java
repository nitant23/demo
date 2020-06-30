/**
 * 
 */
package marketplace.mpac.requests;

import java.io.Serializable;
import java.util.List;

import marketplace.mpac.entity.Address;

/**
 * @author Nitant
 *
 */
public class AccountRequest implements Serializable {

	/** serialVersionUID **/
	private static final long serialVersionUID = 8397731281031206963L;

	private Long id;

	/* The Company Name */
	private String companyName;

	/* The Address */
	private Address address;

	/* The List of contact */
	private List<ContactRequest> contacts;

	/* The new account flag */
	private boolean newAccount;

	/**
	 * @return the id
	 */
	public final Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the companyName
	 */
	public final String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public final void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the address
	 */
	public final Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public final void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the contacts
	 */
	public final List<ContactRequest> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public final void setContacts(List<ContactRequest> contacts) {
		this.contacts = contacts;
	}

	/**
	 * @return the newAccount
	 */
	public final boolean isNewAccount() {
		return newAccount;
	}

	/**
	 * @param newAccount the newAccount to set
	 */
	public final void setNewAccount(boolean newAccount) {
		this.newAccount = newAccount;
	}
}
