package au.org.consumerdatastandards.holder.repository.banking;

import au.org.consumerdatastandards.holder.model.banking.BankingAuthorisedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BankingAuthorisedEntityRepository
    extends JpaRepository<BankingAuthorisedEntity, String>, JpaSpecificationExecutor<BankingAuthorisedEntity> { }
