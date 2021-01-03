package task1_eh;

import task1_eh.exception.IncorrectInputMatrixException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** @author Andrey Egorov */
public class Main {

  private static final Pattern REGEX_FOR_MATRIX_VALIDATION =
      Pattern.compile("^(([ \\t]*[0-1]{1}[ \\t]*){1}([ \\t]+[0-1]{1})*[ \\t]*)$");

  public static void main(String[] args) {

    List<String> fileLines = new ArrayList<>();

    readFileLinesToArray(fileLines);

    int[][] count = countAmountOfNeighborsForEachCellInMatrix(fileLines);

    writeMatrixToFile(count);
  }

  public static void readFileLinesToArray(final List<String> fileLines) {
    try (Scanner s = new Scanner(new File("src\\task1_eh\\data\\input.txt"))) {
      String str;
      while (s.hasNext()) {
        str = s.nextLine();
        if (str.trim().isBlank()) {
          break;
        }
        fileLines.add(str);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static int[][] countAmountOfNeighborsForEachCellInMatrix(final List<String> fileLines) {

    boolean isCorrectInputMatrix = true;
    int[][] inputBinaryMatrix = new int[fileLines.size()][];
    int[][] answerMatrixWithAmountOfNeighborsForEachCell = new int[0][0];

    Matcher matcher;
    for (int i = 0; i < fileLines.size(); i++) {
      try {
        matcher = REGEX_FOR_MATRIX_VALIDATION.matcher(fileLines.get(i));
        if (matcher.matches()) {
          inputBinaryMatrix[i] =
              Arrays.stream(
                      fileLines
                          .get(i)
                          .replaceAll("\t", " ")
                          .replaceAll("[ ]{2,}", " ")
                          .trim()
                          .split(" "))
                  .mapToInt(Integer::parseInt)
                  .toArray();
        } else {
          isCorrectInputMatrix = false;
          throw new IncorrectInputMatrixException("Matrix should only contain 0 and 1");
        }
      } catch (IncorrectInputMatrixException e) {
        e.printStackTrace();
      }
    }

    if (isCorrectInputMatrix && fileLines.size() > 0) {

      answerMatrixWithAmountOfNeighborsForEachCell =
          new int[inputBinaryMatrix.length][inputBinaryMatrix[0].length];

      int N = inputBinaryMatrix.length;
      int M = inputBinaryMatrix[0].length;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (i - 1 > -1 && j - 1 > -1 && inputBinaryMatrix[i - 1][j - 1] == 1) {
            answerMatrixWithAmountOfNeighborsForEachCell[i][j]++;
          }
          if (i - 1 > -1 && inputBinaryMatrix[i - 1][j] == 1) {
            answerMatrixWithAmountOfNeighborsForEachCell[i][j]++;
          }
          if (i - 1 > -1 && j + 1 < M && inputBinaryMatrix[i - 1][j + 1] == 1) {
            answerMatrixWithAmountOfNeighborsForEachCell[i][j]++;
          }
          if (j - 1 > -1 && inputBinaryMatrix[i][j - 1] == 1) {
            answerMatrixWithAmountOfNeighborsForEachCell[i][j]++;
          }
          if (j + 1 < M && inputBinaryMatrix[i][j + 1] == 1) {
            answerMatrixWithAmountOfNeighborsForEachCell[i][j]++;
          }
          if (i + 1 < N && j - 1 > -1 && inputBinaryMatrix[i + 1][j - 1] == 1) {
            answerMatrixWithAmountOfNeighborsForEachCell[i][j]++;
          }
          if (i + 1 < N && inputBinaryMatrix[i + 1][j] == 1) {
            answerMatrixWithAmountOfNeighborsForEachCell[i][j]++;
          }
          if (i + 1 < N && j + 1 < M && inputBinaryMatrix[i + 1][j + 1] == 1) {
            answerMatrixWithAmountOfNeighborsForEachCell[i][j]++;
          }
        }
      }
    }
    return answerMatrixWithAmountOfNeighborsForEachCell;
  }

  public static void writeMatrixToFile(final int[][] matrix) {
    try (Writer writer = new BufferedWriter(new FileWriter("src\\task1_eh\\data\\output.txt"))) {
      int M = matrix.length > 0 ? matrix[0].length : 0;
      for (int[] ints : matrix) {
        for (int j = 0; j < M; j++) {
          writer.write(ints[j] + " ");
        }
        writer.write("\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
