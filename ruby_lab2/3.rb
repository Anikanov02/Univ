value = "1000010001"

def binToDec(value)
    value.reverse.chars.map.with_index do |digit, index|
        digit.to_i * 2**index
    end.sum
end

puts "binary = #{value}, decimal = #{binToDec(value)}"