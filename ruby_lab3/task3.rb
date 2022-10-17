
def var2
    sum = 0
    (0..8).each { |i|
      sum += 1.0 / (3 ** i)
    }
    sum
end

def var3(x)
    print "Enter n: "
    n = gets.chomp.to_i
  
    sum = 0
    fact = 1
    (0..n + 1).each {
      |i|
      sum += (x.to_f ** i) / fact
      fact *= (i + 1)
    }
  
    return sum
  end
  
  puts "Sum for var2 = #{var2}\n"
puts "Sum for var3 = #{var3(1)}"

  