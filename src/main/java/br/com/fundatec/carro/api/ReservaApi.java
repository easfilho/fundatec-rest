package br.com.fundatec.carro.api;

import br.com.fundatec.carro.api.dto.ReservaInputDto;
import br.com.fundatec.carro.api.dto.ReservaOutputDto;
import br.com.fundatec.carro.mapper.ReservaMapper;
import br.com.fundatec.carro.model.Reserva;
import br.com.fundatec.carro.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ReservaApi {

    private final ReservaService reservaService;
    private final ReservaMapper reservaMapper;

    public ReservaApi(ReservaService reservaService, ReservaMapper reservaMapper) {
        this.reservaService = reservaService;
        this.reservaMapper = reservaMapper;
    }

    @PostMapping("/carros/{id}/reservas")
    public ResponseEntity<?> incluirReserva(@RequestBody @Valid ReservaInputDto reservaInputDto,
                                            @PathVariable(value = "id") Long idCarro) {
        Reserva reserva = reservaMapper.mapear(reservaInputDto);
        reserva = reservaService.incluir(reserva,idCarro);
        ReservaOutputDto reservaOutputDto = reservaMapper.mapear(reserva);
        return ResponseEntity.ok(reservaOutputDto);
    }

}
