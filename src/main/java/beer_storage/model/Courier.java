package beer_storage.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "courier")
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    String name;

    @Column(name = "debt")
    Integer debt;

    @OneToMany(mappedBy = "courier", cascade = CascadeType.PERSIST)
    List<Transfer> transfers = new ArrayList<>();

    @OneToMany(mappedBy = "courier", cascade = CascadeType.PERSIST)
    List<PriceProduct> priceProducts = new ArrayList<>();

    public Courier() {
    }

    public Courier(Long id, String name, Integer debt, List<Transfer> transfers, List<PriceProduct> priceProducts) {
        this.id = id;
        this.name = name;
        this.debt = debt;
        this.transfers = transfers;
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

    public Integer getDebt() {
        return debt;
    }

    public void setDebt(Integer debt) {
        this.debt = debt;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public List<PriceProduct> getPriceProducts() {
        return priceProducts;
    }

    public void setPriceProducts(List<PriceProduct> priceProducts) {
        this.priceProducts = priceProducts;
    }
}
