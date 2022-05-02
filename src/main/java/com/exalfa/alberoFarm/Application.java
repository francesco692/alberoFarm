package com.exalfa.alberoFarm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner
{
	ArrayList<Utente> utenti = new ArrayList<>();
	ArrayList<Albero> alberi = new ArrayList<>();
	public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
		}
	@Override
	public void run(String... args) throws Exception
	{
		alberi.add( new Albero("01", "pino", 20.15));
		alberi.add( new Albero("02", "abete", 40.00));
		alberi.add( new Albero("03", "ciliegio", 06.45));
		alberi.add( new Albero("04", "quercia", 19.99));
		alberi.add( new Albero("05", "leccio", 15.80));


		int scelta = 0;
		while (scelta != 999)
		{
			System.out.println(" ");
			System.out.println("1 -> inserisci utente");
			System.out.println("2 -> visualizza tutti gli alberi");
			System.out.println("3 -> visualizza tutti gli utenti");
			System.out.println("999 -> esci");
			System.out.println(" ");
			Scanner scanner = new Scanner(System.in);
			System.out.print("-> ");
			scelta = scanner.nextInt();
			switch (scelta)
			{
				case 1:
					System.out.print("nome: ");
					scanner = new Scanner(System.in);
					String nome = scanner.nextLine();
					System.out.print("cognome: ");
					scanner = new Scanner(System.in);
					String cognome = scanner.nextLine();
					System.out.print("codice fiscale: ");
					scanner = new Scanner(System.in);
					String cf = scanner.nextLine();
					insertUtente(nome, cognome, cf);
				break;
				case 2:
					stampaAlberi();
				break;
				case 3:
					stampaUtenti();
				break;
			}
		}
	}
	boolean insertUtente (String nome, String cognome, String cf)
	{
		boolean result = true;
		if(utenti.size() == 0)
		{
			utenti.add( new Utente(nome, cognome, cf));
			return result;
		}
		else
		{
			for(Utente item: utenti)
			{
				if(item.getCf().equals(cf))
				{
					result = false;
				}
			}
		}
		if(result)
		{
			utenti.add( new Utente(nome, cognome, cf));
		}
		return result;
	}
	void stampaAlberi()
	{
		for (Albero item : alberi)
		{
			System.out.println("id albero: " + item.getId() + " " + "tipologia: " + item.getTipologia() + " " + "costo: " + item.getCosto() + "€");
		}
	}
	void stampaUtenti()
	{
		for (Utente item: utenti)
		{
			System.out.println("nome: " + item.getNome() + " " + "cognome: " + item.getCognome() + " " + "codice fiscale: " + item.getCf());
		}
	}
}
