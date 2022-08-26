package beer_storage.repo;


import beer_storage.model.Courier;
import beer_storage.model.PaymentFromCourier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentFromCourierRepo extends JpaRepository<PaymentFromCourier,Long> {
    List<PaymentFromCourier> findPaymentFromCourierByCourier(Courier courier);
}
