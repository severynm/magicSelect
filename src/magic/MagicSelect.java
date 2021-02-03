package magic;

import java.util.HashSet;
import java.util.Set;

public class MagicSelect {

    public static void main(String[] args) {
        Pixel start = new Pixel(2, 2);
        int[][] matrix = {
                {1, 1, 2, 2, 2, 2},
                {1, 2, 2, 1, 1, 1},
                {1, 2, 1, 1, 2, 2}
        };
        select(start, matrix).forEach(System.out::println);

    }

    private static Set<Pixel> select(Pixel start, int[][] matrix) {
        Set<Pixel> result = new HashSet<>();
        doSelect(start, matrix, result);
        return result;
    }

    private static void doSelect(Pixel start, int[][] matrix, Set<Pixel> result) {
        int x = start.getX();
        int y = start.getY();
        int color = matrix[x][y];

        int fromX = Math.max(0, x - 1);
        int toX = Math.min(matrix.length - 1, x + 1);
        int fromY = Math.max(0, y - 1);
        int toY = Math.min(matrix[x].length - 1, y + 1);

        for (int i = fromX; i <= toX; i++) {
            for (int j = fromY; j <= toY; j++) {
                if (color == matrix[i][j]) {
                    Pixel currentPixel = new Pixel(i, j);
                    if (!result.contains(currentPixel)) {
                        result.add(start);
                        doSelect(currentPixel, matrix, result);
                    }
                }
            }
        }
    }
}

class Pixel {

    private final int x;
    private final int y;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pixel pixel = (Pixel) o;

        if (x != pixel.x) return false;
        return y == pixel.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Pixel{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
