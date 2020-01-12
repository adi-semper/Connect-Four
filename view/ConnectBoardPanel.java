package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ConnectBoardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConnectBoardPanel() {
	    super();
        
	    
        setPreferredSize( new Dimension( 820, 800 ) );
        setBackground( Color.BLUE );
        setVisible( true );
        
    
    }
	
	public void paint( Graphics g ) {
	    
	    for ( int i = 1; i < 7; i++) {
	        for ( int j = 1; j < 8; j++ ) {
	    	int xAxis = 100*j;
	    	int yAxis = 100*i;
	    
	        
	        g.setColor( Color.RED);
	        g.fillOval(xAxis, yAxis, 95, 95 );
	        
	        }
	    }
	
	}

}
