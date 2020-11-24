package controller;

import model.Customer;
import model.CustomerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.customer.CustomerService;
import service.customer.ICustomerService;

import java.io.File;
import java.io.IOException;

@Controller
public class CustomerController {

    @Autowired
    Environment environment;

    @Autowired
    ICustomerService customerService;

    @GetMapping("")
    public ModelAndView display(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("listCustomer", customerService.selectAll());
        return modelAndView;
    }

    @GetMapping("/customer/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer",new CustomerForm());
        return modelAndView;
    }

    @PostMapping("/customer/create")
    public ModelAndView createCustomer(@ModelAttribute CustomerForm customerForm){

        Customer customer = new Customer( customerForm.getName(),customerForm.getEmail(),customerForm.getAddress());
        MultipartFile multipartFile = customerForm.getImage();
        String image = multipartFile.getOriginalFilename();
        customer.setImage(image);
        String fileUpload = environment.getProperty("file_upload").toString();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        customerService.save(customer);
        return new ModelAndView("create", "customer", new CustomerForm());
    }

    @GetMapping("/customer/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        CustomerForm customerForm = new CustomerForm(customer.getId(), customer.getName(),customer.getAddress(), customer.getEmail() );
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer", customerForm);
        modelAndView.addObject("customerForm", customer);
        return modelAndView;
    }
    @PostMapping("customer/edit/{id}")
    public String editCustomer(@ModelAttribute CustomerForm customer){
        Customer customer1 = new Customer(customer.getId(),customer.getName(),customer.getAddress(),customer.getEmail());
            MultipartFile multipartFile = customer.getImage();
            String image = multipartFile.getOriginalFilename();
            if (!image.equals("")){
                customer1.setImage(image);
                String fileUpload = environment.getProperty("file_upload").toString();
                try {
                    FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + image));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                //customer1.setImage(image1);
            }
        customerService.update(customer1);

        return "redirect:/";
    }
    @GetMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable Long id){
        customerService.remote(id);
        return "redirect:/";
    }
}
