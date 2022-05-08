package am.hgh.basicauthentication.repository;

import am.hgh.basicauthentication.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query(value = "select e from CustomerDetailsEntity e where  e.userName = ?1")
    CustomerEntity findByCustomerName(String customerName);

}
