package beer_storage.repo;

import beer_storage.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourierRepo  extends JpaRepository<Courier,Long> {

    Optional<Courier> findByName(String name);
}
