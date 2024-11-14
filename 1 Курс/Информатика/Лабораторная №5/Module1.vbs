Function GETZF(rng As Range) As Double
    Dim cell As Range
    Dim total As Double
    total = 0
    For Each cell In rng
        If IsNumeric(cell.Value) Then
            total = total + cell.Value
        End If
    Next cell
    If total = 0 Then
        GETZF = 1
    Else
        GETZF = 0
    End If
End Function
Function GETPF(rng As Range) As Double
    Dim cell As Range
    Dim total As Double
    total = 0
    For Each cell In rng
        total = total + cell.Value
    Next cell
    If total Mod 2 = 0 Then
        GETPF = 1
    Else
        GETPF = 0
    End If
End Function
Function GETAF(num1 As Integer, num2 As Integer, num3 As Integer) As Double
    If num1 <> num2 And num3 = 0 Or num1 = num2 And num2 = num3 And num3 = 1 Then
        GETAF = 1
    Else
        GETAF = 0
    End If
End Function
Function GETCF(num As String) As Integer
    If num = " " Then
        GETCF = 0
    Else
        GETCF = 1
    End If
End Function
Function GETOF(num1 As Integer, num2 As Integer, num3 As Integer) As Integer
    If num1 = num2 And num2 <> num3 Then
        GETOF = 1
    Else
        GETOF = 0
    End If
End Function
Function GETSF(num1 As Double) As Double
    GETSF = num1
End Function
Function BINARY_RESULT(rng As Range) As Double
    Dim i As Long
    Dim total As Double
    Dim cell As Range
    Dim f As Integer
    Dim count As Long
    count = rng.count
    total = 0
    f = 1
    ss = count
    Set first_cell = rng.Cells(1)
    If first_cell.Value = 1 Then
        For i = count To 1 Step -1
            Set cell = rng.Cells(i)
            If IsNumeric(cell.Value) Then
                If (f = 1 And cell.Value = 1) Or (f = 0 And cell.Value = 0) Then
                    total = total + (2 ^ (count - ss))
                    If f = 1 And cell.Value = 1 Then
                        f = 0
                    End If
                End If
                ss = ss - 1
            End If
        Next i
        total = -1 * total
    Else
        For i = count To 1 Step -1
            Set cell = rng.Cells(i)
            If IsNumeric(cell.Value) Then
                total = total + (cell.Value * (2 ^ (count - ss)))
                ss = ss - 1
            End If
        Next i
    End If
    BINARY_RESULT = total
End Function
Function TEXT_RESULT(sign1 As Integer, sign2 As Integer, sign3 As Integer, res1 As Double, res2 As Double, OF As Integer, CF As Integer) As String
    Dim total As String
    total = "При сложении "
    If sign1 = sign2 Then
        total = total + "двух "
        If sign1 = 0 Then
            total = total + "положительных "
        Else
            total = total + "отрицательных "
        End If
        total = total + "слагаемых "
    Else
        If sign1 = 1 Then
            total = total + "отрицательного и положительного слагаемых "
        Else
            total = total + "положительного и отрицательного слагаемых "
        End If
    End If
    total = total + "получено "
    If sign3 = 0 Then
        total = total + "положительное "
    Else
        total = total + "отрицательное "
    End If
    total = total + "число. "
    If res1 <> res2 Then
        total = total + "Результат выполненной операции неверный и некорректный, ввиду возникающего "
        If OF = 1 And CF = 1 Then
            total = total + "переполнения и возникающего переноса в старший разряд "
        Else
            If OF = 1 And CF = 0 Then
                total = total + "переполнения"
            Else
                If CF = 1 And OF = 0 Then
                    total = total + "переноса в старший разряд"
                End If
            End If
        End If
        total = total + ", не совпадает с суммой десятичных эквивалентов."
    Else
        total = total + "Результат выполненной операции верный и корректный, совпадает с суммой десятичных эквивалентов."
    End If
    TEXT_RESULT = total
End Function
