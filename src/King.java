public class King extends ChessPiece{
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toColumn < 0 || toLine > 7 || toColumn > 7) {
            return false;
        }

        if (line == toLine && column == toColumn) {
            return false;
        }

        if (Math.abs(line - toLine) > 1 || Math.abs(column - toColumn) > 1) {
            return false;
        }

        if (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 1) {
            if (chessBoard.board[toLine][toColumn] != null) {
                return false;
            }
        } else if (line == toLine) {
            for (int i = Math.min(column, toColumn) + 1; i < Math.max(column, toColumn); i++) {
                if (chessBoard.board[line][i] != null) {
                    return false;
                }
            }
        } else if (column == toColumn) {
            for (int i = Math.min(line, toLine) + 1; i < Math.max(line, toLine); i++) {
                if (chessBoard.board[i][column] != null) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
