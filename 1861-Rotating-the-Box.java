class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int r = box.length;
        int c = box[0].length;
        char[][] rotatedBox = new char[c][r];
        int row = 0;
        int col = 0;
        for (int i = 0; i < c; i++) {
            for (int j = r-1; j >= 0; j--) {
                rotatedBox[col][row] = box[j][i];
                row++;
            }
            row = 0;
            col++;
        }

        // print rotated box
        // for (int i = 0 ; i < c; i++) {
        //     for (int j = 0; j < r; j++) {
        //         System.out.print(rotatedBox[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // return rotatedBox;

        for (int i = c-2; i >= 0; i--) {
            for (int j = 0; j < r; j++) {
                int temp = i;
                while (temp < c-1 && rotatedBox[temp][j] == '#' && rotatedBox[temp+1][j] == '.') {
                    rotatedBox[temp][j] = '.';
                    rotatedBox[temp+1][j] = '#';
                    temp++;
                } 
            }
        }
        return rotatedBox;
    }
}