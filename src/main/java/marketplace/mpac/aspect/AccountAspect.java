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
import marketplace.mpac.requests.AccountRequest;
import marketplace.mpac.requests.ContactRequest;

/**
 * @author Nitant
 *
 *         Validation for Contact information
 */
@Aspect
@Component
public class AccountAspect {

	@Before("execution(public * marketplace.mpac.controller.AccountController.getAccountById(..))")
	public void getAccountByIdValidate(JoinPoint joinPoint) throws Exception {

		Long id = ((Long) joinPoint.getArgs()[0]);
		if (id == null) {
			throw new CustomException("Invalid request.");
		}
	}

	@Before("execution(public * marketplace.mpac.controller.AccountController.create(..))")
	public void createValidate(JoinPoint joinPoint) throws Exception {

		AccountRequest createAccountRequest = ((AccountRequest) joinPoint.getArgs()[0]);
		List<String> errors = this.validateAccount(createAccountRequest);

		if (!errors.isEmpty()) {
			throw new CustomException(errors.toString());
		}
	}

	@Before("execution(public * marketplace.mpac.controller.AccountController.update(..))")
	public void updateValidate(JoinPoint joinPoint) throws Exception {

		AccountRequest updateAccountRequest = ((AccountRequest) joinPoint.getArgs()[0]);
		List<String> errors = this.validateAccount(updateAccountRequest);

		if (!errors.isEmpty()) {
			throw new CustomException(errors.toString());
		}
	}

	/* Validate Account information */
	private final List<String> validateAccount(AccountRequest account) {

		List<String> errors = new ArrayList<String>();

		if (account != null) {

			if (!account.isNewAccount() && account.getId() == null) {
				errors.add("Account Id is required to update the existing account information");
			}

			if (GenericValidator.isBlankOrNull(account.getCompanyName())) {
				errors.add("Company name is required");
			}

			List<ContactRequest> accountContacts = account.getContacts();

			if (accountContacts != null && !accountContacts.isEmpty()) {
				for (ContactRequest accountContact : accountContacts) {

					if (GenericValidator.isBlankOrNull(accountContact.getFirstName())) {
						errors.add("First name is required");
					}
					if (GenericValidator.isBlankOrNull(accountContact.getLastName())) {
						errors.add("Last name is required");
					}
					if (GenericValidator.isBlankOrNull(accountContact.getEmail())) {
						errors.add("Email is required");
					}

					Address accountContactAddress = accountContact.getAddress();
					if (accountContactAddress != null) {
						if (GenericValidator.isBlankOrNull(accountContactAddress.getAddress1())) {
							errors.add("Address line 1 is required");
						}

						if (GenericValidator.isBlankOrNull(accountContactAddress.getCity())) {
							errors.add("City is required");
						}

						if (GenericValidator.isBlankOrNull(accountContactAddress.getState())) {
							errors.add("State is required");
						}

						if (GenericValidator.isBlankOrNull(accountContactAddress.getCountry())) {
							errors.add("Country is required");
						}

						if (GenericValidator.isBlankOrNull(accountContactAddress.getPostalCode())) {
							errors.add("Zip or Postal code is required");
						}
					} else {
						errors.add("Contact address is required");
					}
				}
			} else if (account.isNewAccount()) {
				errors.add("Atleast one contact is required to create an account");
			}

			Address accountAddress = account.getAddress();
			if (accountAddress != null) {
				if (GenericValidator.isBlankOrNull(accountAddress.getAddress1())) {
					errors.add("Address line 1 is required");
				}

				if (GenericValidator.isBlankOrNull(accountAddress.getCity())) {
					errors.add("City is required");
				}

				if (GenericValidator.isBlankOrNull(accountAddress.getState())) {
					errors.add("State is required");
				}

				if (GenericValidator.isBlankOrNull(accountAddress.getCountry())) {
					errors.add("Country is required");
				}

				if (GenericValidator.isBlankOrNull(accountAddress.getPostalCode())) {
					errors.add("Zip or Postal code is required");
				}

			} else {
				errors.add("Account address is required");
			}

			// Validation for Account update only
			if (!account.isNewAccount() && account.getId() == null) {
				errors.add("Account Id is required to update the existing Account information");
			}
		} else {
			errors.add("Invalid request");
		}

		return errors;
	}
}
