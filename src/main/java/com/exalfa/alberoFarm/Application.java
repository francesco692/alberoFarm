package com.exalfa.alberoFarm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Application implements CommandLineRunner
{
	ArrayList<Utente> utenti = new ArrayList<>();
	ArrayList<Albero> alberi = new ArrayList<>();
	ArrayList<Acquisto> acquisti = new ArrayList<>();
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
			System.out.println("4 -> ricerca albero per tipologia");
			System.out.println("5 -> acquista un albero");
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
				case 4:
					System.out.print("tipologia -> ");
					scanner = new Scanner(System.in);
					String tipologia = scanner.nextLine();
					findAlbero(tipologia);
				break;
				case 5:
					System.out.print("id albero da acquistare: ");
					scanner = new Scanner(System.in);
					String idAlbero = scanner.nextLine();
					System.out.print("codice fiscale dell'utente: ");
					scanner = new Scanner(System.in);
					String cfP = scanner.nextLine();
					System.out.print("dai un nome al tuo albero: ");
					scanner = new Scanner(System.in);
					String nomeAlbero = scanner.nextLine();
					System.out.print("scegli il luogo dove piantarlo: ");
					scanner = new Scanner(System.in);
					String posizione = scanner.nextLine();
					LocalDate data = LocalDate.now();
					acquistaAlbero(idAlbero, cfP, nomeAlbero, posizione, data);
					scriviFile();
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
	void findAlbero (String tipologia)
	{
		Stream<Albero> alberoStream = alberi.stream();
		ArrayList<Albero> tmp = (ArrayList<Albero>) alberoStream.filter(element -> element.getTipologia().equals(tipologia)).collect(Collectors.toList());
		tmp.forEach(element -> System.out.println(element.getId() + " " + element.getTipologia() + " " + element.getCosto() + "€"));
	}
	boolean acquistaAlbero (String idAlbero, String cfP, String nomeAlbero, String posizione, LocalDate data)
	{
		boolean re = true;
		boolean result1 = true;
		for(Albero item: alberi)
		{
			if (item.getId().equals(idAlbero))
			{
				result1 = true;
				break;
			}
			else
			{
				result1 = false;
			}
		}
		boolean result2 = true;
		for(Utente item1: utenti)
		{
			if (item1.getCf().equals(cfP))
			{
				result2 = true;
				break;
			}
			else
			{
				result2 = false;
			}
		}
		if (result1 && result2)
		{
			boolean result = true;
			if (alberi.size() == 0)
			{
				acquisti.add( new Acquisto(idAlbero, cfP, nomeAlbero, posizione, data));
				return result;
			}
			else
			{
				for (Acquisto item2: acquisti)
				{
					if(item2.getIdAlbero().equals(idAlbero))
					{
						result = false;
					}
				}
			}
			if(result)
			{
				acquisti.add( new Acquisto(idAlbero, cfP, nomeAlbero, posizione, data));
			}
			return result;
		}
		return re;
	}
	void scriviFile()
	{
		try
		{
			FileWriter myWriter = new FileWriter("acquisto.txt");
			for (Acquisto item: acquisti)
			{
				myWriter.write(item.getIdAlbero() + " " + item.getCfP() + " " + item.getNomeAlbero() + " " + item.getPosizione() + " " + item.getData());
				myWriter.close();
			}
			System.out.println("Successfully wrote to the file.");
		}
		catch (IOException e)
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
