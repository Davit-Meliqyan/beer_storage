package beer_storage.controller;


import beer_storage.model.*;
import beer_storage.service.CourierService;
import beer_storage.service.PaymentFromCourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
public class PaymentFromCourierController {

    @Autowired
    private PaymentFromCourierService payService;
    @Autowired
    private CourierService courierService;


    @RequestMapping("/payments")
    private String getAllPays(Model model) {
        List<PaymentFromCourier> listPays = payService.loadAllPays();
        model.addAttribute("listPays", listPays);
        return "pay";
    }

    @RequestMapping("/new_pay/{id}")
    public String showNewPayPage(@PathVariable("id") Long id, Model model) {

        PaymentFromCourier pay = new PaymentFromCourier();
        Courier courier = courierService.loadCourierById(id);


        model.addAttribute("pay", pay);
        model.addAttribute("courier", courier);

        return "new_pay";
    }

    @RequestMapping(path = "/save_pay/{courierName}", method = RequestMethod.POST)
    public String saveNewPay(@PathVariable("courierName") String courierName,
                                  @ModelAttribute("pay") PaymentFromCourier pay) {

        Courier courier = courierService.loadCourierByName(courierName);
        pay.setCourier(courier);

        payService.savePay(pay);

        return "redirect:/courier_transfers/" + courier.getId();
    }
}
