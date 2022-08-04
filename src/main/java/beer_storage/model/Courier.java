package beer_storage.model;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "couriers")
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    String name;

    @ElementCollection
    @CollectionTable(name = "products_of_courier",
            joinColumns = {@JoinColumn(name = "courier_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "item_name")
    @Column(name = "quantity")
    public Map<Product, Integer> products;

    @ElementCollection
    @CollectionTable(name = "price_products_of_courier",
            joinColumns = {@JoinColumn(name = "courier_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "item_name")
    @Column(name = "price")
    public Map<Product, Integer> priceProducts;

    @Column(name = "debt")
    String debt;

    public Courier() {
    }

    public Courier(Long id, String name, Map<Product, Integer> products, Map<Product, Integer> priceProducts, String debt) {
        this.id = id;
        this.name = name;
        this.products = products;
        this.priceProducts = priceProducts;
        this.debt = debt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public String getDebt() {
        return debt;
    }

    public void setDebt(String debt) {
        this.debt = debt;
    }

    public Map<Product, Integer> getPriceProducts() {
        return priceProducts;
    }

    public void setPriceProducts(Map<Product, Integer> priceProducts) {
        this.priceProducts = priceProducts;
    }
}
