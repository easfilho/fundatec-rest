package br.com.fundatec.carro.integration;

import br.com.fundatec.carro.api.dto.CarroOutputDto;
import br.com.fundatec.carro.model.Carro;
import br.com.fundatec.carro.repository.CarroRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AtualizarCarroTest {

    @LocalServerPort
    private int randomPort;

    @Autowired
    private CarroRepository carroRepository;
    private Carro carro;

    @Before
    public void setUp() throws Exception {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = randomPort;


        carroRepository.deleteAll();

        carro = new Carro();
        carro.setNome("Mustang");
        carro.setPlaca("AJU4455");
        carro.setMarca("Fiat");
        carro.setDataModelo(LocalDate.of(2000, 10, 1));
        carro.setDataFabricacao(LocalDate.of(1999, 10, 1));
        carro = carroRepository.save(carro);
    }

    @Test
    public void deveAtualizarUmCarro() {
        CarroOutputDto carroOutputDto = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body("{" +
                        "\"nome\": \"Chevette\"," +
                        "\"marca\": \"Fiat\",\n" +
                        "\"placa\": \"KKK9999\"," +
                        "\"dataModelo\": \"2000-10-10\"," +
                        "\"dataFabricacao\": \"1999-10-10\"" +
                        "}")
                .when()
                .put("/carros/{id}", carro.getId())
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(CarroOutputDto.class);

        Assert.assertEquals("Chevette" ,carroOutputDto.getNome());
        Assert.assertEquals("Fiat", carroOutputDto.getMarca());
        Assert.assertEquals("KKK9999", carroOutputDto.getPlaca());
        Assert.assertEquals("2000-10-10", carroOutputDto.getDataModelo().toString());
        Assert.assertEquals("1999-10-10", carroOutputDto.getDataFabricacao().toString());

        Carro carroAtualizado = carroRepository.findById(carro.getId()).orElse(null);
        Assert.assertEquals("Chevette" ,carroAtualizado.getNome());
        Assert.assertEquals("Fiat", carroAtualizado.getMarca());
        Assert.assertEquals("KKK9999", carroAtualizado.getPlaca());
        Assert.assertEquals("2000-10-10", carroAtualizado.getDataModelo().toString());
        Assert.assertEquals("1999-10-10", carroAtualizado.getDataFabricacao().toString());
    }
}
