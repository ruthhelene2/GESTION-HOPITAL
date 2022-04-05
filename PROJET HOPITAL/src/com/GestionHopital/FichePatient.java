package com.GestionHopital;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class FichePatient extends JFrame {
	//String[]title;
		JTable tableau;
		//Object [][] data;
		JPanel fenetre = new JPanel();
		private JPanel panIcon;
		private JLabel lIcon, lIcon2, lIcon3;
		private JButton bDispose;
		
		public FichePatient(){
			this.setTitle("FICHE PATIENT");
			this.setSize(500, 300);
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setContentPane(fenetre);
			initComportment();
			this.setVisible(true);
			
		}
		private void initComportment() {
			// TODO Auto-generated method stub
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
				System.out.println("Connection Effective");
				
				//Creer un etat de connection( c'est statement qui fait les operations dans la bd)
				// On peut aussi ecrire java.sql.Statement state = conn.createStatement();
				 Statement state = (Statement)conn.createStatement();
				//Insertion des données dans la BD
				//String requete = "INSERT INTO medecin(`Matricule`,`Nom_M`)values('20S1586', 'AKOBO Marthe')";
				//state.executeUpdate(requete);
				//L'objet resulSet contient le resultat de la requette SQL
				// On recupere les enregistrements 
				ResultSet result = state.executeQuery("SELECT * FROM patient");
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
				
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("erreur detecter");
			}
			bDispose = new JButton("CANCEL");
			Font pol = new Font("Tahoma", Font.BOLD, 20);
			bDispose.setFont(pol);
			bDispose.setForeground(Color.MAGENTA);
			bDispose.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					dispose();
					
				}
				
			});
			panIcon = new JPanel();
			panIcon.setLayout(new BorderLayout());
			//lIcon = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img2.PNG"));
			lIcon2 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img15.PNG"));
			lIcon3 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img26.PNG"));
			panIcon.add(bDispose, BorderLayout.WEST);
			panIcon.add(lIcon3, BorderLayout.CENTER);
			panIcon.add(lIcon2, BorderLayout.EAST);
			
			fenetre.setLayout(new BorderLayout());
			fenetre.add(new JScrollPane(tableau), BorderLayout.CENTER);
			fenetre.add(panIcon, BorderLayout.NORTH );

		}
		
	

}

