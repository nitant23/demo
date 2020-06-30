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

import marketplace.mpac.requests.AccountRequest;
import marketplace.mpac.responses.AccountContactsResponse;
import marketplace.mpac.responses.AccountResponse;
import marketplace.mpac.services.AccountServices;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
	AccountServices accountServices;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getAccountById(@PathVariable("id") Long id) {

		AccountResponse account = accountServices.getAccountById(id);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}/contacts")
	public ResponseEntity<Object> getAccountWithContactsById(@PathVariable("id") Long id) {

		AccountContactsResponse account = accountServices.getAccountWithContactsById(id);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Object> create(@RequestBody AccountRequest createAccountRequest) {

		accountServices.create(createAccountRequest);
		return new ResponseEntity<>("Account created", HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Object> update(@RequestBody AccountRequest updateAccountRequest) {

		accountServices.update(updateAccountRequest);
		return new ResponseEntity<>("Updated updated.", HttpStatus.OK);
	}
}