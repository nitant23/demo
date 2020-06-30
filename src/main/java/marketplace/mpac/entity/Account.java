/**
 * 
 */
package marketplace.mpac.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Nitant
 *
 *         Defines the Account information.
 */
@Entity
public class Account {

	/* The Account Id */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/* The Company Name */
	@Column(nullable = false, length = 255)
	private String companyName;

	/* The Address */
	private Address address;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Contact> contact;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the contact
	 */
	public List<Contact> getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}

}
