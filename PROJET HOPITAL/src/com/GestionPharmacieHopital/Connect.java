package com.GestionPharmacieHopital;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.ResultSetMetaData;

public class Connect {

	public static void main(String[] args) {
		try{
			// La connection de Java avec la BD commence de CLass.forName et se termine catch  e.printstracktrace 
			// il n'ya pas statement c'est pour les requetes
			// permet de charger le pilote MySql qui ne change jamais
			Class.forName("com.mysql.jdbc.Driver");
			//Affichage de sa reussite
			System.out.println(" Diver Ok ");
			String bdd = "Votre base des données";
			String url = "jdbc:mysql://localhost/hopital";
			String user = "root";
			String passwd = "";
			// Creation de la connection
			Connection conn = (Connection)DriverManager.getConnection(url,user,passwd);
			System.out.println("Connection Effective");
			
			//Creer un etat de connection( c'est statement qui fait les operations dans la bd)
			// on peu aussi ecrire  Statement state = (Statement)conn.createStatement();
			java.sql.Statement state = conn.createStatement();
			//Insertion des données dans la BD
			String requete = "INSERT INTO medecin(`Matricule`,`Nom_M`)values('20R543', 'MEKOA Etienne')";
			state.executeUpdate(requete);
			//L'objet resulSet contient le resultat de la requette SQL
			// On recupere les enregistrements 
			ResultSet result = state.executeQuery("SELECT * FROM medecin");
			// On recupere les MetaData( donc les attributs ou les champs)
			ResultSetMetaData resultMeta = (ResultSetMetaData) result.getMetaData();
			System.out.println("\n***********************************************");
			// Puis on affiche le nom des colonnes c'est avec un tableau
			for(int i = 1; i<= resultMeta.getColumnCount(); i++)
				System.out.println("\t" +
			resultMeta.getColumnName(i).toUpperCase()+ "\t *");
			System.out.println("\n*************************************************");
			//pour Afficher les enregistrement qui sont des listes chainées on utilise la boucle While
			//le pointeur result.next est un boolean qui dit que 
			//tant que result ne pointe pas sur la derniere liste qui est NULL recupere ses enregistrements
			while(result.next()){
				for(int i = 1; i<= resultMeta.getColumnCount(); i++)
					System.out.println("\t " + result.getObject(i).toString()+   "  \t |");
				System.out.println("\n-----------------------------------------------");
			}
			result.close();
			state.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("erreur detecter");
		}

	}

}
