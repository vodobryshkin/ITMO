// Файл с функциями, связанными с анализом с использованием кода Хэмминга
package main

import (
   "fmt"
   "math"
)

// Функция, возвращающая результат сложения по модулю два для двух переменных
func SumMod2(x rune, y rune) rune {
   if x == y {return '0'}
   return '1'
}

// Функция, возвразающая результата сложения по модулю два для последовательности переменных.
// Результатом работы функции будет являться контрольная сумма
func SubSumMod2(s string) string {
   result := SumMod2(rune(s[0]), rune(s[1]))
   
   for i := 2; i < len(s); i++ {
      result = SumMod2(result, rune(s[i]))
   }
   
   return string(result)
}

// Функция, которая строит таблицу Хэмминга для сообщения s с заданными параметрами кодирования
func GetTableAndInfoBits(s string, allVal int, iVal int) ([]string, string) {
   var table []string // таблица, которая будет получена в результате
   var ss2 float64 // текущая степень двойки 
   infoBits := "" // последовательность информационных битов
   
   for i := 0; i < len(s); i++ {
      // Проверка на то, является ли данный бит контрольным или нет. Все контрольные биты стоят по
      // номерам, равным степеням двойки
      if float64(i + 1) == math.Pow(2, ss2) {
         line := ""
         
         // Если является, то формируется последовательность с шагом, который зависит от данной
         // степени двойки. Последовательность представляет из себя строку, куда записываются
         // значения данного бита четности, и всех информационных битов, которые он охватывает 
         for j := i; j < len(s); j += (i + 1) * 2 {
            line += s[j: j + i + 1]
         }

         table = append(table, line)
         ss2 += 1 // расчитывается следующая степень двойки
         infoBits += "*" // показывается, что на данном месте был бит четности
      } else {
         infoBits += string(s[i])
      }
   }

   return table, infoBits
}

// Функция для нахождения индекса ошибки в исходной последовательности
func CatchErrorIndex(result string) int {
   err := -1

   for i := 0; i < len(result); i++ {
      err += int(float64(int(result[i]) - 48) * math.Pow(2, float64(i))) 
   }
   
   return err
}

// Функция для получения информации об ошибочном бите (вид и номер в последовательности)
func GetInfoAboutError(s string, err int) string {
   var ss2 float64
   infoCounter := 1
   chtCounter := 1

   for i := 0; i < len(s); i++ {
      // Если iтый бит - бит четности
      if float64(i + 1) == math.Pow(2, ss2) {
         if i == err {
            return fmt.Sprintf("(%d бит четности; ошибочное значение %c)", chtCounter, s[i])
         }
         
         chtCounter++
         ss2 += 1
      } else { // Если iтый бит - информционный бит
         if i == err {
            return fmt.Sprintf("(%d информационный бит; ошибочное значение %c)", infoCounter, s[i])
         }

         infoCounter++
      }
   }

   return ""
}

// Функция, реализующая алгоритм, основанный на коде Хэмминга
func HammingAnalysis(s string, allVal int, iVal int) (string, int, string) {
   table, infoBits := GetTableAndInfoBits(s, allVal, iVal)
   sumMod2 := ""

   for _, line := range (table) {
      sumMod2 += SubSumMod2(line)
   }
   
   err := CatchErrorIndex(sumMod2)
   
   return DeleteAllStars(infoBits, err), err, infoBits
}
