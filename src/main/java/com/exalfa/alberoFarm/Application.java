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
	public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
		}
	@Override
	public void run(String... args) throws Exception
	{
		int scelta = 0;
		while (scelta != 999)
		{
			System.out.println(" ");
			System.out.println("1 -> inserisci utente");
			System.out.println("2 -> visualizza tutti gli alberi");
			System.out.println("999 -> esci");
			System.out.println(" ");
			Scanner scanner = new Scanner(System.in);
			System.out.println(" -> ");
			scelta = scanner.nextInt();
			switch (scelta)
			{
				case 1:
					System.out.println("nome: ");
					scanner = new Scanner(System.in);
					String nome = scanner.nextLine();
					System.out.println("cognome: ");
					scanner = new Scanner(System.in);
					String cognome = scanner.nextLine();
					System.out.println("codice fiscale: ");
					scanner = new Scanner(System.in);
					String cf = scanner.nextLine();
					insertUtente(nome, cognome, cf);
				break;
				case 2:

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
}
