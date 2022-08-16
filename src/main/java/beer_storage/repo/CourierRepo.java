package beer_storage.repo;

import beer_storage.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepo  extends JpaRepository<Courier,Long> {
}
