import java.util.Objects;

public class Bishop extends ChessPiece {

    public Bishop(String color) {

        super(color);
    }

    @Override
    public String getColor() {

        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7 || line == toLine || column == toColumn) {
            return false;
        }

        if (chessBoard.nowPlayer.equals(this.color)) {
            if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
                if (chessBoard.board[toLine][toColumn] == null || !Objects.equals(chessBoard.board[toLine][toColumn].color, this.color)) {
                    for (int i = 1; i < Math.abs(toLine - line); i++) {
                        if (line < toLine && column < toColumn) {
                            if (chessBoard.board[line + i][column + i] != null) {
                                return false;
                            }
                        } else if (line < toLine && column > toColumn) {
                            if (chessBoard.board[line + i][column - i] != null) {
                                return false;
                            }
                        } else if (line > toLine && column < toColumn) {
                            if (chessBoard.board[line - i][column + i] != null) {
                                return false;
                            }
                        } else {
                            if (chessBoard.board[line - i][column - i] != null) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public String getSymbol() {

        return "B";
    }
}
