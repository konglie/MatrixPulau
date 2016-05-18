/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixpulau;

/**
 *
 * @author lee
 */
public class Pulau {

    private final int[][] matrix;
    private final int n;

    public Pulau(int[][] matrix) {
        this.matrix = matrix;
        n = matrix.length;
    }

    private void cek(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n) {
            return;
        }

        if (matrix[i][j] == 1) {
            matrix[i][j] = 0;

            /*
             a  b  c
             d  x  e
             f  g  h

             posisi saat ini, ada di x
             */
            // posisi a
            cek(i - 1, j - 1);

            // posisi b
            cek(i, j - 1);

            // posisi c
            cek(i - 1, j + 1);

            // posisi d
            cek(i - 1, j);

            // posisi e
            cek(i + 1, j);

            // posisi f
            cek(i + 1, j - 1);

            // posisi g
            cek(i, j + 1);

            // posisi h
            cek(i + 1, j + 1);
        }
    }

    public int hitung() {
        if (n < 1) {
            return 0;
        }

        int i, j, result = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    result += 1;
                    cek(i, j);
                }
            }
        }

        return result;
    }
}
