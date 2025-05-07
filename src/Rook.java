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

        if (toLine < 0 || toColumn < 0 || toLine > 7 || toColumn > 7) {

            return false;
        }


        if (line == toLine && column == toColumn) {

            return false;
        }

        if (line == toLine) {

            for (int i = Math.min(column, toColumn) + 1; i < Math.max(column, toColumn); i++) {

                if (chessBoard.board[line][i] != null) {
                    if (!chessBoard.board[line][i].color.equals(this.color)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

        } else if (column == toColumn) {

            for (int i = Math.min(line, toLine) + 1; i < Math.max(line, toLine); i++) {

                if (chessBoard.board[i][column] != null) {
                    if (!chessBoard.board[i][column].color.equals(this.color)) {
                        this.check = false;
                        return true;
                    } else {
                        return false;
                    }


                }
            }
        }

        return false;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard.board[i][j] != null && !chessBoard.board[i][j].getColor().equals(this.color)) {
                    if (chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {

        return "R";
    }
}
