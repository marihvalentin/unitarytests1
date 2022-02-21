package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroParaSalarioMuitoAlto() {
        BonusService service = new BonusService();
        BigDecimal bonus =
        service.calcularBonus(new Funcionario("Maria", LocalDate.now(), new BigDecimal("25000")));

        assertEquals(new BigDecimal("0.00"), bonus);
    }

    @Test
    public void bonusDeveriaSer10PorcentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus =
                service.calcularBonus(new Funcionario("Maria", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void bonuDeveriaSer10PorcentoParaSalarioDeExatos10000() {
        BonusService service = new BonusService();
        BigDecimal bonus =
                service.calcularBonus(new Funcionario("Maria", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}
