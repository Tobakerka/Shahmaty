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

        if (toLine >= 0 && toColumn >= 0 && toLine < 8 && toColumn < 8 && !(line == toLine && column == toColumn)) {

            if (Math.abs(line - toLine) == Math.abs(column - toColumn)) {

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
