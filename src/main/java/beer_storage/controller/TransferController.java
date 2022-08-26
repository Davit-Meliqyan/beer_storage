package beer_storage.controller;


import beer_storage.model.Transfer;
import beer_storage.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TransferController {

    @Autowired
    private TransferService transferService;

    @RequestMapping( "/transfer")
    private String getAllTransfers(Model model) {
        List<Transfer> listTransfer = transferService.loadAllTransfers();

        model.addAttribute("listTransfer", listTransfer);
        return "transfer";
    }

    @RequestMapping("/new_transfer")
    public String showNewTransferPage(Model model) {
        Transfer transfer = new Transfer();
        model.addAttribute("transfer", transfer);
        return "new_transfer";
    }

    @RequestMapping(path = "/save_transfer", method = RequestMethod.POST)
    public String saveNewTransfer(@ModelAttribute("transfer") Transfer transfer) {
        transferService.saveTransfer(transfer);
        return "redirect:/transfer";
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
