package br.com.fundatec.carro.service;

import br.com.fundatec.carro.model.Carro;
import br.com.fundatec.carro.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<Carro> listarCarros(String nome) {
        return carroRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Carro consultar(Long id) {
        return carroRepository.findById(id)
                .orElse(null);
    }

    public Carro incluir(Carro carro) {
        validar(carro);
        return carroRepository.save(carro);
    }

    private void validar(Carro carro) {
        if(carro.getDataFabricacao().isAfter(carro.getDataModelo())) {
            throw new RuntimeException("Data de fabricação não pode " +
                    "ser maior que data do modelo");
        }

        List<String> marcasValidas = Arrays.asList("Fiat", "Ford", "VolksWagen");
        if(!marcasValidas.contains(carro.getMarca())) {
            throw new RuntimeException("A marca " + carro.getMarca() + " é inválida.");
        }

    }

    public List<Carro> listarCarros(LocalDate dataInicio, LocalDate dataFim) {
        return carroRepository.findByDataFabricacaoBetween(dataInicio, dataFim);
    }

    public Carro atualizar(Long idCarro, Carro carroParaAtualizacao) {
        Carro carro = consultar(idCarro);
        if(carro != null) {
            carro.setNome(carroParaAtualizacao.getNome());
            carro.setMarca(carroParaAtualizacao.getMarca());
            carro.setPlaca(carroParaAtualizacao.getPlaca());
            carro.setDataFabricacao(carroParaAtualizacao.getDataFabricacao());
            carro.setDataModelo(carroParaAtualizacao.getDataModelo());
            carro = carroRepository.save(carro);
        }
        return carro;
    }
}
