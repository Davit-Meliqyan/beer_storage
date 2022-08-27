package beer_storage.model;

import javax.persistence.*;

@Entity
@Table(name = "price_products_of_courier",
        uniqueConstraints={@UniqueConstraint(columnNames ={"product_id","courier_id"})})
public class PriceProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",
            foreignKey = @ForeignKey(name = "product_price_products_fk"))
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id",
            foreignKey = @ForeignKey(name = "courier_price_products_fk"))
    private Courier courier;

    @Column(name = "price")
    Integer price;

    public PriceProduct() {
    }

    public PriceProduct(Long id, Product product, Courier courier, Integer price) {
        this.id = id;
        this.product = product;
        this.courier = courier;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
