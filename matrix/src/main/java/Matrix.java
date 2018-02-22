import java.util.Arrays;
import java.util.stream.IntStream;

class Matrix {
    private final String[] rows;

    Matrix(String matrixAsString) {
        this.rows = matrixAsString.split("\n");
    }

    int[] getRow(int index) {
        String[] row = rows[index].split(" ");
        return Arrays.stream(row)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    int[] getColumn(int columnIndex) {
        return IntStream.range(0, rows.length)
                .map(rowIndex -> getRow(rowIndex)[columnIndex])
                .toArray();
    }

    int getRowsCount() {
        return rows.length;
    }

    int getColumnsCount() {
        return getRow(0).length;
    }

}
