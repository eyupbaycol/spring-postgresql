package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> { // ikinci parametre primary alan tipi
    //hangi alanların hangi tipla sorguya hazır olması gerektiğini söylüyor jpa
    Product getByProductName(String productName); // get by gördüğü anda tablodaki ilgili koşula göre where koşulunu ekliyor

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
            //birinci kolon productname
            //ikinci kolon categoryıd

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName); // içeriyorsa contains

    List<Product> getByProductNameStartsWith(String productName); // Bu isimle başlayanları

    @Query("From Product where productName=:productName and categoryId=:categoryId")
    List<Product> getByNameAndCategory_CategoryId(String productName, int categoryId);
    //select * from products where product_name = bisey and categoryId = bisey
}
