/**
 * 
 */
package gui.component;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 * @author ro6k4
 *
 */
public class LoadButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8076688065239923267L;

	/**
	 * 
	 */
	public LoadButton() {
	}

	/**
	 * @param icon
	 */
	public LoadButton(Icon icon) {
		super(icon);
	}

	/**
	 * @param text
	 */
	public LoadButton(String text) {
		super(text);
	}

	/**
	 * @param a
	 */
	public LoadButton(Action a) {
		super(a);
	}

	/**
	 * @param text
	 * @param icon
	 */
	public LoadButton(String text, Icon icon) {
		super(text, icon);
	}

}
