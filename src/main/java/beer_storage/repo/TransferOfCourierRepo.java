package beer_storage.repo;


import beer_storage.model.Courier;
import beer_storage.model.TransferOfCourier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferOfCourierRepo extends JpaRepository<TransferOfCourier,Long> {
    List<TransferOfCourier> findTransferOfCouriersByCourier(Courier courier);
}
