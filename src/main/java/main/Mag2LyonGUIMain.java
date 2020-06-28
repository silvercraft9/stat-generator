/**
 * 
 */
package main;

import java.io.IOException;

import javax.swing.JTextArea;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import gui.component.AppFrame;
import gui.component.LoadButton;
import gui.listener.ConfigButtonListener;

/**
 * @author ro6k4
 *
 */
public class Mag2LyonGUIMain {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		AppFrame app = new AppFrame("Stat Generator");
		
		JTextArea loadInfo = new JTextArea();
		loadInfo.setBounds(50, 50, 700, 80);
		
		LoadButton loadButton = new LoadButton("Charger la configuration");
		loadButton.setBounds(550, 140, 200, 40);
		
		ConfigButtonListener loadButtonListener = new ConfigButtonListener(loadInfo);
		loadButton.addActionListener(loadButtonListener);
		
		app.add(loadInfo);
		app.add(loadButton);
		
		app.setVisible(true);
		
	}

}
