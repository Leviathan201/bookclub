package test.com.bookclub.Web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestHomeController {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    //Testing the home button for bookclub
    public void bookclubHomeForm() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("Form");
    }


    @Test
    //Testing the wishlist button
    public void bookclubWishlist() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/wishlist", String.class)).contains("Form");
    }

    @Test
    //Testing the monthlybook button
    public void bookclubMonthlyBooks() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/monthly-books", String.class)).contains("Form");
    }

    @Test
    //Testing the login button
    public void bookclubLogin() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("Login");
    }

}