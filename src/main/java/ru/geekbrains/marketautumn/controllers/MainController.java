package ru.geekbrains.marketautumn.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.marketautumn.dto.Product;
import ru.geekbrains.marketautumn.services.ProductService;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProductService service;

    @GetMapping("/hello")
    @ResponseBody
    public String  hello(){
        return "<h1>Hello autumn market</h1>";
    }

    //http://localhost:8189/app/calculate?a=5&b=2
    @GetMapping("/calculate")
    @ResponseBody
    public int calculate(@RequestParam int a,@RequestParam(required = false) int b){
        return a+b;
    }

    //http://localhost:8189/app/products/12/info
    @GetMapping("/products/{id}/info")
    @ResponseBody
    public String info(@PathVariable String id){
        return "product with id " + id;
    }

    @GetMapping("/product")
    public String allProducts(Model model, @RequestParam Long id){
        model.addAttribute("product", service.getProduct(id));
        return "index.html";
    }

    @GetMapping("/allproducts")
    public String getAllProducts(Model model){
        model.addAttribute("allproducts",service.getAllProducts());
        return "allproducts.html";
    }

}
