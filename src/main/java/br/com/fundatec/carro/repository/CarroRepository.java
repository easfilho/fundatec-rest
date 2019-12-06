package br.com.fundatec.carro.repository;

import br.com.fundatec.carro.model.Carro;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface CarroRepository extends CrudRepository<Carro, Long> {

    List<Carro> findByNomeContainingIgnoreCase(String nome);

    List<Carro> findByDataFabricacaoBetween(LocalDate dataInicio, LocalDate dataFim);
}
