package com.GestionHopital;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class RendezVous extends JFrame {
	private JPanel panelPrincipale = new JPanel();
	private JLabel lMatricule, lPatient, lDate, lIcon1, lIcon2, lHeure, lIcon3;
	private JComboBox cMatricule, cPatient;
	private JTextField tHeure, tDate;
	private JPanel panIcon, panConsult1;
	private JButton bValider, bAnnuler, bDispose, bAfficher;
	
	
	
	public RendezVous(){
		this.setTitle("RENDEZ-VOUS ");
		this.setSize(600, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panelPrincipale);
		initcomportment();
		this.setVisible(true);
	}
	
	public String[] lireMatricule(){
		String[] str = null;
		try{
			
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
			ResultSet result = state.executeQuery("SELECT Matricule FROM medecin");
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
				System.out.println(str[i]);
			
			result.close();
			state.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("erreur detecter");
		}
		return str;
		
	}
	public String[] lirePatient(){
		String[] str = null;
		try{
			
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
			Statement state = (Statement) conn.createStatement();
			ResultSet result = state.executeQuery("SELECT Num_P FROM patient");
			// Compter le nombre de ligne du result en se positionant sur le dernier elt 
			result.last();
			//initialiser le tableau avec pour taille le nombre de ligne de result
			str = new String[result.getRow()];
			result.beforeFirst();
			int i = 0;
			while(result.next()){
				str[i] =  result.getString("Num_P"); i++;
			}
			//System.out.println(result.getRow());
			for(i = 0; i< str.length; i++)
				System.out.println(str[i]);
			
			result.close();
			state.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("erreur detecter");
		}
		return str;	
	}

	public void confirmConsultation(String cMatricule, String cNum_P, String tDate, String tHeure){
		try{
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
			// on peu aussi ecrire  Statement state = (Statement)conn.createStatement();
			java.sql.Statement state = conn.createStatement();
			
			String requete = "INSERT INTO rendezvous(`Matricule`, `Num_P`, `Date`, `Heure`)values(?, ?, ?, ?)";
			PreparedStatement prepare = (PreparedStatement) conn.prepareStatement(requete);
			prepare.setString(1, cMatricule);
			prepare.setString(2, cNum_P);
			prepare.setString(3, tDate);
			prepare.setString(4, tHeure);
			System.out.println(prepare);
			prepare.executeUpdate();
			prepare.close();
			state.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("erreur detecter");
		}

		
	}
	

	private void initcomportment() {
		// TODO Auto-generated method stub
		
		//Gestion de l'image
	
		panIcon = new JPanel();
		panIcon.setLayout(new BorderLayout());
		lIcon1 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img35.PNG"));
		lIcon2 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img32.PNG"));
		lIcon3 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img34.PNG"));
		panIcon.add(lIcon1, BorderLayout.WEST);
		panIcon.add(lIcon2, BorderLayout.CENTER);
		panIcon.add(lIcon3, BorderLayout.EAST);
				
		panConsult1 = new JPanel();
		GridLayout disposition  = new GridLayout(6, 2, 5, 5);
		panConsult1.setLayout(disposition);
		lMatricule = new JLabel("MATRICULE MEDECIN");
		cMatricule = new JComboBox(lireMatricule());
		
		lPatient = new JLabel("NUMERO DU PATIENT");
		cPatient = new JComboBox(lirePatient());
	
		lHeure =new JLabel("HEURE DU RENDEZ-VOUS");
		tHeure = new JTextField(10);
		
		DateFormat forma = new SimpleDateFormat("hh:mm:ss");
		Calendar calenda = Calendar.getInstance();
		System.out.println(forma.format(calenda.getTime()));
		tHeure.setText(forma.format(calenda.getTime()));
		
		lDate = new JLabel("DATE DU RENDEZ-VOUS");
		tDate = new JTextField(10);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		System.out.println(format.format(calendar.getTime()));
		tDate.setText(format.format(calendar.getTime()));

		
		JButton bOk = new JButton("OK");
		bDispose = new JButton("CANCEL");
		bDispose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		});
		bAfficher = new JButton("DISPLAY");
		bAfficher.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FicheRendezVous fich = new FicheRendezVous();
				fich.setVisible(true);
				
			}
			
		});
		Font police = new Font("Tahoma", Font.BOLD, 12);
		lMatricule.setFont(police);
		lMatricule.setForeground(Color.BLUE);
		lPatient.setFont(police);
		lPatient.setForeground(Color.BLUE);
		lHeure.setFont(police);
		lHeure.setForeground(Color.BLUE);
		lDate.setFont(police);
		lDate.setForeground(Color.BLUE);
		bOk.setFont(police);
		bOk.setForeground(Color.green);
		bDispose.setFont(police);
		bDispose.setForeground(Color.RED);
		bOk.addActionListener(new ActionListener(){
	
				@Override
		 public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			confirmConsultation((String) cMatricule.getSelectedItem(),(String)cPatient.getSelectedItem() ,(String)tDate.getText(), (String)tHeure.getText());
						
		}
				
	});
				
	 bAnnuler = new JButton("RESET");
	bAnnuler.setFont(police);
	bAnnuler.setForeground(Color.RED);
	 bAnnuler.addActionListener(new ActionListener(){
	
			@Override
			public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
				cMatricule.setSelectedItem("");
				cPatient.setSelectedItem("");
		
					}
					 
			 });
		panConsult1.add(lMatricule);
		panConsult1.add(cMatricule);
		panConsult1.add(lPatient);
		panConsult1.add(cPatient);
		panConsult1.add(lDate);
		panConsult1.add(tDate);
		panConsult1.add(lHeure);
		panConsult1.add(tHeure);
		panConsult1.add(bOk);
		panConsult1.add(bAnnuler);
		panConsult1.add(bDispose);
		panConsult1.add(bAfficher);
		panelPrincipale.setLayout(new BorderLayout());
		panelPrincipale.add(panIcon, BorderLayout.SOUTH);
		panelPrincipale.add(panConsult1, BorderLayout.NORTH);

	}
}
