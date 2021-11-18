package com.syqu.shop.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecart.shop.controller.CartController;
import com.ecart.shop.controller.HomeController;
import com.ecart.shop.controller.LoginController;
import com.ecart.shop.controller.ProductController;
import com.ecart.shop.controller.RegisterController;
import com.ecart.shop.controller.UserController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ControllersTests {

    @Autowired
    HomeController homeController;
    @Autowired
    LoginController loginController;
    @Autowired
    RegisterController registerController;
    @Autowired
    UserController userController;
    @Autowired
    ProductController productController;
    @Autowired
    CartController cartController;

    @Test
    public void checkIfHomeControllerNotNull() {
        assertThat(homeController).isNotNull();
    }

    @Test
    public void checkIfUserControllerNotNull() {
        assertThat(userController).isNotNull();
    }

    @Test
    public void checkIfLoginControllerNotNull() {
        assertThat(loginController).isNotNull();
    }

    @Test
    public void checkIfRegisterControllerNotNull() {
        assertThat(registerController).isNotNull();
    }

    @Test
    public void checkIfProductControllerNotNull() {
        assertThat(productController).isNotNull();
    }

    @Test
    public void checkIfCartControllerNotNull() {
        assertThat(cartController).isNotNull();
    }
}
