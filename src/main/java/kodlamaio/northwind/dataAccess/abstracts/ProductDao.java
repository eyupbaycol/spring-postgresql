package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> { // ikinci parametre primary alan tipi
    //hangi alanların hangi tipla sorguya hazır olması gerektiğini söylüyor jpa
}
