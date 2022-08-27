package beer_storage.service;

import beer_storage.model.Product;
import beer_storage.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> loadAllProducts() {
        return (List<Product>) productRepo.findAll();
    }

    public Product loadProductById(Long id) {
        return productRepo.findById(id).get();
    }

    public Product saveProduct(Product product) {
        productRepo.save(product);
        return loadProductById(product.getId());
    }

    public void deleteProduct(Long id) {

        productRepo.deleteById(id);
    }

    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }
}
