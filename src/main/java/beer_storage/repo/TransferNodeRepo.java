package beer_storage.repo;


import beer_storage.model.TransferNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferNodeRepo extends JpaRepository<TransferNode, Long> {
}
