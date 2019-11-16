package au.org.consumerdatastandards.holder.repository;

import au.org.consumerdatastandards.holder.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository
    extends PagingAndSortingRepository<User, String>, JpaSpecificationExecutor<User> { }
