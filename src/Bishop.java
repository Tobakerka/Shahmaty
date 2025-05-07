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

        if (Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            for (int i = 1; i < Math.abs(line - toLine); i++) {
                if ((chessBoard.board[toLine + i][toColumn -1 + i] != null)) {
                    return false;
                }
            }

            if (!chessBoard.board[toLine][toColumn].color.equals(this.color)) {
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

        return "B";
    }
}
