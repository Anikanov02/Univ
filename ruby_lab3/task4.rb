
epsilon = 0.00001

def factorial(n)
   x = n > 1 ? n * factorial(n - 1) : 1
   x.to_f
end

def task1()
  sum = 0.0
  n = 2.0
  loop do
    current = (1.0/(n * (n + 1.0))) ** (n * (n + 1))
    sum += current
    if (current.abs <= 0.00001)
      break
    end
    n += 1
  end

  sum
end
  
def task2(x)
  n = 0
  sum = 0
  sum2 = Math.log(x)/2
  loop do
    sum += ((x-1)**(2*n+1)).to_f/((2*n+1)*((x+1)**(2*n+1)))
    if ((sum - sum2).abs <= 0.00001)
      break
    end
    n += 1 
  end
  sum
end
  

def task3
  n = 1
  sum = 0
  current = 0
  loop do
    current = (factorial(4*n-1) * factorial(2*n-1)) / (factorial(4*n)*(2**(2*n))*factorial(2*n))
    sum += current
    if(current.abs<= 0.00001)
      break
    end
    n +=1
  end
  sum
end
  



puts "task1 = #{task1().to_s}\n"
puts "task2 = #{task2(2).to_s}\n"
puts "task3 = #{task3().to_s}\n"