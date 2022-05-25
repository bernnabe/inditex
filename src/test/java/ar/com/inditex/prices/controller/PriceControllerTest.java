package ar.com.inditex.prices.controller;

import ar.com.inditex.prices.repository.PriceRepository;
import ar.com.inditex.prices.service.PriceService;
import ar.com.inditex.prices.service.impl.PriceServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PriceControllerTest {
    private PriceController controller;

    private MockMvc mockMvc;

    @Autowired
    PriceRepository repository;

    final String urlTemplate = "/price/{paramApplyDate}/{paramProductId}/{paramBrandId}";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        PriceService service = Mockito.spy(new PriceServiceImpl(repository));
        this.controller = Mockito.spy(new PriceController(service));
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
    }

    @Test
    public void test1() throws Exception {
        this.mockMvc.perform(
                        get(urlTemplate,
                                "2020-06-14 10:00",
                                "35455",
                                "1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$..price").value(35.5));

    }

    @Test
    public void test2() throws Exception {

        this.mockMvc.perform(
                        get(urlTemplate,
                                "2020-06-14 16:00",
                                "35455",
                                "1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$..price").value(25.45));

    }
    @Test
    public void test3() throws Exception {

        this.mockMvc.perform(
                        get(urlTemplate,
                                "2020-06-14 21:00",
                                "35455",
                                "1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$..price").value(35.5));

    }

    @Test
    public void test4() throws Exception {

        this.mockMvc.perform(
                        get(urlTemplate,
                                "2020-06-15 10:00",
                                "35455",
                                "1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$..price").value(30.5));

    }

    @Test
    public void test5() throws Exception {

        this.mockMvc.perform(
                        get(urlTemplate,
                                "2020-06-16 21:00",
                                "35455",
                                "1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$..price").value(38.95));
    }

    @Test
    public void test_ping() throws Exception {

        this.mockMvc.perform(
                        get("/ping/")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("pong"));

    }
}