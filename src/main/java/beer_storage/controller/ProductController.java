package beer_storage.controller;

import beer_storage.model.Product;
import beer_storage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping( "/product")
    private String getAllProducts(Model model) {
        List<Product> listProduct = productService.loadAllProducts();
        model.addAttribute("listProduct", listProduct);
        return "product";
    }

    @RequestMapping("/new_product")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @RequestMapping(path = "/save_product", method = RequestMethod.POST)
    public String saveNewProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/product";
    }

    @RequestMapping("/edit_product/{id}")
    private String editProduct(@PathVariable("id") Long id, Model model) {
        Product product = productService.loadProductById(id);
        model.addAttribute("product", product);
        return "edit_product";
    }

    @RequestMapping(path = "/edit_product/{id}", method = RequestMethod.POST)
    private String updateProduct(@PathVariable("id") Long id, @ModelAttribute Product product) {
        product.setId(id);
        productService.updateProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/delete_product/{id}")
    private String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }
}
