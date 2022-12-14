package beer_storage.controller;


import beer_storage.model.*;
import beer_storage.service.CourierService;
import beer_storage.service.PaymentFromCourierService;
import beer_storage.service.PriceProductService;
import beer_storage.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@Controller
public class TransferController {

    @Autowired
    private TransferService transferService;
    @Autowired
    private CourierService courierService;
    @Autowired
    private PriceProductService priceProductService;
    @Autowired
    private PaymentFromCourierService payService;


    @RequestMapping( "/transfer")
    private String getAllTransfers(Model model) {
        List<Transfer> listTransfer = transferService.loadAllTransfers();

        model.addAttribute("listTransfer", listTransfer);
//        for (Transfer tr : listTransfer) {
//            System.out.println(tr);
//        }

        return "transfer";
    }



    @RequestMapping("/new_transfer/{id}")
    public String showNewTransferPage(@PathVariable("id") Long id,Model model) {

        Transfer transfer = new Transfer();
        Courier courier = courierService.loadCourierById(id);
        transfer.setCourier(courier);
        List<PriceProduct> listPriceProduct = priceProductService.loadAllPriceProductOfCourier(courier);

        List<TransferNode> listTransferNode = new ArrayList<>();

        for (PriceProduct priceProduct: listPriceProduct) {
            TransferNode transferNode = new TransferNode();
            transferNode.setProduct(priceProduct.getProduct());
            listTransferNode.add(transferNode);
        }
        transfer.setTransferNodes(listTransferNode);


        List<PaymentFromCourier> listPays = payService.loadPaymentByCourier(courier);


        model.addAttribute("transfer", transfer);
        model.addAttribute("courier", courier);
        model.addAttribute("listTransferNode", listTransferNode);
        model.addAttribute("listPays", listPays);


        return "new_transfer";
    }

    @RequestMapping(path = "/save_transfer/{courierName}", method = RequestMethod.POST)
    public String saveNewTransfer(@PathVariable("courierName") String courierName,@ModelAttribute("transfer") Transfer transfer) {

        Courier courier = courierService.loadCourierByName(courierName);
        transfer.setCourier(courier);

        transferService.saveTransfer(transfer);

        return "redirect:/courier_transfers/" + courier.getId();
    }

    @RequestMapping("/edit_transfer/{id}")
    private String editTransfer(@PathVariable("id") Long id, Model model) {
        Transfer transfer = transferService.loadTransferById(id);
        model.addAttribute("transfer", transfer);
        return "edit_transfer";
    }

    @RequestMapping(path = "/edit_transfer/{id}", method = RequestMethod.POST)
    private String updateTransfer(@PathVariable("id") Long id, @ModelAttribute Transfer transfer) {
        transfer.setId(id);
        transferService.updateTransfer(transfer);
        return "redirect:/transfer";
    }

    @GetMapping("/delete_transfer/{id}")
    private String deleteTransfer(@PathVariable("id") Long id) {
        transferService.deleteTransfer(id);
        return "redirect:/transfer";
    }
}
