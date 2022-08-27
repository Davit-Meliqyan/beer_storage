package beer_storage.controller;

import beer_storage.model.Courier;
import beer_storage.model.PriceProduct;
import beer_storage.model.Transfer;
import beer_storage.service.CourierService;
import beer_storage.service.PriceProductService;
import beer_storage.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class PriceProductController {

    @Autowired
    private TransferService transferService;
    @Autowired
    private CourierService courierService;
    @Autowired
    private PriceProductService priceProductService;


    @RequestMapping("/courier_transfers/{id}")
    private String getAllTransfersByCourier(@PathVariable("id") Long id, Model model) {
        Courier courier = courierService.loadCourierById(id);
        List<Transfer> listTransfer = transferService.loadTransferByCourier(courier);
        List<PriceProduct> listPriceProduct = priceProductService.loadAllPriceProductOfCourier(courier);

        model.addAttribute("listTransfer", listTransfer);
        model.addAttribute("listPriceProduct", listPriceProduct);
        model.addAttribute("courier", courier);

        return "transfers_of_courier";
    }

    @RequestMapping("/courier_transfers/edit_price_of_product/{id}")
    private String editPriceProduct(@PathVariable("id") Long id, Model model) {
        PriceProduct priceProduct = priceProductService.loadPriceProductById(id);
        model.addAttribute("priceProduct", priceProduct );

        return "edit_price_product";
    }

    @RequestMapping(path = "/courier_transfers/edit_price_of_product/{id}",
            method = RequestMethod.POST)
    private String updatePriceProduct(@PathVariable("id") Long id,
                                      @ModelAttribute PriceProduct priceProduct) {
        priceProduct.setId(id);

        priceProductService.updatePriceProduct(priceProduct,id);

        Long courierId = priceProduct.getCourier().getId();

        return "redirect:/courier_transfers/" + courierId;
    }
}
