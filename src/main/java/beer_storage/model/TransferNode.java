package beer_storage.model;

import javax.persistence.*;

@Entity
@Table(name = "transfer_node")
public class TransferNode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transfer_id",
            foreignKey = @ForeignKey(name = "transfer_transfer_node_fk"))
    private Transfer transfer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",
            foreignKey = @ForeignKey(name = "product_transfer_node_fk"))
    private Product product;

    public TransferNode() {
    }

    public TransferNode(Long id, Integer quantity, Transfer transfer, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.transfer = transfer;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
