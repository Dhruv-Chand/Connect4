public class Runner {
    public static void main(String[] args) {
        Board board = new Board();
        ConnectFour game = new ConnectFour(board);
        game.setPlayer1(new AIPlayer('b', board, "Bob"));
        game.setPlayer2(new AIPlayer('j', board, "Jeff"));
        game.playGame();
    }
}
