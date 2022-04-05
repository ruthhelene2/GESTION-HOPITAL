package com.GestionPharmacieHopital;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calendrier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//obtenir la date courante
		//DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//Date date = new Date(0);
		//System.out.println(format.format(date));
		
		// obtenir l'heure courante
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		System.out.println(format.format(calendar.getTime()));
		//tDate.setText(format.format(calendar.getTime()));
		
		
		DateFormat forma = new SimpleDateFormat("hh:mm:ss");
		Calendar calenda = Calendar.getInstance();
		System.out.println(forma.format(calendar.getTime()));
		//tHeure.setText(forma.format(calenda.getTime()));
		

	}

}
