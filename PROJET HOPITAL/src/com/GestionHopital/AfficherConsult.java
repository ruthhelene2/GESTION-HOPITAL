package com.GestionHopital;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class AfficherConsult extends JFrame {
	//String[]title;
		JTable tableau;
				//Object [][] data;
		JPanel fenetre = new JPanel();
		
		
		//private JPanel panelPrincipale = new JPanel();
		private JLabel lMatricule;
		private JComboBox cMatricule;
		private JButton bOk, bAnnuler;
		private JPanel panMatricule;

		
		
		public AfficherConsult(){
			this.setTitle(" Consulter");
			this.setSize(600, 400);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			initcomportment();
			//this.setContentPane(panelPrincipale);
			this.setVisible(true);
			
			
		}
		public String[] lireMatricule(){
			String[] str = null;
			try{
				
				Class.forName("com.mysql.jdbc.Driver");
				
				String bdd = "Votre base des données";
				String url = "jdbc:mysql://localhost/hopital";
				String user = "root";
				String passwd = "";
				// Creation de la connection
				Connection conn = (Connection)DriverManager.getConnection(url,user,passwd);
				
				//Creer un etat de connection( c'est statement qui fait les operations dans la bd)
				// on peu aussi ecrire  Statement state = (Statement)conn.createStatement();
				java.sql.Statement state = conn.createStatement();
				ResultSet result = state.executeQuery("SELECT * FROM consultation");
				// Compte le nombre de ligne de result en se positionant sur le dernier elt 
				result.last();
				//initialiser le tableau avec pour taille le nombre de ligne de result
				str = new String[result.getRow()];
				result.beforeFirst();
				int i = 0;
				while(result.next()){
					str[i] =  result.getString("Matricule"); i++;
				}
				//System.out.println(result.getRow());
				for(i = 0; i< str.length; i++)
					//System.out.println(str[i]);
				
				result.close();
				state.close();
				
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("erreur detecter");
			}
			return str;
			
		}
		
		public void confirmConsultation(String Matricule){
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				
				String bdd = "Votre base des données";
				String url = "jdbc:mysql://localhost/hopital";
				String user = "root";
				String passwd = "";
				Connection conn = (Connection)DriverManager.getConnection(url,user,passwd);
				// on peu aussi ecrire  Statement state = (Statement)conn.createStatement();
				java.sql.Statement state = conn.createStatement();
				
				//String matriculeSaisir = (String) cMatricule.getSelectedItem();
				//System.out.println(matriculeSaisir);
				
				String requete = ("SELECT * FROM consultation WHERE Matricule = ?");
				PreparedStatement prepare = (PreparedStatement) conn.prepareStatement(requete);
				prepare.setString(1, Matricule);
				System.out.println(prepare);
				//permet de gerer l'affichage d'un medecin particuler(ExecuteQuery)
				ResultSet result = prepare.executeQuery(requete);
				
				
				
				//ResultSet result = state.executeQuery("SELECT * FROM prescrire");
				// On recupere les MetaData( donc les attributs ou les champs)
				ResultSetMetaData resultMeta = (ResultSetMetaData) result.getMetaData();
				//initialisation de notre tableau titre
				String[] title = new String[resultMeta.getColumnCount()];
				// Puis on affiche le nom des colonnes c'est avec un tableau
				for(int i = 1; i<= resultMeta.getColumnCount(); i++){
					System.out.println(resultMeta.getColumnName(i));
				title[i-1] = resultMeta.getColumnName(i);
				//Petite manipulation pour obtenir le nombre de ligne
			}
				result.last();
				int rowCount = result.getRow();
				Object[][] data = new Object[rowCount][resultMeta.getColumnCount()];
				//on revient au debut du tableau
				result.beforeFirst();
				int j = 1;
				while(result.next()){
					for(int i = 1; i<= resultMeta.getColumnCount(); i++)
						data[j-1][i-1] = result.getObject(i);
					j++;
				}
				// on ferme tout 
				result.close();
				state.close();
				tableau = new JTable(data, title);
				
				
				
				
				prepare.close();
				state.close();
				
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("erreur detecter");
			}
			
			
			 try{
					// La connection de Java avec la BD commence de CLass.forName et se termine catch  e.printstracktrace 
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
					 Statement state = (Statement)conn.createStatement();
					
					ResultSet result = state.executeQuery("SELECT * FROM consultation WHERE Matricule = '");
					// On recupere les MetaData( donc les attributs ou les champs)
					ResultSetMetaData resultMeta = (ResultSetMetaData) result.getMetaData();
					//initialisation de notre tableau titre
					String[] title = new String[resultMeta.getColumnCount()];
					// Puis on affiche le nom des colonnes c'est avec un tableau
					for(int i = 1; i<= resultMeta.getColumnCount(); i++){
						//System.out.println(resultMeta.getColumnName(i));
					title[i-1] = resultMeta.getColumnName(i);
					//Petite manipulation pour obtenir le nombre de ligne
				}
					result.last();
					int rowCount = result.getRow();
					Object[][] data = new Object[rowCount][resultMeta.getColumnCount()];
					//on revient au debut du tableau
					result.beforeFirst();
					int j = 1;
					while(result.next()){
						for(int i = 1; i<= resultMeta.getColumnCount(); i++)
							data[j-1][i-1] = result.getObject(i);
						j++;
					}
					// on ferme tout 
					result.close();
					state.close();
					tableau = new JTable(data, title);
					
					
				}catch(Exception e){
					e.printStackTrace();
					System.out.println("erreur detecter");
				}
				
				fenetre.setLayout(new BorderLayout());
				fenetre.add(new JScrollPane(tableau), BorderLayout.CENTER);
				


		}
				

		private void initcomportment() {
			panMatricule = new JPanel();
			lMatricule = new JLabel("Saisir un Matricule");
			panMatricule.setPreferredSize(new Dimension(220, 60));
			panMatricule.setBorder(BorderFactory.createTitledBorder("Matricule du Medecin"));
			JComboBox cMatricule = new JComboBox(lireMatricule());
			panMatricule.add(lMatricule);
			panMatricule.add(cMatricule);
			
			
			JPanel panControl = new JPanel();
			panControl .setPreferredSize(new Dimension(410, 310));
			JButton bOk = new JButton("Ok");
			bOk.setPreferredSize(new Dimension(200, 60));
			bOk.addActionListener(new ActionListener(){
				

				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println(cMatricule.getSelectedItem());
					
					// TODO Auto-generated method stub
					confirmConsultation((String) cMatricule.getSelectedItem());
					
					
				}

			});
		
			
			JButton bAnnuler = new JButton("Annuler");
			bAnnuler.setPreferredSize(new Dimension(200, 70));
			 bAnnuler.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					dispose();
				}
				 
			 });
			panControl.add(bOk);
			panControl.add(bAnnuler);
			
			JPanel content = new JPanel();
			content.setPreferredSize(new Dimension(410, 310));
			//content.setBackground(Color.GREEN);
			content.add(panMatricule);
			content.add(panControl);
			
			//this.getContentPane().add(panIcon, BorderLayout.WEST);
			this.getContentPane().add(content, BorderLayout.CENTER);
		}
		 private void initTabbed(){
			 try{
					// La connection de Java avec la BD commence de CLass.forName et se termine catch  e.printstracktrace 
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
					 Statement state = (Statement)conn.createStatement();
					
					ResultSet result = state.executeQuery("SELECT * FROM consultation WHERE Matricule ='"+cMatricule.getSelectedItem()+"'");
					// On recupere les MetaData( donc les attributs ou les champs)
					ResultSetMetaData resultMeta = (ResultSetMetaData) result.getMetaData();
					//initialisation de notre tableau titre
					String[] title = new String[resultMeta.getColumnCount()];
					// Puis on affiche le nom des colonnes c'est avec un tableau
					for(int i = 1; i<= resultMeta.getColumnCount(); i++){
						//System.out.println(resultMeta.getColumnName(i));
					title[i-1] = resultMeta.getColumnName(i);
					//Petite manipulation pour obtenir le nombre de ligne
				}
					result.last();
					int rowCount = result.getRow();
					Object[][] data = new Object[rowCount][resultMeta.getColumnCount()];
					//on revient au debut du tableau
					result.beforeFirst();
					int j = 1;
					while(result.next()){
						for(int i = 1; i<= resultMeta.getColumnCount(); i++)
							data[j-1][i-1] = result.getObject(i);
						j++;
					}
					// on ferme tout 
					result.close();
					state.close();
					tableau = new JTable(data, title);
					
					
				}catch(Exception e){
					e.printStackTrace();
					System.out.println("erreur detecter");
				}
				
				fenetre.setLayout(new BorderLayout());
				fenetre.add(new JScrollPane(tableau), BorderLayout.CENTER);
				

		 }
	

}

