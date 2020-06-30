/**
 * 
 */
package marketplace.mpac.aspect;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.GenericValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import marketplace.mpac.entity.Address;
import marketplace.mpac.exception.CustomException;
import marketplace.mpac.requests.ContactRequest;

/**
 * @author Nitant
 *
 *         Validation for Contact information
 */
@Aspect
@Component
public class ContactAspect {

	@Before("execution(public * marketplace.mpac.controller.ContactController.getContactById(..))")
	public void getContactByIdValidate(JoinPoint joinPoint) throws Exception {

		Long id = ((Long) joinPoint.getArgs()[0]);
		if (id == null) {
			throw new CustomException("Invalid request.");
		}
	}

	@Before("execution(public * marketplace.mpac.controller.ContactController.create(..))")
	public void createValidate(JoinPoint joinPoint) throws Exception {

		ContactRequest createContactRequest = ((ContactRequest) joinPoint.getArgs()[0]);
		List<String> errors = this.validateContact(createContactRequest);

		if (!errors.isEmpty()) {
			throw new CustomException(errors.toString());
		}
	}

	@Before("execution(public * marketplace.mpac.controller.ContactController.update(..))")
	public void updateValidate(JoinPoint joinPoint) throws Exception {

		ContactRequest updateContactRequest = ((ContactRequest) joinPoint.getArgs()[0]);
		List<String> errors = this.validateContact(updateContactRequest);

		if (!errors.isEmpty()) {
			throw new CustomException(errors.toString());
		}
	}

	/* Validate contact information */
	private final List<String> validateContact(ContactRequest contact) {

		List<String> errors = new ArrayList<String>();

		if (contact != null) {
			if (!contact.isNewContact() && contact.getId() == null) {
				errors.add("Contact Id is required to update the existing contact information");
			}

			if (GenericValidator.isBlankOrNull(contact.getFirstName())) {
				errors.add("First name is required");
			}
			if (GenericValidator.isBlankOrNull(contact.getLastName())) {
				errors.add("Last name is required");
			}
			if (GenericValidator.isBlankOrNull(contact.getEmail())) {
				errors.add("Email is required");
			}

			Address address = contact.getAddress();

			if (address != null) {
				if (GenericValidator.isBlankOrNull(address.getAddress1())) {
					errors.add("Address line 1 is required");
				}

				if (GenericValidator.isBlankOrNull(address.getCity())) {
					errors.add("City is required");
				}

				if (GenericValidator.isBlankOrNull(address.getState())) {
					errors.add("State is required");
				}

				if (GenericValidator.isBlankOrNull(address.getCountry())) {
					errors.add("Country is required");
				}

				if (GenericValidator.isBlankOrNull(address.getPostalCode())) {
					errors.add("Zip or Postal code is required");
				}

			} else {
				errors.add("Address is required");
			}

//			// Validation for Contact update only
//			if (!contact.isNewContact() && contact.getAccountId() == null) {
//				errors.add("Associated Account is required to update the existing contact information");
//			}
		} else {
			errors.add("Invalid request");
		}

		return errors;
	}
}
