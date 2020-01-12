package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ConnectFrame extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ONE = 0;
    private static final int TWO = 1;

    private JLabel player1Label;
    private JLabel player1Score;
    private JLabel player2Label;
    private JLabel player2Score;
    private JLabel turnLabel;
    private JButton turnButton;
    private JButton startButton;
    private JButton restartButton;
    private JButton nullButton;
    private JButton nullButton2;
    private JButton nullButton3;
    private JButton[] inputBtns;
    private JButton[][] boardBtns;
    private JSpinner player1Color;
    private JSpinner player2Color;
    private SpinnerListModel colorsInput1;
    private SpinnerListModel colorsInput2;
    private String[] colors;
    private Icon arrowImage;
    
    private JPanel mainPanel;
    private JPanel eastPanel;
    private JPanel centerPanel;
    private JPanel westPanel;
    private JPanel turnPanel;
    private JPanel startBtnPanel;
    private JPanel inputBtnPanel;
    private JPanel boardPanel;
    private JPanel nullPanel1;
    private JPanel nullPanel2;
    
    public ConnectFrame() {
    
        createComponents();
        setPanels();
        setButtonSize();
        addComponents();
        addBorders();
        makePanelPretty();
        reset();

        setPreferredSize( new Dimension( 1100, 950 ) );
        pack();
        setLocationRelativeTo( null );
    
    }
    
    public JLabel getTurnLabel() {
    
        return turnLabel;
    }
    
    public JButton getTurnButton() {
    
       return turnButton;
    }
    
    public JButton getStartButton() {
    
        return startButton;
    }
    
    public JButton getRestartButton() {
    
        return restartButton;
    }
    
    public JButton[] getInputButtons() {
    
        return inputBtns;
    }
    
    public JButton[][] getBoardButtons() {
    
    	return boardBtns;
    }
    
    public JSpinner getPlayer1Spinner( int which ) {
    
       return which == 0 ? player1Color : player2Color;
    }

    private void makePanelPretty() {
	
    	player1Label.setFont( new Font( "Ariel", Font.BOLD, 30 ) );
    	player2Label.setFont( new Font( "Ariel", Font.BOLD, 30 ) );
    	nullButton.setContentAreaFilled( false );
    	nullButton2.setContentAreaFilled( false );
    	nullButton3.setContentAreaFilled( false );
        setPlayerColor( ONE, Color.red );
        setPlayerColor( TWO, Color.yellow );
    
	}

	private void setButtonSize() {

    	Dimension d = inputBtns[ 0 ].getPreferredSize();
        int size = (int) ( d.getWidth() < d.getHeight() ? d.getHeight()
                        : d.getWidth() );
        size = size * 6 / 3;

        for ( int row = 0; row < inputBtns.length; row++ ) {
                JButton btn = inputBtns[ row ];
                btn.setPreferredSize( new Dimension( size-10, size-10 ) );
            
        } // end for
        for ( int row = 0; row < boardBtns.length; row++ ) {
            JButton btn = boardBtns[ row ][ row ];
            btn.setPreferredSize( new Dimension( size, size ) );
        
        } // end for
        player1Color.setPreferredSize( new Dimension( 45, 24 ) );
        player2Color.setPreferredSize( new Dimension( 45, 24 ) );

    } // method setButtonSize 
    
    private void addBorders() {
    	
    	CompoundBorder externalBorder = new CompoundBorder(
                new EmptyBorder( 10, 10, 10, 10 ),
                new TitledBorder( new EtchedBorder(), "Connect Four" ) );

        Border nameBorder = BorderFactory.createEmptyBorder( 400, 0, 10, 0 );
        Border turnBorder = BorderFactory.createEmptyBorder( 20, 0, 20, 0 );
        Border scoreBorder = BorderFactory.createEmptyBorder( 30, 50, 390, 50 );
        Border panelBorder = BorderFactory.createEmptyBorder( 30, 15, 20, 15 );
        Border spacerBorder = BorderFactory.createEmptyBorder( 20, 10, 20, 10 );
        Border nullBorder = BorderFactory.createEmptyBorder( 0, 0, 0, 70 );
    
        turnPanel.setBorder( turnBorder );
        player1Label.setBorder( nameBorder );
        player1Score.setBorder( scoreBorder );
        player2Label.setBorder( nameBorder );
        player2Score.setBorder( scoreBorder );
        nullButton.setBorder( spacerBorder );
        nullButton2.setBorder( nullBorder );
        nullButton3.setBorder( nullBorder );
        
        inputBtnPanel.setBorder( panelBorder );
        boardPanel.setBorder( panelBorder );
        mainPanel.setBorder( externalBorder );
   
    }

    private void addComponents() {

    	nullPanel1.add( nullButton2 );
        nullPanel1.add( player1Color );
        
        westPanel.add( player1Label );
        westPanel.add( nullPanel1 );
        westPanel.add( player1Score );
        
        turnPanel.add( turnLabel );
        turnPanel.add( turnButton );
        
        for ( int i = 0; i < 7; i++ ) {
            inputBtnPanel.add( inputBtns[i] );
        }
        for ( int row = 0; row < 6; row++ ) {
            for ( int col = 0; col < 7; col++ ) {
                boardPanel.add( boardBtns[row][col] );
                boardBtns[row][col].setBorder( 
                        BorderFactory.createMatteBorder( 10, 10, 10, 10, Color.blue ) );
            }
        }
        
        startBtnPanel.add( startButton );
        startBtnPanel.add( nullButton );
        startBtnPanel.add( restartButton );
        
        centerPanel.add( turnPanel );
        centerPanel.add( inputBtnPanel );
        centerPanel.add( boardPanel );
        centerPanel.add( startBtnPanel );
        
        nullPanel2.add( nullButton3 );
        nullPanel2.add( player2Color );
        
        eastPanel.add( player2Label );
        eastPanel.add( nullPanel2 );
        eastPanel.add( player2Score );
        
        mainPanel.add( westPanel );
        mainPanel.add( centerPanel );
        mainPanel.add( eastPanel );

        setContentPane( mainPanel );
        
    }

	private void setPanels() {

        mainPanel.setLayout( new BoxLayout( mainPanel, BoxLayout.X_AXIS ) );
        westPanel.setLayout( new BoxLayout( westPanel, BoxLayout.Y_AXIS ) );
        centerPanel.setLayout( new BoxLayout( centerPanel, BoxLayout.Y_AXIS ) );
        eastPanel.setLayout( new BoxLayout( eastPanel, BoxLayout.Y_AXIS ) );
        turnPanel.setLayout( new FlowLayout() );
        startBtnPanel.setLayout( new BoxLayout( startBtnPanel, BoxLayout.X_AXIS ) );
        inputBtnPanel.setLayout( new FlowLayout() );
        boardPanel.setLayout( new GridLayout( 6, 7 ) );
        nullPanel1.setLayout( new FlowLayout() );
        nullPanel2.setLayout( new FlowLayout() );

	}

    private void createComponents() {

        player1Label = new JLabel( "Player 1" );
        player1Score = new JLabel( "" );
        player2Label = new JLabel( "Player 2" );
        player2Score = new JLabel( "" );
        turnLabel = new JLabel();
        
        turnButton = new JButton();
        startButton = new JButton( "Play" );
        restartButton = new JButton( "Restart" );
        nullButton = new JButton();
        nullButton2 = new JButton( " " );
        nullButton3 = new JButton( " " );
        inputBtns = new JButton[7];
        boardBtns = new JButton[6][7];
        arrowImage = new ImageIcon( "C:\\Users\\Juan Sempertegui\\Pictures\\down_arrow.PNG" );
        colors = new String[8];
        
        for ( int col = 0; col < 7; col++ ) {
            inputBtns[col] = new JButton( arrowImage );
            inputBtns[col].setFont( new Font( "Arial", Font.BOLD, 55) );
            for ( int row = 0; row < 6; row++ ) {
                boardBtns[row][col] = new JButton( "" );
            }
            
        }
        for ( int i = 0; i < colors.length; i++ ) {
            colors[i] = i + "";
        }
        
        colorsInput1 = new SpinnerListModel( colors );
        player1Color = new JSpinner( colorsInput1 );
        player1Color.setValue( "1" );
        
        colorsInput2 = new SpinnerListModel( colors );
        player2Color = new JSpinner( colorsInput2 );
        player2Color.setValue( "3" );
        
        mainPanel = new JPanel();
        eastPanel = new JPanel();
        centerPanel = new JPanel();
        westPanel = new JPanel();
        turnPanel = new JPanel();
        startBtnPanel = new JPanel();
        inputBtnPanel = new JPanel();
        nullPanel1 = new JPanel();
        nullPanel2 = new JPanel();
        boardPanel = new JPanel();

    }
    
    public void setPlayerColor( int which, Color color ) {
    
        if ( which == 0 ) {
        	player1Color.getEditor().getComponent(0).setBackground( color );
            player1Color.getEditor().getComponent(0).setForeground( color );
        } else {
        	player2Color.getEditor().getComponent(0).setBackground( color );
            player2Color.getEditor().getComponent(0).setForeground( color );
        }
    }
    
    public void reset() {
    
    	for ( int col = 0; col < 7; col++ ) {
            inputBtns[col].setBackground( Color.WHITE );
            inputBtns[col].setEnabled( false );
            for ( int row = 0; row < 6; row++ ) {
                boardBtns[row][col].setBackground( Color.WHITE );
                boardBtns[row][col].setBorder( 
                        BorderFactory.createMatteBorder( 10, 10, 10, 10, Color.blue ) );
            }
            
    	}
    	turnLabel.setText( "Press 'Play' " );
    	turnLabel.setFont( new Font( "Ariel", Font.BOLD, 50 ) );
        turnButton.setPreferredSize( new Dimension( 0,0 ) );
        turnButton.setContentAreaFilled( false );
        turnButton.setBorderPainted( false );
    
    }

}
