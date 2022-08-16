package beer_storage.controller;

import beer_storage.model.Courier;
import beer_storage.model.Product;
import beer_storage.model.TransferOfCourier;
import beer_storage.repo.TransferOfCourierRepo;
import beer_storage.service.CourierService;
import beer_storage.service.TransferOfCourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TransferOfCourierController {

    @Autowired
    private CourierService courierService;
    @Autowired
    private TransferOfCourierService transferOfCourierService;


    @RequestMapping("/courier_transfers/{id}")
    private String courierTransfers(@PathVariable("id") Long id, Model model) {
        Courier courier = courierService.loadCourierById(id);
        List<TransferOfCourier> listTransfer = transferOfCourierService.loadTransferOfCouriersByCourier(courier);
        List<Map<Product, Integer>> products = new ArrayList<>();
        Map<Product, Integer> priceProducts = courier.getPriceProducts();

        for (TransferOfCourier transfer : listTransfer) {
            products.add(transfer.getProducts());
        }


        model.addAttribute("products", products);
        model.addAttribute("courier", courier);
        model.addAttribute("listTransfer", listTransfer);
        model.addAttribute("priceProducts", priceProducts);
        return "courier_transfers";
    }

    @RequestMapping("/courier_transfers/new_transfer/{id}")
    public String showNewTransferPage(@PathVariable("id") Long id,Model model) {
        Courier courier = courierService.loadCourierById(id);
        TransferOfCourier transfer = new TransferOfCourier();
        transfer.setCourier(courier);

        model.addAttribute("transfer", transfer);
        model.addAttribute("courier", courier);

        return "courier_new_transfer";
    }

    @RequestMapping("/courier_transfers/prices_product/{id}")
    public String showPricesOfPage(@PathVariable("id") Long id, Model model) {
        Courier courier = courierService.loadCourierById(id);
        Map<Product, Integer> prices = courier.getPriceProducts();

        model.addAttribute("prices", prices);
        model.addAttribute("courier", courier);

        return "prices_product";
    }

    @RequestMapping("/courier_transfers/prices_product/add/{id}")
    public String showNewPricePage(@PathVariable("id") Long id, Model model) {
        Courier courier = courierService.loadCourierById(id);
        Map<Product, Integer> prices = courier.getPriceProducts();

        model.addAttribute("prices", prices);
        model.addAttribute("courier", courier);

        return "prices_product";
    }

//    @RequestMapping(path = "/courier_transfers/save_price_product/{idCourier}/{idProduct}", method = RequestMethod.POST)
//    public String savePriceProduct(@PathVariable("idCourier") Long idCourier, @PathVariable("idProduct") Long idProduct,Model model) {
//        courierService.savePriceProduct()
//        return "redirect:/product";
//    }

    @RequestMapping("/courier_transfers/new_price_product/{id}")
    public String showNewPriceProductPage(@PathVariable("id") long id, Model model) {
        Courier courier = courierService.loadCourierById(id);
        model.addAttribute("courier", courier);
        return "new_price_product";
    }
}
