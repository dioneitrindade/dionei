/**
 * 
 */
package br.com.bluebank.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Dionei Trindade
 * Data: 20/10/2016
 * Projeto de Tranferência Bancária
 *
 */
@Entity
public class Conta {
	
	@SequenceGenerator(name = "contaGenerator", sequenceName = "CONTA_SEQ", allocationSize = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contaGenerator")	
	private Integer id;
	
	private String titular;
	private int agencia;
	private int conta;
	private double saldo;
	
	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public int getConta() {
		return conta;
	}
	
	public void setConta(int conta) {
		this.conta = conta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	// Método que realiza o saque
	boolean sacar(double valor) {
		
		if (this.saldo < valor) {
		
			return false;
		}
		else {
			this.saldo = this.saldo - valor;
			return true;
		}
	}
	
	// Método que realiza o depósito
	public boolean depositar(double valor) {
		this.saldo += valor;
		
		return true;
	}
	
	// Método que realiza a transferencia
	public boolean transferir(Conta contadestino, String titulardestino, double valortransf) {
				
		if (sacar(valortransf)) {
			
			if (saldo < valortransf) {
				System.out.println("Saldo insuficiente!");
				
				return true;
				
			}else if (contadestino.getTitular().equals(titulardestino));
			
				return contadestino.depositar(valortransf);
		}
		else{
			System.out.println("Não há conta aberta para" + " " + titulardestino);
			
			return false;
		}
	}	
}
