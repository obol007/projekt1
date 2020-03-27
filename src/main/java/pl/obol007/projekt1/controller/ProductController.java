package pl.obol007.projekt1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.obol007.projekt1.domain.model.Product;
import pl.obol007.projekt1.dto.ProductDTO;
import pl.obol007.projekt1.service.ProductService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/product")
@Slf4j
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("categories")
    public List<String> getCategories(){
        {
            return Arrays.asList("fruits", "vegetables","nuts&seeds","grains","legumes&beans");
        }
    }

    @GetMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("product",new ProductDTO());
        return "/business/addProduct";
    }
    @PostMapping("/add")
    public String addingProduct(@Valid @ModelAttribute("product") ProductDTO productDTO,
                                BindingResult result){
        if(result.hasErrors()){
            return "/business/addProduct";
        }else{
            productService.addProduct(productDTO);
            return "redirect:/business";
        }
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model){
        ProductDTO productDTO = productService.findProductById(id);
        if(productDTO.getName()==null){
            return "redirect:/business";
        }
        model.addAttribute("product",productDTO);
        return "/business/editProduct";
    }
    @PostMapping("/edit")
    public String editingProduct(ProductDTO productDTO){

        productService.update(productDTO);
        return "redirect:/business";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model){
        ProductDTO productDTO = productService.findProductById(id);
        model.addAttribute("product",productDTO);
        return "/business/deleteConfirmation";
    }
    @PostMapping("/delete")
    public String deletingProduct(ProductDTO productDTO){
        productService.remove(productDTO.getId());
        return "redirect:/business";
    }

    @GetMapping("/show")
    public String showProducts(Model model){
        model.addAttribute("products",productService.findAll());
        return "/client/clientMain";
    }

    @GetMapping("/category/{category}")
    public String showProductByCategory(@PathVariable String category, Model model){
        model.addAttribute("productCategory",productService.findByCategory(category));
        return "/client/clientMain";
    }


}
