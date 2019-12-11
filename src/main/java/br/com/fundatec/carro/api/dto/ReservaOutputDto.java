package br.com.fundatec.carro.api.dto;

import java.time.LocalDate;

public class ReservaOutputDto {

    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String nome;
    private CarroOutputDto carroOutputDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CarroOutputDto getCarroOutputDto() {
        return carroOutputDto;
    }

    public void setCarroOutputDto(CarroOutputDto carroOutputDto) {
        this.carroOutputDto = carroOutputDto;
    }
}
