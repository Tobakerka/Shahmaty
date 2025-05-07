public class Queen extends ChessPiece{
    public Queen(String color) {
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

        if (line == toLine || column == toColumn || Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            if (line == toLine) {
                for (int i = Math.min(column, toColumn) + 1; i < Math.max(column, toColumn); i++) {
                    if (chessBoard.board[line][i] != null) {
                        if (chessBoard.board[line][i].getColor().equals(this.color)) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            } else if (column == toColumn) {
                for (int i = Math.min(line, toLine) + 1; i < Math.max(line, toLine); i++) {
                    if (chessBoard.board[i][column] != null) {
                        if (chessBoard.board[i][column].getColor().equals(this.color)) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            } else {
                int dx = (toColumn - column) / Math.abs(toColumn - column);
                int dy = (toLine - line) / Math.abs(toLine - line);
                for (int i = 1; i < Math.abs(toColumn - column); i++) {
                    if (chessBoard.board[line + i * dy][column + i * dx] != null) {
                        if (chessBoard.board[line + i * dy][column + i * dx].getColor().equals(this.color)) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}


