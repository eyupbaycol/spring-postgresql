package kodlamaio.northwind.entities.concretes;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity  //Product bir entitydir diyoruz bunu diyerek
@Table(name = "products")   //Bu veri tabanında hangi tabloya karşılık gelecek -> products tablosuna

public class Product {
    @Id // hangi column idye denk gelicek söylemek için
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //bu id nasıl oluşturulacak söylememiz lazım id yi -> 1 1 arttır demek bu
    @Column(name = "product_id") // tablodaki hangi colona denk geliyor
    private int id;

//    @Column(name = "category_id")
//    private int categoryId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "units_in_stock")
    private short unitsInStock;

    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;


    @ManyToOne()
    @JoinColumn(name = "category_id") //hangi alan ile join olacak
    private Category category; // productaki category alanıyle ilşkilendirlecek altta yazdığımız

}
