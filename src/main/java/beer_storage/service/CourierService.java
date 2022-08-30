package beer_storage.service;

import beer_storage.model.*;
import beer_storage.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CourierService {

    @Autowired
    private CourierRepo courierRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private PriceProductRepo priceProductRepo;
    @Autowired
    private TransferRepo transferRepo;
    @Autowired
    private TransferNodeRepo transferNodeRepo;

    public List<Courier> loadAllCouriers() {
        return (List<Courier>) courierRepo.findAll();
    }

    public Courier loadCourierById(Long id) {
        return courierRepo.findById(id).get();
    }
    public Courier loadCourierByName(String name) {
        return courierRepo.findByName(name).get();
    }
    public Courier saveCourier(Courier courier) {
        courier.setDebt(0);
        courierRepo.save(courier);

        for (Product product : productRepo.findAll()) {
            PriceProduct priceProduct = new PriceProduct();
            priceProduct.setProduct(product);
            priceProduct.setPrice(product.getCostPrice());
            priceProduct.setCourier(courier);
            priceProductRepo.save(priceProduct);
        }
        return loadCourierById(courier.getId());
    }

//    public Courier savePriceProduct(Courier courier, Product product,Integer price) {
//        Map<Product, Integer> products = courier.getPriceProducts();
//        products.put(product,price);
//        return loadCourierById(courier.getId());
//    }

    public void deleteCourier(Long id) {

       // Courier courier = loadCourierById(id);

        for (Transfer transfer: transferRepo.findTransferByCourier(loadCourierById(id))) {
            for (TransferNode transferNode : transferNodeRepo.findTransferNodeByTransfer(transfer)){
                transferNodeRepo.deleteById(transferNode.getId());
            }
           transferRepo.deleteById(transfer.getId());
        }
        for (PriceProduct priceProduct: priceProductRepo.findPriceProductsByCourier( loadCourierById(id))) {
          priceProductRepo.deleteById(priceProduct.getId());
        }

        courierRepo.deleteById(id);
    }

    public Courier updateCourier(Courier courier, Long id) {
        courier.setDebt(loadCourierById(id).getDebt());
        return courierRepo.save(courier);
    }
}
