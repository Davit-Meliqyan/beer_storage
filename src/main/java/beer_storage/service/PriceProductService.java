package beer_storage.service;

import beer_storage.model.Courier;
import beer_storage.model.PriceProduct;
import beer_storage.repo.PriceProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceProductService {

    @Autowired
    private PriceProductRepo priceProductRepo;

    public List<PriceProduct> loadAllPriceProductOfCourier(Courier courier) {
        return (List<PriceProduct>) priceProductRepo.findPriceProductsByCourier(courier);
    }

    public PriceProduct loadPriceProductById(Long id) {
        return priceProductRepo.findById(id).get();
    }

    public PriceProduct updatePriceProduct(PriceProduct priceProduct, Long id) {
        priceProduct.setProduct(loadPriceProductById(id).getProduct());
        priceProduct.setCourier(loadPriceProductById(id).getCourier());
        return priceProductRepo.save(priceProduct);
    }

//    public Courier updateCourier(Courier courier, Long id) {
//        courier.setDebt(loadCourierById(id).getDebt());
//        return courierRepo.save(courier);
 //   }
}
