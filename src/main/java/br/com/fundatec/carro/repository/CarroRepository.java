package br.com.fundatec.carro.repository;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CarroRepository {

    public List<String> listarCarros() {
        List<String> carros = Arrays.asList("Mustang",
                "Fusca",
                "Fumbica",
                "Celta",
                "Uno com escada");
        return carros;
    }
}
