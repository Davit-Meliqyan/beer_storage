package beer_storage.model;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "paymentes_from_courier")
public class PaymentFromCourier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "pay")
    private Integer pay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id",
            foreignKey = @ForeignKey(name = "courier_payment_fk"))
    private Courier courier;

    public PaymentFromCourier() {
    }

    public PaymentFromCourier(Long id, LocalDateTime time, Integer pay, Courier courier) {
        this.id = id;
        this.time = time;
        this.pay = pay;
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

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
}
