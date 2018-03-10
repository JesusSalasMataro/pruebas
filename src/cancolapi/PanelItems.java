package cancolapi;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.*;

public class PanelItems extends JPanel{
	private ArrayList <Image> imatgesItems;
	private ArrayList <String> itemsActius;

	private int ample;
	private int alcada;
	
	public PanelItems(int ample, int alcada) {
		super();	
		this.imatgesItems= new ArrayList<Image>();
		Image os = new ImageIcon(getClass().getResource("./imatges/os.jpg")).getImage();
		Image escala = new ImageIcon(getClass().getResource("./imatges/escala.jpg")).getImage();
		Image ouija = new ImageIcon(getClass().getResource("./imatges/ouija.jpg")).getImage();
		this.imatgesItems.add(os);
		this.imatgesItems.add(escala);
		this.imatgesItems.add(ouija);
		this.itemsActius= new ArrayList<String>();

		this.ample = ample;
		this.alcada = alcada;
		this.setMinimumSize(new Dimension(ample, alcada));
		this.setLayout(null);
	}

	@Override
	public void paintComponent(Graphics g) {
		int posicioVertical = 10;
		
		for (int i=0; i<itemsActius.size(); i++) {
			if (itemsActius.get(i).equals("Os")) {
				g.drawImage(imatgesItems.get(0), 10, posicioVertical, 40, 40, null);
			}
			else if(itemsActius.get(i).equals("Escala")) {
				g.drawImage(imatgesItems.get(1), 10, posicioVertical, 40, 40, null);
			}
			else if(itemsActius.get(i).equals("Ouija")) {
				g.drawImage(imatgesItems.get(2), 10, posicioVertical, 40, 40, null);
			}

			posicioVertical = posicioVertical + 50;
		}	
	}
	
	public void AfegirObjecte(String item) {
		itemsActius.add(item);
	}
	
	public void TreureObjecte(String item) {
		itemsActius.remove(item);
	}
	
	public void AfegirObjectes(ArrayList<Objecte> objectes) {
		for (int i=0; i<objectes.size(); i++) {
			itemsActius.add(objectes.get(i).getNom());
		}
		
		repaint();
	}
	

}
