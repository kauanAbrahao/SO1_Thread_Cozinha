package view;

import controller.ThreadCozinha;

public class Principal {
	public static void main(String[] args) {
		String nome = "";
		int tempo = 0;
		
		for (int i = 1; i<6; i++) {
			if (i % 2 != 0) {
				nome = "Sopa de Cebola";
				tempo = (int) (Math.random() * 300)+500;
				Thread prato = new ThreadCozinha(i, nome, tempo);
				prato.start();
			}
			else {
				nome = "Lasanha à Bolonhesa";
				tempo = (int) (Math.random() * 600)+600;
				Thread prato = new ThreadCozinha(i, nome, tempo);
				prato.start();
			}
		}
	}

}
