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

public class Hospitalisation extends JFrame {
	private JPanel panelPrincipale = new JPanel();
	private JLabel lPatient, lDate, lIcon1, lIcon2, lHeure, lIcon3, lSalle;
	private JComboBox  cPatient;
	private JTextField tHeure, tDate, tSalle;
	private JPanel panIcon, panConsult1;
	private JButton bValider, bAnnuler, bDispose, bAfficher;
	
	
	
	public Hospitalisation(){
		this.setTitle("PAVILLON D'HOSPITALISATION ");
		this.setSize(600, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panelPrincipale);
		initcomportment();
		this.setVisible(true);
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

	public void confirmConsultation(String Salle, String cNum_P, String tDate, String tHeure){
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
			
			String requete = "INSERT INTO hospitalisation(`Salle`, `Num_P`, `Date`, `Heure`)values(?, ?, ?, ?)";
			PreparedStatement prepare = (PreparedStatement) conn.prepareStatement(requete);
			prepare.setString(1, Salle);
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
		GridLayout disposition  = new GridLayout(7, 2, 5, 5);
		panConsult1.setLayout(disposition);
		lSalle = new JLabel("SALLE D'HOSPITALISATION");
		tSalle = new JTextField(10);
		
		
		lPatient = new JLabel("NUMERO DU PATIENT");
		cPatient = new JComboBox(lirePatient());
	
		lHeure =new JLabel("HEURE D-ENTREE");
		tHeure = new JTextField(10);
		
		DateFormat forma = new SimpleDateFormat("hh:mm:ss");
		Calendar calenda = Calendar.getInstance();
		System.out.println(forma.format(calenda.getTime()));
		tHeure.setText(forma.format(calenda.getTime()));
		
		lDate = new JLabel("DATE D'ENTREE");
		tDate = new JTextField(10);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		System.out.println(format.format(calendar.getTime()));
		tDate.setText(format.format(calendar.getTime()));
		
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
				FicheHospitalisation fi = new FicheHospitalisation();
				fi.setVisible(true);
				
			}
			
		});

		
		JButton bOk = new JButton("OK");
		bOk.addActionListener(new ActionListener(){
	
				@Override
		 public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			confirmConsultation((String)tSalle.getText(),(String)cPatient.getSelectedItem() ,(String)tDate.getText(), (String)tHeure.getText());
						
		}
				
	});
				
	JButton bAnnuler = new JButton("RESET");
	bAnnuler.addActionListener(new ActionListener(){
	
			@Override
			public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
				cPatient.setSelectedItem("");
				tSalle.setText("");
				
			}
					 
			 });
	Font police = new Font("Tahoma", Font.BOLD, 12);
	lSalle.setFont(police);
	lSalle.setForeground(Color.BLUE);
	lPatient.setFont(police);
	lPatient.setForeground(Color.BLUE);
	lDate.setFont(police);
	lDate.setForeground(Color.BLUE);
	lHeure.setFont(police);
	lHeure.setForeground(Color.BLUE);
	bOk.setFont(police);
	bOk.setForeground(Color.BLUE);
	bAnnuler.setFont(police);
	bAnnuler.setForeground(Color.RED);
	bDispose.setFont(police);
	bDispose.setForeground(Color.RED);
	
	
		panConsult1.add(lSalle);
		panConsult1.add(tSalle);
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

