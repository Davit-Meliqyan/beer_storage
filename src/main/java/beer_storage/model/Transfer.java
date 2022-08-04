package beer_storage.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time")
    private LocalDateTime time;

    @ElementCollection
    @CollectionTable(name = "products_of_transfer",
            joinColumns = {@JoinColumn(name = "transfer_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "item_name")
    @Column(name = "quantity")
    public Map<Product, Integer> products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id",
            foreignKey = @ForeignKey(name = "courier_transfer_fk"))
    private Courier courier;

    public Transfer() {
    }

    public Transfer(Long id, LocalDateTime time, Map<Product, Integer> products, Courier courier) {
        this.id = id;
        this.time = time;
        this.products = products;
        this.courier = courier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
}
