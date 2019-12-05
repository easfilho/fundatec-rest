package br.com.fundatec.carro.api;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class CarroInputDto {

    @NotBlank(message = "O campo nome é obrigatório.")
    private String nome;

    @Pattern(regexp = "^[A-Z]{3}[0-9]{4}$", message = "Placa inválida")
    @NotBlank(message = "O campo placa é obrigatório")
    private String placa;

    @Past(message = "Data de fabricação deve ser no passado")
    @NotNull(message = "O campo data de fabricação é obrigatório")
    private LocalDate dataFabricacao;

    @NotNull(message = "O campo data do model é obrigatório")
    private LocalDate dataModelo;

    @NotEmpty(message = "O campo marca é obrigatório")
    private String marca;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataModelo() {
        return dataModelo;
    }

    public void setDataModelo(LocalDate dataModelo) {
        this.dataModelo = dataModelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
