package beer_storage.repo;

import beer_storage.model.Courier;
import beer_storage.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepo extends JpaRepository<Transfer,Long> {

    List<Transfer> findTransferByCourier(Courier courier);
}
