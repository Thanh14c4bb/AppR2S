package ProjectR2s.App.repository;

import ProjectR2s.App.entity.Address;
import ProjectR2s.App.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByUser(User user);
    Optional<Address> findByIdAndUser(Long id, User user);


}
