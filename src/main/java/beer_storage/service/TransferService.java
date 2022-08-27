package beer_storage.service;

import beer_storage.model.Courier;
import beer_storage.model.Transfer;
import beer_storage.repo.TransferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    @Autowired
    private TransferRepo transferRepo;

    public List<Transfer> loadAllTransfers() {
        return (List<Transfer>) transferRepo.findAll();
    }

    public List<Transfer> loadAllTransfersOfCourier(Courier courier) {
        return (List<Transfer>) transferRepo.findTransferByCourier(courier);
    }

    public Transfer loadTransferById(Long id) {
        return transferRepo.findById(id).get();
    }

    public Transfer saveTransfer(Transfer transfer) {
        transferRepo.save(transfer);
        return loadTransferById(transfer.getId());
    }

    public void deleteTransfer(Long id) {
        transferRepo.deleteById(id);
    }

    public Transfer updateTransfer(Transfer transfer) {
        return transferRepo.save(transfer);
    }

    public List<Transfer> loadTransferByCourier(Courier courier) {
        return transferRepo.findTransferByCourier(courier);
    }
}
