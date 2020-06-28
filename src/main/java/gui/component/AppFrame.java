/**
 * 
 */
package gui.component;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

/**
 * @author ro6k4
 *
 */
public class AppFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9152272634774345100L;

	/**
	 * @throws HeadlessException
	 */
	public AppFrame() throws HeadlessException {
		this.setSize(800, 800);
		this.setLayout(null);
	}

	/**
	 * @param gc
	 */
	public AppFrame(GraphicsConfiguration gc) {
		super(gc);
		this.setSize(800, 800);
		this.setLayout(null);
	}

	/**
	 * @param title
	 * @throws HeadlessException
	 */
	public AppFrame(String title) throws HeadlessException {
		super(title);
		this.setSize(800, 800);
		this.setLayout(null);
	}

	/**
	 * @param title
	 * @param gc
	 */
	public AppFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		this.setSize(800, 800);
		this.setLayout(null);
	}

}
