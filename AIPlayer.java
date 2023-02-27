import java.util.Random;

public class AIPlayer extends Player{

    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    @Override
    public void makeMove(Board board) {
        //check tie (to prevent infinite loop situations)
        if (board.isTie()) return;
        //check if there is a winning move
        char last = board.getLastSymbol();
        for(int x = 0; x < board.getNumColumn(); x++) {
            if(!board.columnFull(x + 1)) {
                board.addSymbol(this.symbol, x + 1);
                if (board.containsWin()) {
                    return;
                }
                else {
                    board.removeSymbol(x + 1);
                }
            }
        }
        //check if there is a blockable move
        
        for(int x = 0; x < board.getNumColumn(); x++) {
            if(!board.columnFull(x + 1)) {
                board.addSymbol(last, x + 1);
                if (board.containsWin()) {
                    board.removeSymbol(x + 1);
                    board.addSymbol(this.symbol, x + 1);
                    return;
                }
                else board.removeSymbol(x + 1);
            }
        }
        
        
        //place piece at random
        while (true) {
            Random rand = new Random();
            int randomInt = rand.nextInt(7);
            if (!board.columnFull(randomInt + 1)) {
                board.addSymbol(symbol, randomInt + 1);
                return;
            }
        }

    }
    
}
