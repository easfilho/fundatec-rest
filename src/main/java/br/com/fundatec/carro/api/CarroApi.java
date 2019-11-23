package br.com.fundatec.carro.api;

import br.com.fundatec.carro.service.CarroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CarroApi {

    private final CarroService carroService;

    public CarroApi(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping("carros")
    public List<String> getCarros() {
        return carroService.listarCarros();
    }
}
