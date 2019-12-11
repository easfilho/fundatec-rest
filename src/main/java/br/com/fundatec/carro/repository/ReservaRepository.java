package br.com.fundatec.carro.repository;

import br.com.fundatec.carro.model.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long> {
}
