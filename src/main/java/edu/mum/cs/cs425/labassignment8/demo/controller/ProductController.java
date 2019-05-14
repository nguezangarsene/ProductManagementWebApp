package edu.mum.cs.cs425.labassignment8.demo.controller;

import edu.mum.cs.cs425.labassignment8.demo.service.IProductService;
import edu.mum.cs.cs425.labassignment8.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping(value = "/prodmgmt/products/browse")
    public ModelAndView products() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("products/browse");
        return modelAndView;
    }

    @GetMapping(value = "/prodmgmt/products/new")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/new";
    }

    @PostMapping(value = "/prodmgmt/products/new")
    public String addNewProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "products/new";
        }
        product = productService.save(product);
        return "redirect:/prodmgmt/products/browse";
    }

    @GetMapping(value = "/prodmgmt/products/edit/{productId}")
    public String editProduct(@PathVariable Long productId, Model model) {
        Product product = productService.findById(productId);
        if (product != null) {
            model.addAttribute("product", product);
            return "products/edit";
        }
        return "products/browse";
    }

    @PostMapping(value = "/prodmgmt/products/edit")
    public String updateProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "products/edit";
        }
        product = productService.save(product);
        return "redirect:/prodmgmt/products/browse";
    }
}

