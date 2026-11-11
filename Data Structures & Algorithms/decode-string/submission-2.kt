class Solution {
    fun decodeString(s: String): String {
        var i = 0
        fun decode(): String {                          // s = "2[a3[b]]c"   [abb]                
            val builder = StringBuilder()               // i = 8
            var number = 0                              // number = 2       //  number = 3      
            while (i < s.length) {                  
                val c = s[i]                            // c = [            // c = [            
                if (c in '0'..'9') {                    //                  //
                    number = number * 10 + (c - '0')
                    i++                                 //                  // s = b
                } else if (c == '[') {
                    i++
                    builder.repeat(decode(), number)
                    number = 0
                } else if (c == ']') {
                    i++
                    return builder.toString() 
                } else {
                    builder.append(c)
                    i++
                }
            }

            return builder.toString()
        }
        return decode()
    }
}
