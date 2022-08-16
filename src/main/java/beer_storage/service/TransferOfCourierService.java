package beer_storage.service;

import beer_storage.model.Courier;
import beer_storage.model.TransferOfCourier;
import beer_storage.repo.TransferOfCourierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferOfCourierService {

    @Autowired
    private TransferOfCourierRepo transferOfCourierRepo;

    public List<TransferOfCourier> loadAllTransferOfCouriers() {
        return (List<TransferOfCourier>) transferOfCourierRepo.findAll();
    }

    public List<TransferOfCourier> loadTransferOfCouriersByCourier( Courier courier) {
        return (List<TransferOfCourier>) transferOfCourierRepo.findTransferOfCouriersByCourier(courier);
    }

    public TransferOfCourier loadTransferOfCourierById(Long id) {
        return transferOfCourierRepo.findById(id).get();
    }

    public TransferOfCourier saveTransferOfCourier(TransferOfCourier transferOfCourier) {

        transferOfCourierRepo.save(transferOfCourier);
        return loadTransferOfCourierById(transferOfCourier.getId());
    }

    public void deleteTransferOfCourier(Long id) {
        transferOfCourierRepo.deleteById(id);
    }

    public TransferOfCourier updateTransferOfCourier(TransferOfCourier transferOfCourier) {
        return transferOfCourierRepo.save(transferOfCourier);
    }
}
