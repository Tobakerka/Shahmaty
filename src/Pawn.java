import java.util.Arrays;

public class Pawn extends ChessPiece{

    public Pawn(String color) {

        super(color);
    }

    @Override
    public String getColor() {

        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn){
            return false;
        }

        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        if (this.color.equals("White")) {
            if (line == toLine - 1 && column == toColumn) {
                if (chessBoard.board[toLine][toColumn] == null) {
                    return true;
                } else {
                    return false;
                }
            } else if ((line == toLine - 2) && column == toColumn && (line == 1)) {
                if (chessBoard.board[toLine][toColumn] == null) {
                    return true;
                } else {
                    return false;
                }
            } else if (line == toLine - 1 && column == toColumn - 1 && chessBoard.board[toLine][toColumn].color.equals("Black")) {
                return true;
            } else if (line == toLine + 1 && column == toColumn + 1 && chessBoard.board[toLine][toColumn].color.equals("Black")) {
                return true;
            } else if (line == toLine + 1 && column == toColumn - 1 && chessBoard.board[toLine][toColumn].color.equals("Black")) {
                return true;
            } else if (line == toLine - 1 && column == toColumn + 1 && chessBoard.board[toLine][toColumn].color.equals("Black")) {
                return true;
            } else {
                return false;
            }
        } else if (this.color.equals("Black")) {
            if (line == toLine + 1 && column == toColumn) {
                if (chessBoard.board[toLine][toColumn] == null) {
                    return true;
                } else {
                    return false;
                }
            } else if ((line == toLine + 2) && column == toColumn && (line == 6)) {
                return true;
            } else if (line == toLine - 1 && column == toColumn - 1 && chessBoard.board[toLine][toColumn].color.equals("White")) {
                return true;
            } else if (line == toLine + 1 && column == toColumn + 1 && chessBoard.board[toLine][toColumn].color.equals("White")) {
                return true;
            } else if (line == toLine + 1 && column == toColumn - 1 && chessBoard.board[toLine][toColumn].color.equals("White")) {
                return true;
            } else if (line == toLine - 1 && column == toColumn + 1 && chessBoard.board[toLine][toColumn].color.equals("White")) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {

        return "P";
    }
}
