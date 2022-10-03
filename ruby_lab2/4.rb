value = 123

def decToBin(value)
    val = ''

    while value > 0
        val += (value % 2).to_s
        value /= 2
    end
    return val.reverse
end
 
puts "decimal = #{value}, binary = #{decToBin(value)}"