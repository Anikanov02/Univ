require 'bigdecimal'

def function(a, b, c, x)
  is_whole = (a.to_i | b.to_i) & (a.to_i | c.to_i) == 0
  result = if x < 0 && b != 0
             a * x ** 2 + b
           elsif x > 0 && b == 0
             (x - a).quo(x - c)
           else
             x.quo c
           end
  if is_whole
    result.to_i
  else
    result.to_s('F').to_f
  end
end

a = BigDecimal(gets.chomp)
b = BigDecimal(gets.chomp)
c = BigDecimal(gets.chomp)
x_start = BigDecimal(gets.chomp)
x_end = BigDecimal(gets.chomp)
dx = BigDecimal(gets.chomp)

raise "x_start must be <= than x_end" if x_start > x_end
raise "dx must be" if dx <= 0

x_start.step(x_end, dx) do|x|
   puts "x = " + x.to_s('F') + "; f(x) = " + function(a, b, c, x).to_s
end