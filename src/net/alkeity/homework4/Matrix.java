package net.alkeity.homework4;

import java.math.BigDecimal;

public class Matrix<T extends Number> {
    private Number[][] matrix;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        setRows(rows);
        setCols(cols);
        this.matrix = new Number[rows][cols];
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public Number[][] getMatrix() {
        return matrix;
    }

    public void setRows(int rows) {
        if (rows < 0) throw new ArrayIndexOutOfBoundsException("Matrix width cannot be negative");
        this.rows = rows;
    }

    public void setCols(int cols) {
        if (cols < 0) throw new ArrayIndexOutOfBoundsException("Matrix height cannot be negative");
        this.cols = cols;
    }

    public void setMatrix(T[][] matrix) {
        this.matrix = matrix;
    }

    public T getValue(int row, int column) {
        return (T) matrix[row][column];
    }

    public void setValue(int row, int column, T value) {
        this.matrix[row][column] = value;
    }

    public boolean isSquare() {
        return this.rows == this.cols;
    }

//    public Matrix<T> invert() {
//        if (!isSquare()) throw new IllegalArgumentException("Matrix must be squared");
//        Matrix<T> result = new Matrix<T>(this.width, this.height);
//    }


    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%s ", this.matrix[i][j]);
            }
            System.out.println();
        }
    }

    public Matrix<T> add(Matrix<T> agent) {
        if (this.cols != agent.getCols() || this.rows != agent.getRows())
            throw new ArithmeticException("Matrixes should have the same sizes.");

        Matrix<T> result = new Matrix<T>(this.cols, this.rows);
        BigDecimal tmpSum;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                BigDecimal tmp = (BigDecimal) this.matrix[i][j];
                tmpSum = tmp.add((BigDecimal) agent.getValue(i, j));
                result.setValue(i, j, (T) tmpSum);
            }
        }

        return result;
    }

    public Matrix<T> substract(Matrix<T> agent) {
        if (this.cols != agent.getCols() || this.rows != agent.getRows())
            throw new ArithmeticException("Matrixes should have the same sizes.");

        Matrix<T> result = new Matrix<T>(this.cols, this.rows);
        BigDecimal tmpDiff;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                BigDecimal tmp = (BigDecimal) this.matrix[i][j];
                tmpDiff = tmp.subtract((BigDecimal) agent.getValue(i, j));
                result.setValue(i, j, (T) tmpDiff);
            }
        }

        return result;
    }

    public Matrix<T> multiply(Matrix<T> agent) {
        if (this.cols != agent.getRows())
            throw new ArithmeticException("Width of matrix 1 should be equal to height of matrix 2.");

        Matrix<T> result = new Matrix<T>(this.rows, agent.getCols());

        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.getCols(); j++) {
                for (int k = 0; k < this.cols; k++) {
                    BigDecimal tmp =
                            result.getValue(i, j) != null
                                    ? (BigDecimal) result.getValue(i, j)
                                    : BigDecimal.valueOf(0);
                    tmp = tmp.add(
                            ((BigDecimal) this.matrix[i][k]).multiply((BigDecimal) agent.getValue(k, j))
                    );
                    result.setValue(i, j, (T) tmp);
                }
            }
        }

        return result;
    }

    // TODO giving up on division for now, my brain's giving up on me
//    public Matrix<T> divide(Matrix<T> agent) {
//        if (!isSquare()) throw new IllegalArgumentException("Matrix must be squared");
//
//        if (this.height != agent.getWidth())
//            throw new ArithmeticException("Width of matrix 1 should be equal to height of matrix 2.");
//    }

    public T mean() {
        BigDecimal summ = BigDecimal.valueOf(0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                summ = summ.add((BigDecimal) matrix[i][j]);
            }
        }

        return (T) (summ.divide(BigDecimal.valueOf(this.rows * this.cols)));
    }

    public T min() {
        BigDecimal minValue = (BigDecimal) matrix[0][0];
        int row = 0;
        int col = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (minValue.compareTo((BigDecimal) matrix[i][j]) > 0) {
                    minValue = (BigDecimal) matrix[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        return (T) matrix[row][col];
    }

    public T max() {
        BigDecimal maxValue = (BigDecimal) matrix[0][0];
        int row = 0;
        int col = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maxValue.compareTo((BigDecimal) matrix[i][j]) < 0) {
                    maxValue = (BigDecimal) matrix[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        return (T) matrix[row][col];
    }
}
