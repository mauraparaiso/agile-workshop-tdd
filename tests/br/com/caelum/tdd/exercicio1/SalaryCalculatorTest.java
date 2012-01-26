package br.com.caelum.tdd.exercicio1;

import static br.com.caelum.tdd.exercicio1.Position.DBA;
import static br.com.caelum.tdd.exercicio1.Position.DEVELOPER;
import static br.com.caelum.tdd.exercicio1.Position.TESTER;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SalaryCalculatorTest {

	private SalaryCalculator calculator;

	@Before
	public void setUp() {
		calculator = new SalaryCalculator();
	}
	
	@Test
	public void deveRetornar4000MenosImpostosDe20PorCentoSeDesenvolvedorGanhaMaisDe3000(){
		Employee desenvolvedor = umFuncionario(DEVELOPER, comSalarioBase(4000.0));
		
		double salary = calculator.calculate(desenvolvedor);
		
		assertEquals(4000.0 * 0.8, salary, 0.000001);
	}

	@Test
	public void deveRetornar1000MenosImpostosDe10PorCentoSeDesenvolvedorGanhaMenosDe3000(){
		Employee desenvolvedor = umFuncionario(DEVELOPER, comSalarioBase(1000.0));
		
		double salario = calculator.calculate(desenvolvedor);
		
		assertEquals(1000.0 * 0.9, salario, 0.000001);
	}


	@Test
	public void deveRetornar4000MenosImpostosDe25PorCentoSeDBAGanhaMaisDe2000(){
		Employee dba = umFuncionario(DBA, comSalarioBase(4000.0));
		
		double salario = calculator.calculate(dba);
		
		assertEquals(4000.0 * 0.75, salario, 0.000001);
	}

	@Test
	public void deveRetornar1000MenosImpostosDe15PorCentoSeDBAGanhaMenosDe2000(){
		Employee dba = umFuncionario(DBA, comSalarioBase(1000.0));
		
		double salario = calculator.calculate(dba);
		
		assertEquals(1000.0 * 0.85, salario, 0.000001);
	}

	@Test
	public void deveRetornar4000MenosImpostosDe25PorCentoSeTestadorGanhaMaisDe2000(){
		Employee testador = umFuncionario(TESTER, comSalarioBase(4000.0));
		
		double salario = calculator.calculate(testador);
		
		assertEquals(4000.0 * 0.75, salario, 0.000001);
	}

	@Test
	public void deveRetornar1000MenosImpostosDe15PorCentoSeTestadorGanhaMenosDe2000(){
		Employee testador = umFuncionario(TESTER, comSalarioBase(1000.0));
		
		double salario = calculator.calculate(testador);
		
		assertEquals(1000.0 * 0.85, salario, 0.000001);
	}
	
	@Test
	public void deveDeduzir15PorCentoSeGerenteGanhaMenosDe0() {
		Employee gerente = umFuncionario(Position.GERENTEPROJETOS, comSalarioBase(0.0));
		
		double salario = calculator.calculate(gerente);
		
		assertEquals(0.0 * 0.85, salario, 0.000001);
	}
	
	@Test
	public void deveDeduzir15PorCentoSeGerenteGanhaMenosDe5000() {
		Employee gerente = umFuncionario(Position.GERENTEPROJETOS, comSalarioBase(4999.0));
		
		double salario = calculator.calculate(gerente);
		
		assertEquals(4999.0 * 0.85, salario, 0.000001);
	}
		
	@Test
	public void deveDeduzir20PorCentoSeGerenteGanha5000() {
		Employee gerente = umFuncionario(Position.GERENTEPROJETOS, comSalarioBase(5000.0));
		
		double salario = calculator.calculate(gerente);
		
		assertEquals(5000.0 * 0.80, salario, 0.000001);
	}
	

	
	@Test
	public void deveDeduzir20PorCentoSeGerenteGanhaMais5001() {
		Employee gerente = umFuncionario(Position.GERENTEPROJETOS, comSalarioBase(5001.0));
		
		double salario = calculator.calculate(gerente);
		
		assertEquals(5001.0 * 0.80, salario, 0.000001);
	}
	
	@Test
	public void deveDeduzir20PorCentoSeGerenteGanhaMais6000() {
		Employee gerente = umFuncionario(Position.GERENTEPROJETOS, comSalarioBase(6000.0));
		
		double salario = calculator.calculate(gerente);
		
		assertEquals(6000.0 * 0.80, salario, 0.000001);
	}
	
	private Employee umFuncionario(Position cargo, double salario) {
		Employee funcionario = new Employee();
		funcionario.setName("Martin Fowler");
		funcionario.setBaseSalary(salario);
		funcionario.setPosition(cargo);
		return funcionario;
	}
	

	private double comSalarioBase(double salario) {
		return salario;
	}
}
