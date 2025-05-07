public class Horse extends ChessPiece{

    public Horse(String color) {

        super(color);
    }

    @Override
    public String getColor() {

        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (toLine >= 0 && toColumn >= 0 && toLine < 8 && toColumn < 8 && !(line == toLine && column == toColumn)) {

            if ((line == toLine - 2 || line == toLine + 2) && (column == toColumn + 1 || column == toColumn - 1)) {

                if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) {
                    return true;
                } else {
                    return false;
                }

            } else if ((line == toLine - 1 || line == toLine + 1) && (column == toColumn + 2 || column == toColumn - 2)) {

                if (chessBoard.board[toLine][toColumn] == null || chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
                    return true;
                } else {
                    return false;
                }
            } else {

                return false;
            }

        } else {

            return false;
        }
    }

    @Override
    public String getSymbol() {

        return "H";
    }
}
