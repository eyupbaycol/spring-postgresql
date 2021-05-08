package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired; // bean varsa class demek
import org.springframework.stereotype.Service;

import java.util.List;
@Service //bu class projede servis görevi görecek demek
public class ProductManager implements ProductService {
    //constructor yerine @autowired direk buraya yazarsak injection yapar
    private ProductDao productDao;

    @Autowired // productdaoya karşılık gelebilecek bir sınıf varsa getirir yani jpada üretilen sınıfı
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
       return this.productDao.findAll();
    }
}
