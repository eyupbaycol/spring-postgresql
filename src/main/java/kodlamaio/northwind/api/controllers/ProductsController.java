package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    };
    @PostMapping("/addProduct")
    public Result add(@RequestBody  Product product){ //gelen requestin bodysindeki parametreyi al
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }
    @GetMapping("/getByProductNameOrCategory")
    public DataResult<List<Product>> getByProductNameOrCategory(@RequestParam String productName,  @RequestParam int categoryId){
        return this.productService.getByProductNameOrCategory(productName,categoryId);
    }

    @GetMapping("/getAllPageable")
    public DataResult<List<Product>> getAll(@RequestParam int pageNo, @RequestParam int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getAllSorted")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }
}
