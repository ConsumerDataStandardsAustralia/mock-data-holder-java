package au.org.consumerdatastandards.holder.repository;

import au.org.consumerdatastandards.holder.model.DiscoveryOutage;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DiscoveryOutageRepository
    extends PagingAndSortingRepository<DiscoveryOutage, String>, JpaSpecificationExecutor<DiscoveryOutage> { }
