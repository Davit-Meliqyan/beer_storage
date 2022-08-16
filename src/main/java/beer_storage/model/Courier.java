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

//    @ElementCollection
//    @CollectionTable(name = "transfers_of_courier",
//            joinColumns = {@JoinColumn(name = "courier_id", referencedColumnName = "id")})
//    @MapKeyColumn(name = "item_name")
//    @Column(name = "quantity")
//    public Map<TransferOfCourier, Integer> transfers;

    @ElementCollection
    @CollectionTable(name = "price_products_of_courier",
            joinColumns = {@JoinColumn(name = "courier_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "item_name")
    @Column(name = "price")
    public Map<Product, Integer> priceProducts;

    @Column(name = "debt")
    Integer debt;

    public Courier() {
    }

    public Courier(Long id, String name,// Map<TransferOfCourier, Integer> transfers,
                   Map<Product, Integer> priceProducts, Integer debt) {
        this.id = id;
        this.name = name;
       // this.transfers = transfers;
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

//    public Map<TransferOfCourier, Integer> getTransfers() {
//        return transfers;
//    }
//
//    public void setTransfers(Map<TransferOfCourier, Integer> transfers) {
//        this.transfers = transfers;
//    }

    public Integer getDebt() {
        return debt;
    }

    public void setDebt(Integer debt) {
        this.debt = debt;
    }

    public Map<Product, Integer> getPriceProducts() {
        return priceProducts;
    }

    public void setPriceProducts(Map<Product, Integer> priceProducts) {
        this.priceProducts = priceProducts;
    }
}
