import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    @Override
    public void makeMove(Board board) {
        //check tie (to prevent infinite loop situations)
        if (board.isTie()) return;
        //Getting input for column
        Scanner sc = new Scanner(System.in);
        int input;
        boolean loop;
        do {
            loop = false;
            System.out.print(this.name + ", Please input your move: ");
            input = sc.nextInt();
            System.out.println("");
            if (input > 7 || input < 1) {
                loop = true;
                System.out.println("Please input a column between 1-7.");
            }
            else if (board.columnFull(input)) {
                loop = true;
                System.out.println("That column is full, please choose another column.");
            }
        } while (loop);
        
        //add input to board
        board.addSymbol(this.symbol, input);

    }
    
}
