package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ConnectListener extends WindowAdapter
        implements ActionListener, MouseListener, ChangeListener {

    private ConnectControl frame;
    private JSpinner player1Spinner;
    private JSpinner player2Spinner;

    public ConnectListener( ConnectControl frame ) {
    
        this.frame = frame;
        player1Spinner = frame.getPlayer1Spinner();
        player2Spinner = frame.getPlayer2Spinner();
    
    }

    @Override
    public void actionPerformed( ActionEvent e ) {

        JButton btn = (JButton) e.getSource();
        
        if ( btn instanceof JButton ) {
        
            handleButtonEvents( btn );
        
        }

    }

    private void handleButtonEvents( JButton btn ) {

        String text = btn.getText();
        
        if ( text.equals( "Play" ) ) {
        
            frame.startPressed();
        
        } else if ( text.equals( "Restart" ) ) {
        
            frame.restartPressed();
        
        } else {
        
            frame.inputBtnsPressed( btn );
            btn.setBackground( Color.WHITE );
            if ( btn.isEnabled() ) {
                frame.buttonHover( btn );
            }
        
        }

    }
    
    @Override
    public void windowClosing( WindowEvent e ) {

        System.exit( 0 );

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {}

    @Override
    public void mouseEntered( MouseEvent e ) {

        JButton btn = (JButton) e.getSource();
    
        if ( btn instanceof JButton ) {
        
            if ( btn.isEnabled() ) {
                frame.buttonHover( btn );
            }
    
        }

    }

    @Override
    public void mouseExited( MouseEvent e ) {
        JButton btn = (JButton) e.getSource();
	    
            if ( btn instanceof JButton ) {
           
                btn.setBackground( Color.white );
    
            }
    }

    @Override
    public void mousePressed(MouseEvent arg0) {}

    @Override
    public void mouseReleased(MouseEvent arg0) {}

    @Override
    public void stateChanged( ChangeEvent e ) {

        JSpinner spinner = (JSpinner) e.getSource();
        String value = spinner.getValue().toString();
        
        if ( value.equals( "7" ) ) {
        
            spinner.setValue( "1" );
        
        } else if ( value.equals( "0" ) ) {
        
            spinner.setValue( "7" );
        
        }
        
        String endValue = spinner.getValue().toString();
        int position = Integer.parseInt( endValue );
        
        if ( player1Spinner.getValue().equals( player2Spinner.getValue() ) ) {
            
            frame.getStartButton().setEnabled( false );
           
        } else {
        
            frame.getStartButton().setEnabled( true );
        
        }
        
        frame.changePlayerColor( spinner, position );

    }

}
