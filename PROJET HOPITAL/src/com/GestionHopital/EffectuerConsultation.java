package com.GestionHopital;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//import javafx.scene.chart.PieChart.Data;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class EffectuerConsultation extends JFrame{
	private JPanel panelPrincipale = new JPanel();
	private JLabel lPatient, lMatricule, lIcon1, lIcon2, ldate;
	private JComboBox cPatient, cMatricule;
	private JButton bOk, bAnnuler;
	private JPanel panEffectuerConsultation, panIcon, panNumeroPatient, panMatricule, panIcon2, panDate;
	private JTextField tdate;
	//private Data date;
	
	
	public EffectuerConsultation(){
		this.setTitle(" CONSULTER PATIENT");
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
	
	public void confirmConsultation(String date, String Matricule, String NumeroPatient){
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
			
			String requete = "INSERT INTO consultation(`Date`,`Matricule`, `Num_P`)values(?, ?, ?)";
			PreparedStatement prepare = (PreparedStatement) conn.prepareStatement(requete);
			prepare.setString(1, date);
			prepare.setString(2, Matricule);
			prepare.setString(3, NumeroPatient);
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
		
		//Gestion de l'image
		panIcon = new JPanel();
		lIcon1 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img16.PNG"));
		panIcon.add(lIcon1);
		
		//panIcon2 = new JPanel();
		//lIcon2 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img50.PNG"));
		//panIcon2.add(lIcon2);
		
		panMatricule = new JPanel();
		lMatricule = new JLabel("Saisir un Matricule");
		panMatricule.setPreferredSize(new Dimension(220, 60));
		panMatricule.setBorder(BorderFactory.createTitledBorder("Matricule du Medecin"));
		JComboBox cMatricule = new JComboBox(lireMatricule());
		panMatricule.add(lMatricule);
		panMatricule.add(cMatricule);
		
		panNumeroPatient = new JPanel();
		lPatient = new JLabel("Saisie un Numero Patient");
		panNumeroPatient.setPreferredSize(new Dimension(220, 60));
		panNumeroPatient.setBorder(BorderFactory.createTitledBorder("Matricule du Medecin"));
		JComboBox cPatient = new JComboBox(lirePatient());
		panNumeroPatient.add(lPatient);
		panNumeroPatient.add(cPatient);
		
		panDate = new JPanel();
		ldate = new JLabel("Saisir la date");
		panDate.setPreferredSize(new Dimension(200, 70));
		panDate.setBorder(BorderFactory.createTitledBorder("Date Consultation"));
		tdate = new JTextField(20);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		System.out.println(format.format(calendar.getTime()));
		tdate.setText(format.format(calendar.getTime()));
		panDate.add(ldate);
		panDate.add(tdate);
		
		
		
		
		
		
		
		JPanel panControl = new JPanel();
		panControl .setPreferredSize(new Dimension(410, 310));
		JButton bOk = new JButton("Ok");
		bOk.setPreferredSize(new Dimension(200, 60));
		bOk.addActionListener(new ActionListener(){

			@Override
 			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				confirmConsultation((String)tdate.getText(),(String) cMatricule.getSelectedItem(),(String)cPatient.getSelectedItem());
				
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
		content.add(panNumeroPatient);
		content.add(ldate);
		content.add(panControl);
		
		//this.getContentPane().add(panIcon, BorderLayout.WEST);
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(panDate, BorderLayout.SOUTH);	

		
		
		
		
		
		
		
		
		
		/*panelPrincipale.setLayout(null);
		lMatricule = new JLabel("Matricule");
		lMatricule.setBounds(5, 3, 120, 25);
		lPatient = new JLabel(" Numero Patient");
		lPatient.setBounds(5, 35, 120, 25);
		
		cMatricule = new JComboBox(lireMatricule());
		cMatricule.setBounds(130, 3, 120, 25);
		cPatient = new JComboBox(lirePatient());
		cPatient.setBounds(130, 35, 120, 25);
		
		bOk = new JButton("Ok");
		bOk.setBounds(5, 65, 100, 25);
		bOk.addActionListener(new ActionListener(){
			 

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				confirmConsultation((String) cMatricule.getSelectedItem(),(String)cPatient.getSelectedItem());
			}
			
		});
		bAnnuler = new JButton("Annuler");
		bAnnuler.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				
			}
			
		});
		bAnnuler.setBounds(140, 65, 120, 25);
		
		panelPrincipale.setLayout(null);
		panelPrincipale.add(lMatricule);
		panelPrincipale.add(cMatricule);
		panelPrincipale.add(lPatient);
		panelPrincipale.add(cPatient);
		panelPrincipale.add(bOk);
		panelPrincipale.add(bAnnuler);
		
		*/
	}
	protected void EffectuerConsultation(String selectedItem,
			String selectedItem2, String text) {
		// TODO Auto-generated method stub
		
	}
	
	

}

