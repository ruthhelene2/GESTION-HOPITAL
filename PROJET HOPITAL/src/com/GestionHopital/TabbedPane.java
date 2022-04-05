package com.GestionHopital;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TabbedPane extends JFrame{
	private JPanel panelPrincipale = new JPanel();
	private JPanel panAccueil, panDirecteur, panAide, panMedecin, panInfirmier, panPatient, panBouttonDirecteur, panButtonMedecin, pButtonInfirmier, panButtonPatient ;
	private JTabbedPane onglets;
	private JLabel lBienvenu, lArrive, lInfirmier, lPat, lPatient;
	
	private JButton bAjoutMedecin, bAjoutInfirmier, bAjoutConsulterPlaning;
	private JButton bEffectuerConsultation, bPrescrireMedicament,bConsulterPlaning , bRendevous ;
	private JButton bEnregistrer, bHospitaliser, bExamen, bPharmacie;
	private JButton bConsulterPharmacie, bConsulterPresciption, bConsulterRendevous ;
	private JPanel panIcon1, panIcon2, panBienvenu1, panBienvenu2, panDirecteur1, panDirecteur2, panBienvenu4;
	private JLabel lIcon1, lIcon2, lIcon3, lIcon4, lIcon5, lIcon6, lIcon7, lIcon8, lIcon9, lIcon10, lIcon11, lIcon12 ;
	private JLabel lBienvenu1, lBienvenu2, lBienvenu3, lBienvenu4, lBienvenu5, lBienvenu6;
	private JPanel panMedecin1, panMedecin2, panMedecin3, panButtonMedecin2, panAide1;
	private JPanel panInfirmier1, panInfirmier2, panInfirmier3;
	private JLabel lBienvenu7, lBienvenu8, lBienvenu9, lBienvenu10;
	private JPanel panPatient1, panPatient2, panPatient3;
	private JPanel panPubicite;
	private JLabel lIcon13, lIcon14, lIcon15, lIcon16;
	private JLabel  lPub2, lPub3, lPub4, lPub5, lPub6, lPub7, lPub8, lPub9;
	
	
	public TabbedPane(){
		this.setTitle("Les TabbedPane");
		this.setSize(900, 700);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panelPrincipale);
		initComportment();
		this.setVisible(true);
	}

	private void initComportment() {
		// TODO Auto-generated method stub
		onglets = new JTabbedPane();
		panAccueil = new JPanel();
		panDirecteur = new JPanel();
		panMedecin = new JPanel();
		panInfirmier = new JPanel();
		panPatient = new JPanel();
		panAide = new JPanel();
		panPubicite = new JPanel();
		onglets.setBounds(100, 50, 700, 600);
		onglets.add("ACCUEIL", panAccueil);
		onglets.add("DIRECTEUR", panDirecteur);
		onglets.add("MEDECIN", panMedecin);
		onglets.add("INFIRMIER", panInfirmier);
		onglets.add("PATIENT", panPatient);
		onglets.add("SERVICES OFFERT", panPubicite);
		onglets.add("INFORMATION SUR L'HOPITAL", panAide);
		
		
		//Gestion PanAcceuil
		panBienvenu1 = new JPanel();
		Font police = new Font("Tahoma", Font.BOLD, 24);
		Font pol = new Font("ALGERIAN", Font.ITALIC, 32);
		lBienvenu1 = new JLabel("WELCOME TO RUTHY'S HOSPITAL");
		lBienvenu1.setFont(pol);
		lBienvenu1.setForeground(Color.MAGENTA);
		panIcon1 = new JPanel();
		lIcon1 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img1.PNG"));
		panBienvenu2 = new JPanel();
		lBienvenu2 = new JLabel("YOUR HEALTH IS OUR PRIORITY");
		lBienvenu2.setFont(police);
		lBienvenu2.setForeground(Color.BLUE);
		panBienvenu1.add(lBienvenu1);
		panBienvenu2.add(lBienvenu2);
		panIcon1.add(lIcon1);
		
		
		//Gestion de PanDirecteur
		panDirecteur1 = new JPanel();
		panDirecteur2 = new JPanel();
		panBouttonDirecteur = new JPanel();
		panDirecteur1.setLayout(new BorderLayout());
		lIcon2 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img2.PNG"));
		lIcon4 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img4.PNG"));
		lBienvenu3 = new JLabel("WELCOME DIRECTOR");
		lBienvenu3.setHorizontalAlignment(JLabel.CENTER);
		Font pal = new Font("ALGERIAN", Font.ITALIC, 50);
		lBienvenu3.setFont(pal);
		lBienvenu3.setForeground(Color.BLUE);
		panDirecteur1.add(lIcon2, BorderLayout.EAST);
		panDirecteur1.add(lBienvenu3, BorderLayout.CENTER);
		panDirecteur1.add(lIcon4, BorderLayout.WEST);
		//GridLayout disposition  = new GridLayout(5, 1, 1, 1);
		//panBouttonDirecteur.setLayout(disposition);
		Font poule = new Font("Tahoma", Font.BOLD, 24);
		bAjoutMedecin = new JButton("ADD DOCTOR");
		bAjoutMedecin.setFont(poule);
		bAjoutMedecin.setForeground(Color.ORANGE);
	
		bAjoutMedecin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AjoutMedecin a = new AjoutMedecin();
				a.setVisible(true);
				
			}
			
		});
		bAjoutMedecin.setPreferredSize(new Dimension(198, 70));
		bAjoutInfirmier = new JButton("ADD NURSE");
		bAjoutInfirmier.setFont(poule);
		bAjoutInfirmier.setForeground(Color.ORANGE);
		bAjoutInfirmier.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AjoutInfirmier i = new AjoutInfirmier();
				i.setVisible(true);
				
			}
			
		});
		bAjoutInfirmier.setPreferredSize(new Dimension(198, 70));
		bAjoutConsulterPlaning = new JButton("SAVE PLANING");
		bAjoutConsulterPlaning.setFont(poule);
		bAjoutConsulterPlaning.setForeground(Color.ORANGE);
		bAjoutConsulterPlaning.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PlaningConsultation plan = new PlaningConsultation();
				plan.setVisible(true);
				
				
			}
			
		});
		
		bAjoutConsulterPlaning.setPreferredSize(new Dimension(198, 70));
		
		lIcon3 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img3.PNG"));
		panBienvenu4 = new JPanel();
		lBienvenu4 = new JLabel("We must respect the distancing measures");
		lBienvenu4.setHorizontalAlignment(JLabel.CENTER);
		lBienvenu4.setFont(police);
		lBienvenu4.setForeground(Color.MAGENTA);
		panBouttonDirecteur.add(bAjoutMedecin);
		panBouttonDirecteur.add(bAjoutInfirmier);
		panBouttonDirecteur.add(bAjoutConsulterPlaning);
		panBouttonDirecteur.add(lIcon3);
		
		
		//Gestion de panMedecin
		panMedecin1 = new JPanel();
		lBienvenu5 = new JLabel("RUTHY CLINIC DOCTORS");
		lBienvenu5.setFont(pol);
		lBienvenu5.setForeground(Color.MAGENTA);
		//lBienvenu5.setBackground(Color.red);
		panMedecin1.setLayout(new BorderLayout());
		lIcon5 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img5.PNG"));
		lIcon6 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img6.PNG"));
		panMedecin1.add(lIcon5, BorderLayout.WEST);
		panMedecin1.add(lBienvenu5, BorderLayout.CENTER);
		panMedecin1.add(lIcon6, BorderLayout.EAST);
		
		panButtonMedecin = new JPanel();
		GridLayout disposition  = new GridLayout(4, 1, 17, 17);
		panButtonMedecin.setLayout(disposition);
		bEffectuerConsultation = new JButton("CARRY OUT CONSULTATION");
		Font poul = new Font("Tahoma", Font.BOLD, 12);
		bEffectuerConsultation.setFont(poul);
		bEffectuerConsultation.setForeground(Color.BLUE);
		bEffectuerConsultation.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EnregistrerConsultation en = new EnregistrerConsultation();
				en.setVisible(true);
				
			}
			
		});
		
		
		bEffectuerConsultation.setPreferredSize(new Dimension(100, 70));
		bConsulterPlaning = new JButton("PLANING CONSULTING");
		bConsulterPlaning.setFont(poul);
		bConsulterPlaning.setForeground(Color.BLUE);
		bConsulterPlaning.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AfficheFichePlaning aff = new AfficheFichePlaning();
				aff.setVisible(true);
				
			}
			
		});
		
		
		bPrescrireMedicament = new JButton("DROG PRESCRIBE");
		bPrescrireMedicament .setFont(poul);
		bPrescrireMedicament .setForeground(Color.BLUE);
		bPrescrireMedicament.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PrescriptionMedicament presc = new PrescriptionMedicament();
				presc.setVisible(true);
				
			}
			
		});
		bRendevous = new JButton("APPOITMENT");
		bRendevous.setFont(poul);
		bRendevous.setForeground(Color.BLUE);
		bRendevous.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				RendezVous rend = new RendezVous();
				rend.setVisible(true);
				
			}
			
		});
		panButtonMedecin.add(bEffectuerConsultation);
		panButtonMedecin.add(bConsulterPlaning);
		panButtonMedecin.add(bPrescrireMedicament);
		panButtonMedecin.add(bRendevous);
		panMedecin2 = new JPanel();
		lIcon7 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img7.PNG"));
		panMedecin2.add(lIcon7);
		panMedecin3 = new JPanel();
		lBienvenu6 = new JLabel("SURGERY ROOM");
		//Font poli = new Font("Tahoma", Font.BOLD, 24);
		lBienvenu6.setFont(police);
		lBienvenu6.setForeground(Color.GREEN);
		panMedecin3.add(lBienvenu6);
		
		
		
		//Gestion PanInfirmier
		//pButtonInfirmier.setLayout(new BorderLayout());
		panInfirmier1 = new JPanel();
		panInfirmier1.setLayout(new BorderLayout());
		lBienvenu7 = new JLabel("HERE THE PATIENT IS KING");
		Font pola = new Font("Tahoma", Font.BOLD, 28);
		lBienvenu7.setFont(pola);
		lBienvenu7.setForeground(Color.BLUE);
		lBienvenu7.setHorizontalAlignment(JLabel.CENTER);
		lIcon8 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img8.PNG"));
		panInfirmier1.add(lIcon8, BorderLayout.WEST);
		panInfirmier1.add(lBienvenu7, BorderLayout.CENTER);
		pButtonInfirmier = new JPanel();
		bEnregistrer = new JButton("SAVE PATIENT");
		bEnregistrer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EnregistrerPatient e = new EnregistrerPatient();
				e.setVisible(true);
				
			}
			
		});
		
		Font poli = new Font("Tahoma", Font.BOLD, 20);
		bEnregistrer.setPreferredSize(new Dimension(200, 70));
		bEnregistrer.setForeground(Color.RED);
		bEnregistrer.setFont(poli);
		bExamen = new JButton("EXAMINATION");
		bExamen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Examination exam = new Examination();
				exam.setVisible(true);
				
			}
			
		});
		bExamen.setFont(poli);
		bExamen.setPreferredSize(new Dimension(200, 70));
		bExamen.setForeground(Color.RED);
		bHospitaliser = new JButton("HOSPILTALISATION");
		bHospitaliser.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Hospitalisation hosp = new Hospitalisation();
				hosp.setVisible(true);
				
				
			}
			
		});
		bHospitaliser.setFont(poli);
		bHospitaliser.setForeground(Color.RED);
		bHospitaliser.setPreferredSize(new Dimension(200, 70));
		pButtonInfirmier.add(bEnregistrer);
		pButtonInfirmier.add(bExamen);
		pButtonInfirmier.add(bHospitaliser);
		panInfirmier2 = new JPanel();
		lIcon9 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img9.PNG"));
		lIcon10 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img10.PNG"));
		panInfirmier2.add(lIcon9, BorderLayout.WEST);
		panInfirmier2.add(lIcon10, BorderLayout.EAST);
		panInfirmier3 = new JPanel();
		lBienvenu8 = new JLabel("WELCOME TO INTENSIVE CARE AND NEONATOLOGIE");
		lBienvenu8.setFont(poli);
		lBienvenu8.setForeground(Color.BLUE);
		lBienvenu8.setHorizontalAlignment(JLabel.CENTER);
		panInfirmier3.add(lBienvenu8);
		
		
		//Gestion de panPatient
		panPatient1 = new JPanel();
		lBienvenu9 = new JLabel("PRIORITY FOR PREGNANT WOMEN, OLD PEOPLE");
		lIcon11 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img11.PNG"));
		lIcon12 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img12.PNG"));
		Font polo = new Font("Tahoma", Font.BOLD, 16);
		lBienvenu9.setFont(polo);
		lBienvenu9.setForeground(Color.BLUE);
		lBienvenu9.setHorizontalAlignment(JLabel.CENTER);
		panPatient1.add(lIcon11, BorderLayout.WEST);
		panPatient1.add(lBienvenu9, BorderLayout.CENTER);
		panPatient1.add(lIcon12, BorderLayout.EAST);
		panButtonPatient = new JPanel();
		bConsulterPresciption = new JButton("PRESCRIPTION CONSULT");
		bConsulterPresciption.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FichePrescription ficha = new FichePrescription();
				ficha.setVisible(true);
				
			}
			
		});
		bConsulterPresciption.setPreferredSize(new Dimension(227, 70));
		bConsulterPresciption.setForeground(Color.RED);
		bConsulterPresciption.setFont(poli);
		bConsulterPharmacie = new JButton("PHARMACY CONSULT");
		bConsulterPharmacie.setFont(poli);
		bConsulterPharmacie.setPreferredSize(new Dimension(227, 70));
		bConsulterPharmacie.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ConsulterPharmacie pharma = new ConsulterPharmacie();
				pharma.setVisible(true);
				
			}
			
		});
		bConsulterPharmacie.setForeground(Color.RED);
		bConsulterRendevous = new JButton("APPOINTMENT CONSULT");
		bConsulterRendevous.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FicheRendezVous rendez = new FicheRendezVous();
				rendez.setVisible(true);
				
			}
			
		});
		bConsulterRendevous.setFont(poli);
		bConsulterRendevous.setPreferredSize(new Dimension(227, 70));
		bConsulterRendevous.setForeground(Color.RED);
		panButtonPatient.add(bConsulterPresciption);
		panButtonPatient.add(bConsulterPharmacie);
		panButtonPatient.add(bConsulterRendevous);
		panPatient2 = new JPanel();
		lIcon13 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img13.PNG"));
		panPatient2.add(lIcon13, BorderLayout.EAST);
		
		
		
		//Gestion de panPublicitaire
		JPanel panPub = new JPanel();
		panPub.setLayout(new BorderLayout());
		JPanel panPub1 = new JPanel();
		JPanel panPub2 = new JPanel();
		JPanel panPub3 = new JPanel();
		Font poto = new Font("ALGERIAN", Font.ITALIC, 24);
		Font poni = new Font("Tahoma", Font.BOLD, 18);
		JLabel lPub1 = new JLabel("DEAR PATIENTS, HERE ARE THE DIFFRENTS SEVICES WE OFFER ");
		lPub1.setFont(poto);
		lPub1.setForeground(Color.MAGENTA);
		panPub1.add(lPub1);

		GridLayout dispos  = new GridLayout(4, 2, 10, 10);
		panPub2.setLayout(dispos);
		 lPub2 = new JLabel("GENERLISTE");
		 lPub3 = new JLabel("PEDIATRIE");
		 lPub4 = new JLabel("GYNECOLOGIE");
		 lPub5 = new JLabel("NEONATOLOGIE");
		 lPub6 = new JLabel("ACCOUCHEMENT");
		 lPub7 = new JLabel("RHUMATOLOGIE");
		 lPub8 = new JLabel("OSTEOPROSE");
		 lPub9 = new JLabel("GASTRO-ENTEROLOGUE");
		
		
		
		//panPub3.setLayout(new BorderLayout(null));
		JLabel lIconPub2 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img63.PNG"));
		JLabel lIconPub3 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img62.PNG"));
		//JLabel lIconPub4 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img63.PNG"));
		/*JLabel lIconPub5 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img40.PNG"));
		JLabel lIconPub6 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img48.PNG"));
		JLabel lIconPub7 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img42.PNG"));
		JLabel lIconPub8 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img41.PNG"));
		JLabel lIconPub9 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img48.PNG"));
		JLabel lIconPub10 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img44.PNG"));
		*/
		
		lPub2.setFont(poni);
		lPub3.setFont(poni);
		lPub4.setFont(poni);
		lPub5.setFont(poni);
		lPub6.setFont(poni);
		lPub7.setFont(poni);
		panPub2.add(lPub2);
		panPub2.add(lPub3);
		panPub2.add(lPub4);
		panPub2.add(lPub5);
		panPub2.add(lPub6);
		panPub2.add(lPub7);
		panPub2.add(lPub8);
		lPub8.setFont(poni);
		panPub2.add(lPub9);
		lPub9.setFont(poni);
		
		panPub3.add(lIconPub2);
		panPub3.add(lIconPub3);
		//panPub3.add(lIconPub4);
		/*panPub3.add(lIconPub5);
		panPub3.add(lIconPub6);
		panPub3.add(lIconPub7);
		panPub3.add(lIconPub8);
		panPub3.add(lIconPub9);
		panPub3.add(lIconPub10);*/
		
		
	
	
		
		
		
		
		
		//Gestion panAide
		panAide1 = new JPanel();
		panAide1.setLayout(new BorderLayout());
		Font polin = new Font("Tahoma", Font.BOLD, 18);
		JLabel lAide1 = new JLabel("	La clinic RUTHY est situé à Douala  BONAPRISO face GLACIER MODERNE");
		lAide1.setFont(polin);
		JLabel lAide2 = new JLabel("Elle à un service de Néonatologie, de Pédiatrique et Obstétrique,");
		lAide2.setFont(polin);
		JLabel lAide3 = new JLabel("de Chirugie et de de Gynécologie. La priorité est donné aux patients");
		lAide3.setFont(polin);
		panAide1.add(lAide1, BorderLayout.NORTH);
		panAide1.add(lAide2, BorderLayout.CENTER);
		panAide1.add(lAide3, BorderLayout.SOUTH);
		
		
	
		
		
		
		panAccueil.setLayout(new BorderLayout());
		panAccueil.add(panBienvenu1, BorderLayout.NORTH);
		panAccueil.add(panIcon1, BorderLayout.WEST);
		panAccueil.add(panBienvenu2, BorderLayout.SOUTH);
		
		panDirecteur.setLayout(new BorderLayout());
		panDirecteur.add(panDirecteur1, BorderLayout.NORTH);
		panDirecteur.add(panBouttonDirecteur, BorderLayout.CENTER);
		panDirecteur.add(lBienvenu4, BorderLayout.SOUTH);
		
		panMedecin.add(panMedecin1, BorderLayout.NORTH);
		panMedecin.add(panButtonMedecin, BorderLayout.WEST);
		panMedecin.add(panMedecin2, BorderLayout.CENTER);
		panMedecin.add(panMedecin3, BorderLayout.SOUTH);
		panInfirmier.add(panInfirmier1, BorderLayout.NORTH);
		panInfirmier.add(pButtonInfirmier, BorderLayout.CENTER);
		panInfirmier.add(panInfirmier2, BorderLayout.CENTER);
		panInfirmier.add(panInfirmier3, BorderLayout.CENTER);
		
		panPatient.add(panPatient1,BorderLayout.NORTH );
		panPatient.add(panButtonPatient,BorderLayout.CENTER );
		panPatient.add(panPatient2,BorderLayout.EAST);
		panAide.add(panAide1,BorderLayout.EAST);
		
		panPubicite.setLayout(new BorderLayout());
		panPubicite.add(panPub1, BorderLayout.NORTH);
		panPubicite.add(panPub2, BorderLayout.CENTER);
		panPubicite.add(panPub3, BorderLayout.SOUTH);
		
		
		panelPrincipale.setLayout(null);
		panelPrincipale.add(onglets);
		
		
		
		
		 
		 
		 
		 
		 
		 
		
		
		
		
		//Gestion PanDirecteur
		
		
		/* de PDirecteur
		panIcon1 = new JPanel();
		//panIcon1.setLayout(new BorderLayout());
		lClinic = new JLabel("HOSPITAL HERE");
		//lClinic.setBounds(100, 30, 110, 25);
		panIcon1.setLayout(null);
		panIcon1.setBounds(100, 100, 275, 400);
		lIcon1 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/img6.PNG"));
		lIcon1.setLayout(null);
		lIcon1.setBounds(1, 1, 260, 70);
		lIcon7 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/img7.PNG"));
		lIcon7.setBounds(0, 100, 275, 300);
		lIcon8 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/img8.PNG"));
		lIcon8.setBounds(1, 100, 260, 70);
		panIcon1.add(lClinic);
		panIcon1.add(lIcon1);
		panIcon1.add(lIcon8);
		
		Font police = new Font("Tahoma", Font.BOLD, 24);
		lBienvenu = new JLabel("WELCOME DIRECTOR");
		lBienvenu.setFont(police);
		lBienvenu.setForeground(Color.MAGENTA);
		lBienvenu.setHorizontalAlignment(JLabel.CENTER);
		lBienvenu.setLayout(null);
		lBienvenu.setLayout(new BorderLayout());
		lBienvenu.setBounds(5, 3, 400, 25);
		bAjoutInfirmier = new JButton("ADD NURSE");
		bAjoutInfirmier.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AjoutInfirmier i = new AjoutInfirmier();
				i.setVisible(true);
				
			}
			
		});
		
		bAjoutInfirmier.setBounds(5, 35, 110, 25);		
		bAjoutMedecin = new JButton("ADD DOCTOR");
		bAjoutMedecin.setBounds(5, 3, 110, 25);
		bAjoutMedecin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AjoutMedecin v = new AjoutMedecin();
				v.setVisible(true);
			}	
		});
		bAjoutConsulterPlaning = new JButton("PLANING CONSULTING");
		bAjoutConsulterPlaning.setBounds(5, 65, 110, 25);
		bAjoutConsulterPlaning.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PlaningConsultation p = new PlaningConsultation();
				p.setVisible(true);
				
			}
			
		});
		*/
		/*panBouttonDirecteur = new JPanel();
		panBouttonDirecteur.setLayout(new BorderLayout());
		panBouttonDirecteur.setLayout(null);
		panBouttonDirecteur.setBounds(1, 35, 160, 300);
		
		panBouttonDirecteur.add(bAjoutMedecin);
		panBouttonDirecteur.add(bAjoutInfirmier);
		panBouttonDirecteur.add(bAjoutConsulterPlaning);
		panBouttonDirecteur.add(lIcon7);
		
		panDirecteur.setLayout(null);
		panDirecteur.add(lBienvenu);
		panDirecteur.add(panBouttonDirecteur);
		panDirecteur.add(panIcon1);
		
		//Getion de panMedecin
		panIcon2 = new JPanel();
		panIcon2.setLayout(null);
		panIcon2.setBounds(165, 35, 325, 300);
		lIcon9 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/img13.PNG"));
		lIcon9.setBounds(1, 35, 290, 170);
		panIcon2.add(lIcon9);
		
		lArrive = new JLabel("PERMANENT DOCTOR");
		//Font police = new Font("Tahoma", Font.BOLD, 24);
		lArrive.setFont(police);
		lArrive.setHorizontalAlignment(JLabel.CENTER);
		lArrive.setBackground(Color.BLACK);
		lArrive.setForeground(Color.MAGENTA);
		lArrive.setBounds(5, 3, 400, 25);
		
		//pour PBouttonMedecin
		bEffectuerConsultation = new JButton("DO CONSULTATION");
		bEffectuerConsultation.setBounds(5, 15, 130 , 25);
		bEffectuerConsultation.setForeground(Color.BLUE);
		JButton bConsulterPlaning = new JButton("PLANING CONSULTING");
		bConsulterPlaning.setBounds(5, 50, 130, 25);
		bConsulterPlaning.setForeground(Color.BLUE);
		bPrescrireMedicament = new JButton("DROG PRESCRIPTION");
		bPrescrireMedicament.setBounds(5, 80, 130, 25);
		bPrescrireMedicament.setForeground(Color.BLUE);
		bRendevous = new JButton("RENDEZ-VOUS");
		bRendevous.setBounds(5, 110, 130, 25);
		bRendevous.setForeground(Color.BLUE);
		
		bValider = new JButton("VALIDER");
		bValider.setForeground(Color.RED);
		bValider.setBounds(5, 140, 130, 25);
		bAnnuler = new JButton("ANNULER");
		bAnnuler.setBounds(5, 170, 130, 25);
		bAnnuler.setForeground(Color.RED);
		
		panButtonMedecin = new JPanel();
		panButtonMedecin.setBounds(5, 35, 200, 300);
		panButtonMedecin.add(bEffectuerConsultation);
		panButtonMedecin.add(bConsulterPlaning);
		panButtonMedecin.add(bPrescrireMedicament);
		panButtonMedecin.add(bRendevous);
		panButtonMedecin.add(bValider);
		panButtonMedecin.add(bAnnuler);
		
		panButtonMedecin.setLayout(null);
		panMedecin.setLayout(null);
		panMedecin.add(lArrive);
		panMedecin.add(panButtonMedecin);
		panMedecin.add(panIcon2);
		
		
		//Gestion Infirmier
		
		
		lInfirmier = new JLabel("CABINET DES SOINS INFIRMIERS");
		Font inf = new Font("ALGERIAN",Font.BOLD, 18);
		lInfirmier.setForeground(Color.BLUE);
		lInfirmier.setHorizontalAlignment(JLabel.HORIZONTAL);
		lInfirmier.setFont(inf);
		lInfirmier.setBounds(5, 3, 300, 25);
		
		pButtonInfirmier = new JPanel();
		pButtonInfirmier.setBounds(5, 15, 400, 400);
		pButtonInfirmier.setLayout(null);
		bEnregistrer = new JButton("ENREGISTRER PATIENT");
		bEnregistrer.setBounds(5, 25, 170 , 25);
		bExamen = new JButton("EXAMEN PATIENT");
		bExamen.setBounds(180, 25, 170, 25);
		bHospitaliser  = new JButton("HOSPITALISATION");
		bHospitaliser.setBounds(5, 55, 170, 25);
		bHospitaliser.setForeground(Color.BLACK);
		bRenvoyer = new JButton("RENVOYER");
		bRenvoyer.setBounds(180, 55, 170, 25);
		bRenvoyer.setForeground(Color.BLACK);
		pButtonInfirmier.add(bEnregistrer);
		pButtonInfirmier.add(bExamen);
		pButtonInfirmier.add(bHospitaliser);
		pButtonInfirmier.add(bRenvoyer);
		
		
		panInfirmier.setLayout(null);
		panInfirmier.add(lInfirmier);
		panInfirmier.add(pButtonInfirmier);
		
		
		
		
		//Gestion Patient
		//lIcon3 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/img2.PNG"));
		lIcon4 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/img3.PNG"));
		
		Font poli = new Font("ALGERIAN", Font.ROMAN_BASELINE, 24);
		Font pol = new Font("Tahoma", Font.ITALIC, 14);
		lPatient = new JLabel("ATTENTION ! ! ! !");
		lPatient.setForeground(Color.RED);
		lPat = new JLabel("CASH NEZ OBLIGATOIRE");
		lPat.setForeground(Color.BLACK);
		lPat.setBackground(Color.BLACK);
		lPatient.setFont(poli);
		lPat.setFont(poli);
		bRegardConsultation = new JButton("REGARDER CONSULTATION");
		bRegardConsultation.setForeground(Color.BLUE);
		bRegardConsultation.setFont(pol);
		bConsulterPresciption = new JButton("CONSULTER PRESCRIPTION");
		bConsulterPresciption.setForeground(Color.BLUE);
		bConsulterPresciption.setFont(pol);
		bConsulterRendevous = new JButton("CONSULTER RDV");
		bConsulterRendevous.setFont(pol);
		bConsulterRendevous.setForeground(Color.BLUE);
	
		
		
		panPatient.add(lPatient);
		panPatient.add(lPat);
		panPatient.add(bRegardConsultation);
		panPatient.add(bConsulterPresciption);
		panPatient.add(bConsulterRendevous );
		//panPatient.add(lIcon3);
		panPatient.add(lIcon4);
		
		
		
		
		panelPrincipale.add(onglets);
		panelPrincipale.setLayout(null);
		
		
		*/
		
	}
	
	

}

