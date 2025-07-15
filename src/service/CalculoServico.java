package service;

import entities.Servico;
import java.time.LocalDate;

public class CalculoServico {

    public double calcularLucro(Servico servico) {
        if (servico == null) {
            return 0;
        }

        return servico.getValorObra();
    }


    public double calcularGasto(Servico servico) {
        if (servico == null) {
            return 0;
        }

        return servico.getValorPeca();
    }


    public LocalDate calcularFimGarantia(Servico servico) {
        if (servico == null || servico.getDataEntrada() == null || servico.getDiasGarantia() <= 0) {
            return null;
        }

        return servico.getDataEntrada().plusDays(servico.getDiasGarantia());
    }
}