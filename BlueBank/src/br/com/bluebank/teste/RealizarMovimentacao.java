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
 *
 */
public class RealizarMovimentacao {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("transferencia");
		EntityManager manager = factory.createEntityManager();
			
		Conta conta = new Conta();
		
		conta.transferir(conta, "Conta 2", 200);
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Operação realizada com sucesso!");
	}

}
