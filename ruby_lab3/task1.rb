
def first(a, b, c, x, y, z)
  puts "first:"
  puts "a) !(a || b) && (a && !b) = #{!(a || b) && (a && !b)}"
  puts "b) (z != y) <= (6 >= Y) && a || b && c && x>=1.5 = #{(z != y) == (6 >= y) && a || b && c && x>=1.5}"
  puts "c) (8 - x * 2 <= z) && (x^2 <> y^2) ||  (z >= 15) = #{(8 - x * 2 <= z) && (x**2 <= y**2) ||  (z >= 15)}"
  puts "d) x > 0 && y < 0 || z >= (x * y - (-y / x)) + (-z) = #{x > 0 && y < 0 || z >= (x * y - (-y / x)) + (-z)}"
  puts "e) !(a || b && !(c || (!a || b))) = #{!(a || b && !(c || (!a || b)))}"
  puts "f) x^2 + y^2 >= 1 && x >= 0 && y >= 0 = #{x^2 + y^2 >= 1 && x >= 0 && y >= 0}"
  puts "g) (a && (c && b == b || a) || c) && b = #{(a && (c && b == b || a) || c) && b}"
end

def second(a, p)
  ((Math.log(a)>a) || !p) && ((Math.sqrt(a)<x**4))
end

puts first(true, false, true, 2, 10, -50)
puts "second: #{second(2.5, true)}"