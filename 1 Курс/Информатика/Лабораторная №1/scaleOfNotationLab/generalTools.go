// Файл с общими методами, напрямую не связанными с работой с системами счисления
package main

import (
   "math/big"
)

// Функция для проверки наличия строки в строковом слайсе
func arrayContainsNum (array []string, n string) bool {
   for _, s := range array {
      if n == s {
         return true
      }
   }

   return false
}

// Функция для проверки наличия символа в строке
func stringContainsRune (s string, n rune) bool {
   for _, ch := range s {
      if n == ch {
         return true
      }
   }

   return false
}

// Функция для перевода строки в целое число
func stringToInt(s string) int64 {
   n, d := 0, 1
   
   for i := len(s) - 1; i >= 0; i-- {
      n += (int(s[i]) - 48) * d
      d *= 10
   }

   return int64(n)
}

// Функция для переворота массива типа big.Int
func reverseBigIntArray(array []*big.Int) []*big.Int {
   for i, j := 0, len(array) - 1; i < j; i, j = i + 1, j - 1 {
      array[i], array[j] = array[j], array[i]
   }

   return array
}

// Функция для проверки корректности записи числа в десятичной системе счилсения
func inTenRadix(n string) bool {
   goodSymb := "0123456789"

   for _, r := range(n[:len(n) - 2]) {
      if !stringContainsRune(goodSymb, r) {
         return false
      }
   }

   return true
}

