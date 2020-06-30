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
public class AccountResponse implements Serializable {

	/** serialVersionUID **/
	private static final long serialVersionUID = 3122845536567195485L;

	private Long id;

	/* The Company Name */
	private String companyName;

	/* The Address */
	private Address address;

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
}
