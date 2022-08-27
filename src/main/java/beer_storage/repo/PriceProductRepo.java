package beer_storage.repo;

import beer_storage.model.Courier;
import beer_storage.model.PriceProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceProductRepo extends JpaRepository<PriceProduct,Long> {

    List<PriceProduct> findPriceProductsByCourier(Courier courier);
}
