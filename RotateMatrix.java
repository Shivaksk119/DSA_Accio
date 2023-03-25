import java.util.*;

class RotateMatrix {
    public int[][] RotateMat(int[][] mat, int[][] mat2, int row, int col, int col2, int n) {
		if (col>n-1) {
			return mat2;
		}
		if (row<0 || col2>n-1) {
			row=n-1;
			col2 = 0;
			return RotateMat(mat, mat2, row, col+1, col2, n);
		}
		mat2[col][col2] = mat[row][col];
		return RotateMat(mat, mat2, row-1, col, col2+1, n);
	}
    public int[][] MatRotateRecur(int[][] mat) {
		int n = mat.length;
		int row = n-1;
		int col = 0;
		int col2 = 0;
		int[][] mat2 = new int[n][n];
		return RotateMat(mat, mat2, row, col, col2, n);
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        }
        sc.close();
        RotateMatrix Obj = new RotateMatrix();
        int[][] ans = Obj.MatRotateRecur(mat);

        for(int[] ar : ans) {
            for(int a : ar)
                System.out.print(a + " ");
            System.out.println();
        }
    }
}
