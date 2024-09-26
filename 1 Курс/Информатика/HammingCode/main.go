package main

import (
   "fmt"
   "bufio"
   "os"
)

func main() {
   fmt.Println("Введите набор из 7 чисел '0' и '1', записанных подряд без пробелов.")
   reader := bufio.NewReader(os.Stdin)
   s, _ := reader.ReadString('\n')
   
   // Проверка на корректность введённых данных
   for !IsCorrectSignal(s[:len(s) - 2]) {
      fmt.Printf("Введен набор символов, не соответствующий условию. Повторите попытку ввода:\n")
      s, _ = reader.ReadString('\n')
   }
   
   // Получение исправленной последованности информационных битов, места ошибки и изначальной
   // последовательности информационных битов
   correctBits, err, infoBits := HammingAnalysis(s[:len(s) - 2], 7, 4)

   // Получение информации об ошибки на индексе err
   errorPlace := GetInfoAboutError(s[:len(s) - 2], err)

   fmt.Printf("Анализ на основе классического кода Хэмминга:\n")
   if err == -1 {
      fmt.Printf("Ошибок в сообщении не обнаружено.\n")
   } else if DeleteAllStars(infoBits, -1) == correctBits {
      fmt.Printf("Допущена ошибка в %d бите%s. Так как это бит чётности, то последовательность информационных битов корректна изначально и равна %s.", err + 1, errorPlace, correctBits)
   } else {
      fmt.Printf("Допущена ошибка в %d бите%s. Корректная последовательность информационных битов равна %s.", err + 1, errorPlace, correctBits)
   }
   
}

