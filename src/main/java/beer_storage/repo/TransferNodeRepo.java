package beer_storage.repo;


import beer_storage.model.Courier;
import beer_storage.model.Transfer;
import beer_storage.model.TransferNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferNodeRepo extends JpaRepository<TransferNode, Long> {
    List<TransferNode> findTransferNodeByTransfer(Transfer transfer);
}
