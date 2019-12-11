package br.com.fundatec.carro.service;

import br.com.fundatec.carro.model.Carro;
import br.com.fundatec.carro.model.Reserva;
import br.com.fundatec.carro.repository.ReservaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private final CarroService carroService;
    private final ReservaRepository reservaRepository;

    public ReservaService(CarroService carroService, ReservaRepository reservaRepository) {
        this.carroService = carroService;
        this.reservaRepository = reservaRepository;
    }

    public Reserva incluir(Reserva reserva, Long idCarro) {
        Carro carro = carroService.consultar(idCarro);
        reserva.setCarro(carro);
        return reservaRepository.save(reserva);
    }
}
