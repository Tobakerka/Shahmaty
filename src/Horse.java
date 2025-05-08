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

        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        if (chessBoard.nowPlayer.equals(this.color)) {
            if ((Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2) || (Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1)) {
                if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) {
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
