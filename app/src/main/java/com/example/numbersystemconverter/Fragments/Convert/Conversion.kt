package com.example.numbersystemconverter.Fragments.Convert

class Conversion {

    //Decimal Conversion
    fun decimal_to_binary(num:Long):String{
        var decimal = num
        var binary = StringBuilder()
        var rem:Long=0
        while (decimal>=1){
            rem=decimal%2
            binary.append(rem)
            decimal=decimal/2
        }
        return binary.toString()
    }
    fun decimal_to_octal(num: Long):String{
        var decimal=num
        var octal = StringBuilder()
        var rem:Long = 0
        while (decimal>=1){
            rem=decimal%8
            octal.append(rem)
            decimal/=8
        }
        return octal.reverse().toString()
    }
    fun decimal_to_hexadecimal(res: Long):String{
        var decimal = res
        var hexanumber:Long=0
        var string=StringBuilder()

        while (decimal >= 1){
            var num:Long=decimal%16
            hexanumber=num
            if (num>=10){
                when(num.toInt()){
                    10->string.append("A")
                    11->string.append("B")
                    12->string.append("C")
                    13->string.append("D")
                    14->string.append("E")
                    15->string.append("F")
                }
            }else{
                string.append(hexanumber)
            }
            decimal=decimal/16

        }
        var hexcode=string.reverse()
        return hexcode.toString()

    }

    //Binary Conversion
    fun binary_to_decimal(res: Long):String{
        var binary:Long = res
        var weight = 1
        var rem:Long = 0
        var decimal=StringBuilder()
        var temp:Long=0
        while (binary>=1){
            rem = binary%10
            temp=temp+rem*weight
            binary/=10
            weight*=2
        }
        decimal.append(temp)
        return decimal.toString()
    }
    fun binary_to_octal(res: Long):String{
        var num:Long=binary_to_decimal(res).toLong()
        return decimal_to_octal(num)
    }
    fun binary_to_hexadecimal(res: Long):String{
        var num=binary_to_decimal(res)
        return decimal_to_hexadecimal(num.toLong())
    }

    //Octal Conversion

    fun octal_to_decimal(res: Long):String{
        var octal=res
        var decimal:Long=0
        var i:Long=0
        while (octal >= 1){
            var n:Long=Math.pow(8.0, i++.toDouble()).toLong()
            decimal+=(octal%10)*n
            octal=octal/10
        }
        return decimal.toString()
    }
    fun octal_to_binary(res: Long):String{
        var num=octal_to_decimal(res).toLong()
        return decimal_to_binary(num)
    }
    fun octal_to_hexcode(res: Long):String{
        var num = octal_to_decimal(res).toLong()
        return decimal_to_hexadecimal(num)
    }

    //Hexadecimal Conversion

    fun hex_to_decimal(res: String):String{
        var hex=res
        hex=hex.reversed()
        var i = 0;
        var temp=0
        while (i<hex.length){
            when(hex[i].toString()){
                "A"->{
                    temp=(temp+10*Math.pow(16.0,i.toDouble())).toInt()
                }
                "B"->{
                    temp=(temp+11*Math.pow(16.0,i.toDouble())).toInt()
                }
                "C"->{
                    temp=(temp+12*Math.pow(16.0,i.toDouble())).toInt()
                }
                "D"->{
                    temp=(temp+13*Math.pow(16.0,i.toDouble())).toInt()
                }
                "E"->{
                    temp=(temp+14*Math.pow(16.0,i.toDouble())).toInt()
                }
                "F"->{
                    temp=(temp+15*Math.pow(16.0,i.toDouble())).toInt()
                }
                else->{
                    var a = hex[i].toString().toInt()
                    temp+=a*Math.pow(16.0,i.toDouble()).toInt()
                }
            }
            i++
        }
        return temp.toString()

    }
    fun hex_to_binary(res: String):String{
        var hex=hex_to_decimal(res)
        return decimal_to_binary(hex.toString().toLong())
    }
    fun hex_to_octal(res: String):String{
        var octal=hex_to_decimal(res)
        return decimal_to_octal(octal.toLong())
    }



}

















