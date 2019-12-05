package br.com.fundatec.carro.mapper;

import br.com.fundatec.carro.api.CarroInputDto;
import br.com.fundatec.carro.api.CarroOutputDto;
import br.com.fundatec.carro.model.Carro;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarroMapper {

    public CarroOutputDto mapear(Carro carro) {
        CarroOutputDto carroOutputDto = new CarroOutputDto();
        carroOutputDto.setId(carro.getId());
        carroOutputDto.setNome(carro.getNome());
        return carroOutputDto;
    }

    public List<CarroOutputDto> mapear(List<Carro> carros) {
        List<CarroOutputDto> carroOutputDtos = new ArrayList<>();
        for(Carro carro : carros) {
            carroOutputDtos.add(mapear(carro));
        }
        return carroOutputDtos;
    }

    public Carro mapear(CarroInputDto carroInputDto) {
        Carro carro = new Carro();
        carro.setNome(carroInputDto.getNome());
        carro.setPlaca(carroInputDto.getPlaca());
        carro.setDataFabricacao(carroInputDto.getDataFabricacao());
        carro.setDataModelo(carroInputDto.getDataModelo());
        carro.setMarca(carroInputDto.getMarca());
        return carro;
    }
}
