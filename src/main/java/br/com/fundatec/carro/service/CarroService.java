package br.com.fundatec.carro.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CarroService {

    public List<String> listarCarros() {
        List<String> carros = Arrays.asList("Mustang",
                "Fusca",
                "Fumbica",
                "Celta",
                "Uno com escada");
        return carros;
    }
}
