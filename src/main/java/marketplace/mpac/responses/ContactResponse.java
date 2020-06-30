/**
 * 
 */
package marketplace.mpac.responses;

import java.io.Serializable;

import marketplace.mpac.entity.Address;

/**
 * @author Nitant
 *
 */
public class ContactResponse implements Serializable {

	/** serialVersionUID **/
	private static final long serialVersionUID = 2922460643392111153L;

	/* The Id */
	private Long id;

	/* The First Name */
	private String firstName;

	/* The Last Name */
	private String lastName;

	/* The Email Address */
	private String email;

	/* The Address */
	private Address address;

	/* The Account Id */
	private Long accountId;

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
	 * @return the firstName
	 */
	public final String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public final String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
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
	 * @return the accountId
	 */
	public final Long getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public final void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
}
