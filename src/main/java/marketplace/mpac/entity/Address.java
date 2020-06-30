package marketplace.mpac.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Nitant
 *
 * Defines the Address information.
 */
@Embeddable
public class Address {

	/* The Address line 1 */
	@Column(nullable = false, length = 255)
	private String address1;
	
	/* The Address line 2 */
	@Column(nullable = true, length = 255)
	private String address2;
	
	/* The City */
	@Column(nullable = false, length = 40)
	private String city;
	
	/* The State */
	@Column(nullable = false, length = 80)
	private String state;
	
	/* The Postal Code */
	@Column(nullable = false, length = 20)
	private String postalCode;
	
	/* The Country */
	@Column(nullable = false, length = 100)
	private String country;

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
}
