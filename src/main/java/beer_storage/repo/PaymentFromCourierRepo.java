package beer_storage.repo;


import beer_storage.model.PaymentFromCourier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentFromCourierRepo extends JpaRepository<PaymentFromCourier,Long> {
}
