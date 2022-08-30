package beer_storage.service;

import beer_storage.model.*;
import beer_storage.repo.PaymentFromCourierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentFromCourierService {

    @Autowired
    private PaymentFromCourierRepo paymentFromCourierRepo;

    public List<PaymentFromCourier> loadAllPaymentFromCouriers() {
        return (List<PaymentFromCourier>) paymentFromCourierRepo.findAll();
    }

    public List<PaymentFromCourier> loadPaymentByCourier(Courier courier) {
        return (List<PaymentFromCourier>) paymentFromCourierRepo.findPaymentFromCourierByCourier(courier);
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

    public List<PaymentFromCourier> loadAllPays() {
        return (List<PaymentFromCourier>) paymentFromCourierRepo.findAll();
    }

    public PaymentFromCourier savePay(PaymentFromCourier pay) {


        Courier courier = pay.getCourier();
        Integer total = courier.getDebt();

        total -= pay.getPay();

        courier.setDebt(total);

        pay.setTime(LocalDateTime.now());


        paymentFromCourierRepo.save(pay);


        return loadPaymentFromCourierById(pay.getId());
    }
}
