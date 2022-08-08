package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Product;
import com.codeup.springblog.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    private final ProductRepository productDao;

    public ProductController(ProductRepository productsDao) {
        this.productDao = productsDao;
    }

    @GetMapping("/products")
    public String showAllProducts(Model model) {
        model.addAttribute("products", productDao.findAll());
        List<Product> searchProducts = productDao.getProductByName("oil");
        for (Product product : searchProducts)
            System.out.println(product.getName());
        //productdao.save(new product(55,shoes,$55.99))
        return "products/index";

    }

    @GetMapping("/products/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());

        return "products/create";
    }

    @PostMapping("/products/create")
    public String create(@ModelAttribute Product product) {
        productDao.save(product);
        return "redirect:/products";
    }

    @GetMapping("product/edit/{id}")
    public String editProduct(Model model, @PathVariable long id){
        model.addAttribute("product", productDao.getById(id));
                return "redirect:/products";
    }
}
