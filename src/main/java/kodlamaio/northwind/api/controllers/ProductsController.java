package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //bu bir rest controller demek
@RequestMapping("/api/product")
public class ProductsController {

    private ProductService productService;

    @Autowired //Productmanageri newlememize gerek kalmıyor kendi newliyor
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    //Dış dünya ile iletişim kurulan yer tam olarak burası
    @GetMapping("/getall") // /api/products/getall dersem burası çalışır
    public List<Product> getAll(){
        return this.productService.getAll();
    };
}


//kodlama.io -> domain denir    /api/products  bu adres üzerinden gelirse burası karşılasın