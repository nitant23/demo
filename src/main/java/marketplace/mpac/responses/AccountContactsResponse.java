/**
 * 
 */
package marketplace.mpac.responses;

import java.io.Serializable;
import java.util.List;

import marketplace.mpac.entity.Address;

/**
 * @author Nitant
 *
 */
public class AccountContactsResponse implements Serializable {

	/** serialVersionUID **/
	private static final long serialVersionUID = 8968247114046453648L;

	private Long id;

	/* The Company Name */
	private String companyName;

	/* The Address */
	private Address address;

	/* The List of contact */
	private List<ContactResponse> contacts;

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
	public final List<ContactResponse> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public final void setContacts(List<ContactResponse> contacts) {
		this.contacts = contacts;
	}
}
