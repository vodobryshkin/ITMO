// Вариант 29774
public class Lab1 {
   // Статичный метод для вычисления элемента матрицы
   public static float calculateElement(short r, float x) {
      switch (r) {
         case 11: 
            return (float) Math.atan(Math.sin(x));
         case 4, 6, 7, 12, 13, 15, 16, 17:
            return 2 * (float) Math.atan(Math.sin(x));
         default:
            // Заметим, что f(x) = e^ln(x) <=> f(x) = x
            // тогда нужно учитывать лишь значение арккосинуса
            return (float) Math.acos(Math.pow((x + 2) / 26, 2f));
      }
   }
   
   // Статичный метод для вывода матрицы
   public static void printMatrix(float[][] m) {
      for (var i = 0; i < m.length; i++) {
         for (var j = 0; j < m[i].length; j++) {
            System.out.printf("%.03f\t", m[i][j]);
         }
         System.out.printf("\n");
      }
   }

   public static void main(String[]  args) {
      // Создание одномерного массива z типа short 
      short[] z = new short[17];
      
      // Заполнение массива r числами от 4 до 20
      for (short i = 4; i <= 20; i++) {
         z[i - 4] = i;
      }

      // Создание одномерного массива x типа float
      float[] x = new float[15];

      // Заполнение массива r случайными числами в диапозоне от -11.0 до 15.0
      for (var i = 0; i < 15; i++) {
         x[i] = (float)((Math.random() * 24.0 - 11.0));
      }
      
      // Создание двумерного массива w
      float[][] w = new float[17][15];

      // Вычисление элементов массива w
      for (var i = 0; i < 17; i++) {
         for (var j = 0; j < 15; j++) {
            // Вычисление элемента матрицы с помощью статичного метода calculateElement
            w[i][j] = calculateElement(z[i], x[j]);
         }
      }

      // Вывод матрицы с помощью статичного метода printMatrix
      printMatrix(w);
   }
}
