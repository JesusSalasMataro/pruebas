package cancolapi;

import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;


public class Cancolapi extends JFrame
{

	private static PanellHabitacio Habitacio;
	private static PanelMissatges Missatges;
	private static PanelItems Objectes;
	private static JPanel Controles;
    
    private static ControladorJoc controladorJoc;
       
    Cancolapi()
    {    	
      //inicialitzem els panells gr�fics del joc
        JPanel Pantalla = new JPanel();
        Habitacio = new PanellHabitacio(1200, 500);
        Objectes = new PanelItems(280, 500);
        Controles = new JPanel();
        Missatges = new PanelMissatges();
        
        // test llista items
        /*
        Objetos.AfegirObjecte("os");
        Objetos.AfegirObjecte("escala");
        Objetos.AfegirObjecte("ouija");
        Objetos.TreureObjecte("escala");
        */
        
        //assignem layout
        Controles.setLayout(new FlowLayout());
        //inicialtzem els botons
        JButton MoureAdalt = new JButton("Dalt");
        JButton MoureAbaix = new JButton("Baix");
        JButton MoureEsquerra = new JButton("Esquerra");
        JButton MoureDreta = new JButton("Dreta");
        JButton AgafarObjecte = new JButton("Agafar");
        JButton Donar = new JButton("Donar");
        JButton Usar = new JButton("Usar");
        //afegim els botons al panell
        Controles.add(MoureEsquerra);
        Controles.add(MoureAdalt);
        Controles.add(MoureAbaix);
        Controles.add(MoureDreta);
        Controles.add(AgafarObjecte);
        Controles.add(Donar);
        Controles.add(Usar);
        
        //assignaem als botons els esdeveniments segons el moviment, en aquest cas el clickar al bot�.
        MoureEsquerra.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		processarMovimentPersonatge(ControladorJoc.ESQUERRA);
        	}
        });
        MoureAdalt.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		processarMovimentPersonatge(ControladorJoc.DALT);
        	}
        });
        MoureAbaix.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		processarMovimentPersonatge(ControladorJoc.ABAIX);
        	}
        });
       
        MoureDreta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		processarMovimentPersonatge(ControladorJoc.DRETA);
        	}
        });
        //----------
        AgafarObjecte.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String missatge = controladorJoc.personatgeAgafaObjectes();
        		
        		if (missatge != "") {
        			Objectes.AfegirObjectes(controladorJoc.getPersonatge().getObjectes());
        		}
        		else {
        			missatge = "No hi han objectes a l'habitaci�.";
        		}
        		
        		Missatges.setMissatge(missatge);
        	}
        });
        Donar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
       
        	}
        });
        Usar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
               
        //dimensionem el total de la pantalla
        Pantalla.setMinimumSize(new Dimension(1500, 900));
        Pantalla.setLayout(null);
     
        //a pantalla li afegim la resta de panells que hi haur� dins d'aquest.
        Pantalla.add(Habitacio);
        Pantalla.add(Objectes);
        Pantalla.add(Missatges);
        Pantalla.add(Controles);
        
        
        //assignem mides i posici� dins del panell principal (pantalla)
        Habitacio.setBounds(10, 10, 1200, 500);
        Missatges.setBounds(10, 520, 1500, 110);
        Objectes.setBounds(1205, 10, 280, 500);
        Controles.setBounds(10, 650, 1500, 80);      
        
    	setResizable(false);
        setVisible(true);
        //el jframe tindr� les mateixes mides que el panell principal.
        setMinimumSize(new Dimension(1500, 900));
        this.add(Pantalla);
    }
    
    public static void main(String args[])
    {
        //    inicialtizem controlador del joc que controla la logica de l'app
    	controladorJoc = new ControladorJoc();
        new Cancolapi();
    }
    //segons la ordre s'envia una variable al controlador per a que gestioni el moviment
    private static void processarMovimentPersonatge(int direccio) {
    	//fem que la habitacio actual sigui sempre on es troba el jugador
    	int numeroHabitacioActual = controladorJoc.getPersonatge().getHabitacioActual();   
    	//la funcio de moure personatge ens retorna la nova posicio
    	int numeroNovaHabitacio = controladorJoc.mourePersonatge(direccio);
    	// si el personatge s'ha mogut cridem la funcio que fa que l'apartat grafic s'actualitzi amb la nova imatge
    	if (numeroHabitacioActual != numeroNovaHabitacio) {
    		Habitacio.setHabitacioActual(numeroNovaHabitacio);
    		
    	}
    	
    }
}   

