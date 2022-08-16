package beer_storage.controller;

import beer_storage.model.Courier;
import beer_storage.model.Product;
import beer_storage.model.TransferOfCourier;
import beer_storage.service.CourierService;
import beer_storage.service.TransferOfCourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@Controller
public class CourierController {

    @Autowired
    private CourierService courierService;


    @RequestMapping("/courier")
    private String getAllCouriers(Model model) {
        List<Courier> listCourier = courierService.loadAllCouriers();
        model.addAttribute("listCourier", listCourier);
        return "courier";
    }

    @RequestMapping("/new_courier")
    public String showNewCourierPage(Model model) {
        Courier courier = new Courier();
        model.addAttribute("courier", courier);
        return "new_courier";
    }

    @RequestMapping(path = "/save_courier", method = RequestMethod.POST)
    public String saveNewCourier(@ModelAttribute("courier") Courier courier) {
        courierService.saveCourier(courier);
        return "redirect:/courier";
    }

    @RequestMapping("/edit_courier/{id}")
    private String editCourier(@PathVariable("id") Long id, Model model) {
        Courier courier = courierService.loadCourierById(id);
        model.addAttribute("courier", courier);
        return "edit_courier";
    }

    @RequestMapping(path = "/edit_courier/{id}", method = RequestMethod.POST)
    private String updateCourier(@PathVariable("id") Long id, @ModelAttribute Courier courier) {
        courier.setId(id);
        courierService.updateCourier(courier,id);
        return "redirect:/courier";
    }

    @GetMapping("/delete_courier/{id}")
    private String deleteCourier(@PathVariable("id") Long id) {
        courierService.deleteCourier(id);
        return "redirect:/courier";
    }




}
