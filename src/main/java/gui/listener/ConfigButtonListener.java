/**
 * 
 */
package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import config.IConfigReader;
import config.XmlConfigReader;
import core.IDomain;

/**
 * @author ro6k4
 *
 */
public class ConfigButtonListener implements ActionListener {
	
	private IConfigReader cReader;
	private JTextArea info;
	private boolean success;
	private String message;
	
	/**
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * 
	 */
	public ConfigButtonListener(JTextArea info) throws ParserConfigurationException, SAXException, IOException {
		this.cReader = new XmlConfigReader();
		this.info = info;
		this.success = false;
		this.message = "";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!this.success) {
			this.cReader.init();
			this.message = "Configuration chargée." + System.lineSeparator();
			this.message += this.getDomains();
			this.setInfo();
			this.success = true;
		}else {
			this.message = "Configuration rechargée." + System.lineSeparator();
			this.message += this.getDomains();
			this.setInfo();
		}

	}
	
	public void setInfo() {
		this.info.setText(message);
	}
	
	public IConfigReader getConfigReader() {
		return this.cReader;
	}

	public String getDomains() {
		ArrayList<IDomain> domains = this.getConfigReader().getDomains();
		int nbDomains = domains.size();
		String res = "Domaines à extraire :" + System.lineSeparator();
		for(int i = 0; i < nbDomains; i++) {
			IDomain domain = domains.get(i);
			res += " " + domain.getName() + ";";
		}
		return res;
	}
}
