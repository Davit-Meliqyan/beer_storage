package beer_storage.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id",
            foreignKey = @ForeignKey(name = "courier_transfer_fk"))
    private Courier courier;

    @Column(name = "time")
    private LocalDateTime time;


    @OneToMany(mappedBy = "transfer", cascade = CascadeType.PERSIST)
    List<TransferNode> transferNodes = new ArrayList<>();

    public Transfer() {
    }

    public Transfer(Long id, Courier courier, LocalDateTime time, List<TransferNode> transferNodes) {
        this.id = id;
        this.courier = courier;
        this.time = time;
        this.transferNodes = transferNodes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<TransferNode> getTransferNodes() {
        return transferNodes;
    }

    public void setTransferNodes(List<TransferNode> transferNodes) {
        this.transferNodes = transferNodes;
    }

}
