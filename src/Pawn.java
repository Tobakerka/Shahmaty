public class Pawn extends ChessPiece{

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (line >= 0 && toColumn >= 0 && line <= 8 && toColumn <= 8 && !(line == toLine && column == toColumn)){
            if (color.equals("White")) {
                if (line == 1 && toLine == 3 && column == toColumn) {
                    return true;
                } else if (line == toLine - 1 && column == toColumn) {
                    return true;
                } else {
                    return false;
                }
            } else if (color.equals("Black")) {
                if (line == 6 && toLine == 4 && column == toColumn) {
                    return true;
                } else if (line == toLine + 1 && column == toColumn) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
