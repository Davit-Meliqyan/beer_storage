package beer_storage.service;

import beer_storage.model.Courier;
import beer_storage.model.Product;
import beer_storage.repo.CourierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class CourierService {

    @Autowired
    private CourierRepo courierRepo;

    public List<Courier> loadAllCouriers() {
        return (List<Courier>) courierRepo.findAll();
    }

    public Courier loadCourierById(Long id) {
        return courierRepo.findById(id).get();
    }

    public Courier saveCourier(Courier courier) {
        courier.setDebt(0);
        courierRepo.save(courier);
        return loadCourierById(courier.getId());
    }

    public Courier savePriceProduct(Courier courier, Product product,Integer price) {
        Map<Product, Integer> products = courier.getPriceProducts();
        products.put(product,price);
        return loadCourierById(courier.getId());
    }

    public void deleteCourier(Long id) {
        courierRepo.deleteById(id);
    }

    public Courier updateCourier(Courier courier, Long id) {
        courier.setDebt(loadCourierById(id).getDebt());
        return courierRepo.save(courier);
    }
}
