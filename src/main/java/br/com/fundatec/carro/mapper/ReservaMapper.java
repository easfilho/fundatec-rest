package br.com.fundatec.carro.mapper;

import br.com.fundatec.carro.api.dto.ReservaInputDto;
import br.com.fundatec.carro.api.dto.ReservaOutputDto;
import br.com.fundatec.carro.model.Reserva;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {

    private final CarroMapper carroMapper;

    public ReservaMapper(CarroMapper carroMapper) {
        this.carroMapper = carroMapper;
    }

    public Reserva mapear(ReservaInputDto reservaInputDto) {
        Reserva reserva = new Reserva();
        reserva.setNome(reservaInputDto.getNome());
        reserva.setDataInicio(reservaInputDto.getDataInicio());
        reserva.setDataFim(reservaInputDto.getDataFim());
        return  reserva;
    }

    public ReservaOutputDto mapear(Reserva reserva) {
        ReservaOutputDto reservaOutputDto = new ReservaOutputDto();
        reservaOutputDto.setId(reserva.getId());
        reservaOutputDto.setNome(reserva.getNome());
        reservaOutputDto.setDataInicio(reserva.getDataInicio());
        reservaOutputDto.setDataFim(reserva.getDataFim());
        reservaOutputDto.setCarroOutputDto(carroMapper.mapear(reserva.getCarro()));
        return reservaOutputDto;
    }
}
