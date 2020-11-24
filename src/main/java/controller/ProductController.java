package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import service.product.IProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    IProductService iProductService;

    @GetMapping("/product")
    public ModelAndView showProductList(){
        Iterable<Product> list = iProductService.selectAll();
        ModelAndView modelAndView = new ModelAndView("displayproduct");
        modelAndView.addObject("listProduct",list);
        return modelAndView;
    }
    @GetMapping("product/create")
    public ModelAndView showCreateProduct(){
        ModelAndView modelAndView = new ModelAndView("createproduct");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
}
