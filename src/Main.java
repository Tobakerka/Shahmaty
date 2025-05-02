public class Main {

    public static void main(String [] args) {


        ChessBoard chessBoard = new ChessBoard("1");
        chessBoard.printBoard();
        Horse h = new Horse( "Black");
        h.canMoveToPosition(chessBoard,4,4,2,1);
        chessBoard.printBoard();
    }
}