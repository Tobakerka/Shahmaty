import java.util.Objects;

public class Rook extends ChessPiece {

    public Rook(String color) {

        super(color);
    }

    @Override
    public String getColor() {

        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        if (line == toLine && column == toColumn) {
            return false;
        }

        if (line != toLine && column != toColumn) {
            return false;
        }

        if (chessBoard.nowPlayer.equals(this.color)) {
            if (line < toLine) {
                for (int i = 1; i < Math.abs(toLine - line); i++) {
                    if (chessBoard.board[line + i][column] != null) {
                        return false;
                    }
                }
            } else if (line > toLine) {
                for (int i = 1; i < Math.abs(line - toLine); i++) {
                    if (chessBoard.board[line - i][column] != null) {
                        return false;
                    }
                }
            } else if (column < toColumn) {
                for (int i = 1; i < Math.abs(toColumn - column); i++) {
                    if (chessBoard.board[line][column + i] != null) {
                        return false;
                    }
                }
            } else {
                for (int i = 1; i < Math.abs(column - toColumn); i++) {
                    if (chessBoard.board[line][column - i] != null) {
                        return false;
                    }
                }
            }
            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getSymbol() {

        return "R";
    }
}
