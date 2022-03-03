package edu.pdx.cs410J.ensemble3;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * A class for getting started with a code kata
 *
 * Use IntelliJ's "Refactor | Rename..." command to change the name of this
 * class (and its tests).
 */
public class Kata {
                                                                                    

  public static void main(String[] args) throws IOException {
    InputStream inputStream = Kata.class.getResourceAsStream("testInput.txt");
    assert inputStream != null; // we can do assert statements here? cool

    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

    for (int fieldNo = 1; br.ready(); fieldNo++) {
      String[] sizes = br.readLine().split(" ");
      int rows = Integer.parseInt(sizes[0]);
      int cols = Integer.parseInt(sizes[1]);
      int[][] mineField = readOneMinefield(br, rows, cols);
      calculateAdjacentMines(mineField, rows, cols);

      if (rows != 0 && cols != 0) {
        System.out.println();
        System.out.println("Field #" + fieldNo + ":");
        printMinefield(mineField, rows, cols);
      }
    }

    System.exit(0);
  }

  static int[][] readOneMinefield(BufferedReader br, int rows, int cols) throws IOException {
    int[][] minefield = new int[rows][cols];

    for (int row = 0; row < rows; row++) {
      String currentLine = br.readLine();

      for (int col = 0; col < cols; col++) {
        if (currentLine.charAt(col) == '*') {
          minefield[row][col] = -1;
        } else {
          minefield[row][col] = 0;
        }
      }
    }

    return minefield;
  }

  static void calculateAdjacentMines(int[][] minefield, int rows, int cols) {
    List<Integer> rowOffsets = List.of(-1, -1, -1,  0, 1, 1,  1,  0);
    List<Integer> colOffsets = List.of(-1,  0,  1,  1, 1, 0, -1, -1);

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {

        if (minefield[row][col] < 0) {
          for (int i = 0; i < rowOffsets.size(); i++) {
            int rowOffset = rowOffsets.get(i);
            int colOffset = colOffsets.get(i);

            try {
              int adjacentCell = minefield[row + rowOffset][col + colOffset];
              if (adjacentCell != -1) {
                minefield[row + rowOffset][col + colOffset]++;
              }
            } catch (Exception e) {
              // TODO: implement
            }

          }
        }
      }
    }
  }

  static void printMinefield(int[][] minefield, int rows, int cols) {
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (minefield[row][col] == -1) {
          System.out.print("*");
        } else {
          System.out.print(minefield[row][col]);
        }
      }

      System.out.println();
    }
  }
}