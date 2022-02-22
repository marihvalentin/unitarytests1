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
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Maria", LocalDate.now(),
                        new BigDecimal("25000"))));

        // OU
        //Uso do try catch é útil para capturar a mensagem da exception, por exemplo
        /*try {
            service.calcularBonus(new Funcionario("Maria", LocalDate.now(),
                    new BigDecimal("25000")));
            fail("Não caiu na exception");
        } catch (Exception e) {
            assertEquals("Funcionário com Salário > R$10.000,00 não recebe bônus!", e.getMessage());
        }*/
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
