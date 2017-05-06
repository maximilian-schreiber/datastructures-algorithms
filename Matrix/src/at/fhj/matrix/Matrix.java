package at.fhj.matrix;

/**
 * Implements standard operations on matrices consisting of integer numbers
 */

public class Matrix {

    // 2-dimensional int-array for storing Matrix elements
    // The first dimension gives the row, the second the column
    // I.e.: daten[0][1] specifies the element in the first row
    // and second column
    int[][] daten;

    // actual number of rows and columns
    int numRows, numCols;


    /**
     * Create an empty Matrix with no rows and columns
     */
    public Matrix() {
        this.numRows = this.numCols = 0;
        this.daten = null;
    }

    /**
     * Create a new Matrix with a given number of rows and columns
     * Matrix meineMatrix = new Matrix(2,2);
     * Matrix meineMatrix = new Matrix();
     * Matrix meineMatrix = new Matrix(2,2,2);
     * @param numRows number of rows
     * @param numCols number of columns
     */
    public Matrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        daten = new int[numRows][numCols];
    }

    /**
     * Create a new Matrix with a given number of rows and columns
     * and initialize all fields with a given value
     *
     * @param numRows number of rows
     * @param numCols number of columns
     * @param val     initialization value
     */

    public Matrix(int numRows, int numCols, int val) {
        this(numRows, numCols);
        setAll(val);
    }

    /**
     * Create a new Matrix from a 2-dimensional array by copying
     * every single "int" element from the array into a newly
     * allocated "daten" attribute (i.e. "daten" is a real copy of
     * parameter "a" and MUST NOT refer to "a")
     *
     * @param a 2-dimensional array holding the matrix values
     */
    public Matrix(int[][] a) {
        this(a.length, a[0].length);
        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column < numCols; column++) {
                daten[row][column] = a[row][column];
            }
        }
    }

    /**
     * Get the number of rows of the matrix
     *
     * @return number of rows
     */
    public int numRows() {

        return this.numRows;
    }

    /**
     * Get the number of columns of the matrix
     *
     * @return number of columns
     */
    public int numCols() {

        return this.numCols;
    }

    /**
     * Add Matrix m to this Matrix and return the result as new Matrix
     *
     * @param m Matrix to be added to this Matrix
     * @return new Matrix representing the result
     */


    public Matrix add(Matrix m) {
        for (int row = 0; row < this.numRows; row++) {
            for (int column = 0; column < this.numCols; column++) {
                this.daten[row][column] +=  m.daten[row][column];
            }
        }
        return this;
    }

    /**
     * Multiply Matrix m with this Matrix and return the result as new Matrix
     *
     * @param m Matrix to be multiplied with this Matrix
     * @return new Matrix representing the result
     */
    public Matrix mult(Matrix m) {
        Matrix ResultMatrix = new Matrix(this.numRows, m.numCols);
        for (int row = 0; row < this.numRows; row++) {
            for (int column = 0; column < m.numCols; column++) {
                for (int i = 0; i < this.numCols; i++) {
                    ResultMatrix.daten[row][column] += this.daten[row][i] * m.daten[i][column];
                }
            }
        }
        return ResultMatrix;
    }

    /**
     * Multiply a scalar integer value with this Matrix and return the result as
     * new Matrix
     *
     * @param k scalar integer value
     * @return new Matrix representing the result
     */
    public Matrix mult(int k) {
        for (int row = 0; row < this.numRows; row++) {
            for (int column = 0; column < this.numCols; column++) {
                this.daten[row][column] = this.daten[row][column] * k;
            }
        }
        return this;
    }

    /**
     * Compare if Matrix m equals this Matrix by comparing all elements
     *
     * @param m Matrix to compare to this Matrix
     * @return result of the compare operation
     */
    public boolean equals(Matrix m) {
        for (int row = 0; row < this.numRows; row++) {
            for (int column = 0; column < this.numCols; column++) {
                if (this.daten[row][column] != m.daten[row][column]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Get the element value on the given row and column position
     *
     * @param row
     * @param col
     * @return element value
     */
    public int get(int row, int col) {
        return daten[row][col];
    }

    /**
     * Set the element value on the given row and column position
     *
     * @param val
     * @param row
     * @param col
     */
    public void set(int val, int row, int col) {
        daten[row][col] = val;
    }

    /**
     * Set all elements of the Matrix to the given value
     *
     * @param val
     */
    public void setAll(int val) {

        for (int row = 0; row < numRows; row++)
            for (int col = 0; col < numCols; col++)
                daten[row][col] = val;
    }

}
