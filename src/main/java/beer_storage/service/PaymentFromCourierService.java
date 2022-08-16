package beer_storage.service;

import beer_storage.model.PaymentFromCourier;
import beer_storage.repo.PaymentFromCourierRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PaymentFromCourierService {

    @Autowired
    private PaymentFromCourierRepo paymentFromCourierRepo;

    public List<PaymentFromCourier> loadAllPaymentFromCouriers() {
        return (List<PaymentFromCourier>) paymentFromCourierRepo.findAll();
    }

    public PaymentFromCourier loadPaymentFromCourierById(Long id) {
        return paymentFromCourierRepo.findById(id).get();
    }

    public PaymentFromCourier savePaymentFromCourier(PaymentFromCourier paymentFromCourier) {
        paymentFromCourierRepo.save(paymentFromCourier);
        return loadPaymentFromCourierById(paymentFromCourier.getId());
    }

    public void deletePaymentFromCourier(Long id) {
        paymentFromCourierRepo.deleteById(id);
    }

    public PaymentFromCourier updatePaymentFromCourier(PaymentFromCourier paymentFromCourier) {
        return paymentFromCourierRepo.save(paymentFromCourier);
    }
}
