package beer_storage.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    String name;

    @Column(name = "cost_price")
    Integer costPrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    List<TransferNode> transferNodes = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    List<PriceProduct> priceProducts = new ArrayList<>();

    public Product() {
    }

    public Product(Long id, String name, Integer costPrice, List<TransferNode> transferNodes, List<PriceProduct> priceProducts) {
        this.id = id;
        this.name = name;
        this.costPrice = costPrice;
        this.transferNodes = transferNodes;
        this.priceProducts = priceProducts;
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

    public Integer getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Integer costPrice) {
        this.costPrice = costPrice;
    }

    public List<TransferNode> getTransferNodes() {
        return transferNodes;
    }

    public void setTransferNodes(List<TransferNode> transferNodes) {
        this.transferNodes = transferNodes;
    }

    public List<PriceProduct> getPriceProducts() {
        return priceProducts;
    }

    public void setPriceProducts(List<PriceProduct> priceProducts) {
        this.priceProducts = priceProducts;
    }
}
