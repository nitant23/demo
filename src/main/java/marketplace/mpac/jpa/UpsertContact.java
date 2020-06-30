package marketplace.mpac.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.mpac.entity.Contact;

@Repository
public interface UpsertContact extends JpaRepository<Contact, Long>{

	 
}
