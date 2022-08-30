package beer_storage.service;

import beer_storage.model.Courier;
import beer_storage.model.Transfer;
import beer_storage.model.TransferNode;
import beer_storage.repo.TransferNodeRepo;
import beer_storage.repo.TransferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferService {

    @Autowired
    private TransferRepo transferRepo;
    @Autowired
    private CourierService courierService;

    @Autowired
    private TransferNodeRepo transferNodeRepo;

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


     //   transferNodeRepo.saveAll(transfer.getTransferNodes());
        for (TransferNode transferNode: transfer.getTransferNodes()) {


            transferNodeRepo.save(transferNode);

        }

        transfer.setTime(LocalDateTime.now());
//        Courier courier = courierService.loadCourierById(id);
//        transfer.setCourier(courier);
        transferRepo.save(transfer);

        for (TransferNode transferNode: transfer.getTransferNodes()) {
            transferNode.setTransfer(transfer);
            transferNodeRepo.save(transferNode);
        }

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

//    public void saveTransfer(List<TransferNode> transferNodes) {
//        return transferRepo.saveAll(transferNodes);
//    }
}
