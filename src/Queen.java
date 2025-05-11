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

        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        if (line == toLine && column == toColumn) {
            return false;
        }

        if (chessBoard.nowPlayer.equals(this.color)) {
            if (column == toColumn) {
                for (int i = 1; i < Math.abs(toLine - line); i++) {
                    if (toLine > line) {
                        if (chessBoard.board[line + i][toColumn] != null) {
                            return false;
                        }
                    } else {
                        if (chessBoard.board[line - i][toColumn] != null) {
                            return false;
                        }
                    }
                }
            } else if (line == toLine) {
                for (int i = 1; i < Math.abs(toColumn - column); i++) {
                    if (toColumn > column) {
                        if (chessBoard.board[line][column + i] != null) {
                            return false;
                        }
                    } else {
                        if (chessBoard.board[line][toColumn + i] != null) {
                            return false;
                        }
                    }
                }
            } else if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
                for (int i = 1; i < Math.abs(toLine - line); i++) {
                    if (toLine > line && toColumn > column) {
                        if (chessBoard.board[line + i][column + i] != null) {
                            return false;
                        }
                    } else if (toLine < line && toColumn > column) {
                        if (chessBoard.board[line - i][column + i] != null) {
                            return false;
                        }
                    } else if (toLine > line && toColumn < column) {
                        if (chessBoard.board[line + i][column - i] != null) {
                            return false;
                        }
                    } else if (toLine < line && toColumn < column) {
                        if (chessBoard.board[line - i][column - i] != null) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }

            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
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
        return "Q";
    }
}


