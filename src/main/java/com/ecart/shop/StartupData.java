package com.ecart.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecart.shop.domain.Category;
import com.ecart.shop.domain.Product;
import com.ecart.shop.domain.User;
import com.ecart.shop.repository.CategoryRepository;
import com.ecart.shop.service.ProductService;
import com.ecart.shop.service.UserService;

import java.math.BigDecimal;

@Component
public class StartupData implements CommandLineRunner {
    private final UserService userService;
    private final ProductService productService;
    private final CategoryRepository categoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(StartupData.class);

    @Autowired
    public StartupData(UserService userService, ProductService productService, CategoryRepository categoryRepository) {
        this.userService = userService;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        adminAccount();
        userAccount();
        category();
        exampleProducts();
    }

    private void userAccount(){
        User user = new User();

        user.setUsername("user");
        user.setPassword("user");
        user.setPasswordConfirm("user");
        user.setGender("Female");
        user.setEmail("user@example.com");

        userService.save(user);
    }

    private void adminAccount(){
        User admin = new User();

        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setPasswordConfirm("admin");
        admin.setGender("Male");
        admin.setEmail("admin@example.com");

        userService.save(admin);
    }

    private void category(){
        Category category1 = new Category();
        Category category2 = new Category();
        category1.setId(1);
        category1.setCategoryName("Adventure");
        category2.setId(2);
        category2.setCategoryName("Novel");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
    }

    private void exampleProducts(){
        final String NAME1 = "RuckSack";
        final String NAME2 = "Trekking Shoes";
        final String NAME3 = "One Indian Girl Book";
        final String NAME4 = "Can Love Happen Twice";
        final String IMAGE_URL1 = "https://m.media-amazon.com/images/I/41O2BEP-K4L.jpg";
        final String IMAGE_URL2 = "https://5.imimg.com/data5/WF/PC/XD/SELLER-26489940/quechua-mh100-waterproof-brown-men-hiking-shoes-500x500.jpg";
        final String IMAGE_URL3 = "https://images-eu.ssl-images-amazon.com/images/I/51kA-Upq61L._SY264_BO1,204,203,200_QL40_ML2_.jpg";
        final String IMAGE_URL4 = "https://images-na.ssl-images-amazon.com/images/I/718y+VFFL5L.jpg";
        
        final String DESCRIPTION1 = "Example Description";
        final String DESCRIPTION2 = "Example Description";
        final String DESCRIPTION3 = "Example Description";
        final String DESCRIPTION4 = "Example Description";
        
        final BigDecimal PRICE1 = BigDecimal.valueOf(2499.00);
        final BigDecimal PRICE2 = BigDecimal.valueOf(1999.00);
        final BigDecimal PRICE3 = BigDecimal.valueOf(350.00);
        final BigDecimal PRICE4 = BigDecimal.valueOf(320.00);

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();

        product1.setName(NAME1);
        product1.setImageUrl(IMAGE_URL1);
        product1.setDescription(DESCRIPTION1);
        product1.setCategory(categoryRepository.findByCategoryName("Adventure"));
        product1.setPrice(PRICE1);

        product2.setName(NAME2);
        product2.setImageUrl(IMAGE_URL2);
        product2.setDescription(DESCRIPTION2);
        product2.setCategory(categoryRepository.findByCategoryName("Adventure"));
        product2.setPrice(PRICE2);

        product3.setName(NAME3);
        product3.setImageUrl(IMAGE_URL3);
        product3.setDescription(DESCRIPTION3);
        product3.setCategory(categoryRepository.findByCategoryName("Novel"));
        product3.setPrice(PRICE3);

        product4.setName(NAME4);
        product4.setImageUrl(IMAGE_URL4);
        product4.setDescription(DESCRIPTION4);
        product4.setCategory(categoryRepository.findByCategoryName("Novel"));
        product4.setPrice(PRICE4);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
    }
}
