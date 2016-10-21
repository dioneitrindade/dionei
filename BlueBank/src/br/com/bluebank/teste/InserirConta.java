/**
 * 
 */
package br.com.bluebank.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bluebank.modelo.Conta;

/**
 * @author Dionei Trindade
 * Data: 20/10/2016
 * Projeto de Tranferência Bancária
 * Inserir Conta bancaria para transferência
 */
public class InserirConta {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("transferencia");
		EntityManager manager = factory.createEntityManager();
		
		Conta conta = new Conta();
				
		conta.setTitular("Conta 2");
		conta.setAgencia(456);
		conta.setConta(789012);
		conta.setSaldo(100);		
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Conta gravada com sucesso!");
	}
}
