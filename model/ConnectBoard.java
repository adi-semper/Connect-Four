package model;

public class ConnectBoard {

    private String[][] board;
    private String wonHow;
    private int[] wonWhere;
    
    public ConnectBoard() {
    
        board = new String[6][7];
        wonWhere = new int[2];
        
        clearBoard();
    
    }
    
    public String getWonHow() {
    
        return wonHow;
    
    }
    
    public int[] getWonWhere() {
    
        return wonWhere;
    
    }
    
    public String getSymbol( int row, int col ) {
    
        return board[ row ][ col ];
    
    }
    
    public int addToBoard( int col, String letter ) {
    
        int row = freeRow( col );
        
        if ( row < 6 && row > -1 ) {
        
            board[ row ][ col ] = letter;
        }
    
        return row;
    }
    
    public boolean hasWon( String letter ) {
    
        boolean result = false;
        String target = letter + letter + letter + letter;
        String horizontal = "";
        String vertical = "";
        String positive = "";
        String negative = "";
        
        for ( int row = 0; row < 7; row++ ) {
            for ( int col = 0; col < 7; col++ ) {
                for ( int newCol = col; newCol < col + 4; newCol++ ) {
                
                    if ( col < 4 && row < 6 ) {
                        horizontal += board[ row ][ newCol ];
                    }
                    if ( col < 3 ) {
                        vertical += board[ newCol ][ row ];
                    }
                
                }
            
                if ( horizontal.equals( target ) && col < 4 ) {
                
                    wonHow = "horizontal";
                    wonWhere[0] = row;
                    wonWhere[1] = col;
                    result = true;
                
                } else if ( vertical.equals( target ) && col < 3 ){
                
                    wonHow = "vertical";
                    wonWhere[0] = col;
                    wonWhere[1] = row;
                    result = true;
                
                } else {
                
                    horizontal = "";
                    vertical = "";
                
                }
            
            }
        
        
        }
        
        for ( int row = 5; row > 2; row-- ) {
            for ( int col = 0; col < 4; col++ ) {
                for ( int add = 0; add < 4; add++ ) {
                
                    positive += board[row-add][col+add];
                    negative += board[row-add][6-col-add];
                
                }
                
                if ( positive.equals( target ) && !result ) {
                
                    wonHow = "positive";
                    wonWhere[0] = row;
                    wonWhere[1] = col;
                    result = true;
                
                } else if ( negative.equals( target ) && ! result ) {
                
                    wonHow = "negative";
                    wonWhere[0] = row;
                    wonWhere[1] = 6-col;
                    result = true;
                
                } else {
                
                    positive = "";
                    negative = "";
                
                }
            
            }
        
        }
    
        return result;
    
    }

    public void clearBoard() {
    
        for ( int row = 0; row < 6; row++ ) {
            for ( int col = 0; col < 7; col++ ) {
            
                board[ row ][ col ] = "";
            }
        
        }
    
    }
    
    private int freeRow( int col ) {
    
        int result = -1;
    
        for ( int row = 0; row < 6; row++ ) {
        
            if ( board[ row ][ col ].equals( "" ) ) {
            
                result++;
            
            }
        
        }
        
        return result;
    
    }

}
