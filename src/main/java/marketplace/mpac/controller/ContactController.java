package marketplace.mpac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import marketplace.mpac.requests.ContactRequest;
import marketplace.mpac.responses.ContactResponse;
import marketplace.mpac.services.ContactServices;

@Controller
@RequestMapping(value = "/contact")
public class ContactController {

	@Autowired
	ContactServices contactServices;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getContactById(@PathVariable("id") Long id) {

		ContactResponse contact = contactServices.getContactById(id);
		return new ResponseEntity<>(contact, HttpStatus.OK);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Object> create(@RequestBody ContactRequest createContactRequest) {

		contactServices.create(createContactRequest);
		return new ResponseEntity<>("Contact created", HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Object> update(@RequestBody ContactRequest updateContactRequest) {

		contactServices.update(updateContactRequest);
		return new ResponseEntity<>("Contact updated.", HttpStatus.OK);
	}
}