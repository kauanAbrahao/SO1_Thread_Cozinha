package controller;

import java.util.concurrent.Semaphore;

public class ThreadCozinha extends Thread {
	private String nome;
	private int tempo;
	private int id;
	private static Semaphore semaforo = new Semaphore(1);
	
	public ThreadCozinha(int id, String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
		this.id = id;
	}
	
	public void run() {
		System.out.println("O prato #" + id + " " + nome + " foi iniciado!");
		int termina = 0;
		while (termina < 95) {
			termina = termina + (tempo/100);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O prato #" + id + " " + nome + " está " + termina + "% pronto!");
		}
		System.out.println("O prato #" + id + " " + nome + " está pronto... Que delícia!!!!!!!!!!");
		
		
		try {
			semaforo.acquire();
			sleep(50); //deixei um pouco menos de tempo em Sleep para deixar mais bonitinho o resultado
			System.out.println("O prato #" + id + " " + nome + " foi entregue!!! Hurraaay!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

}
