package marketplace.mpac.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marketplace.mpac.entity.Account;

@Repository
public interface UpsertAccount extends JpaRepository<Account, Long>{

}
