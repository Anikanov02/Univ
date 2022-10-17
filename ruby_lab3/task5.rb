PI = 3.141


def y(x,n,c)

    if(x==0 || x==1 || n<0) 
      abort("func can't X=0 or X==1!")
    end
    (x**(1.0/4) - (1.0/x)**(1.0/4))**(-n) + (x+1)/(x**2-4*x+3*n) + ( ((36*x*c*n)**(1.0/4)).to_f/( (x+c*n+1)/(x+5)) )
end

#x!=0
def z(x,n,c)
    if(x==0)
        abort("func can't X=0!")
    end
    (Math.tan(2*x)*(Math.cos(2*x)**(-1.0)) - Math.tan(2*c+x)*(Math.cos(2*x)**(-2.0)))/(Math.cos(2*x)**(-1) + Math.cos(3*x)**(-2)) + (1+Math.cos(n*x)**(1.0/c))/(2*x+Math.sin(3*x)**2)
end

#step = (xLast - xFirst)/Amount 

def task1(n, c)
    step = (n - 1).to_f / (n + c)
    x = 2
    (n + c).times do
      puts "y(#{x}, #{n}, #{c}) = #{y(x, n, c)}"
      x += step
    end
end

def task2(n, c)
    step = (PI - (PI / n)).to_f / ((3 / 2) * n + c)
    x = PI / n
    ((3 / 2) * n + c).times do
      puts "z(#{x}, #{n}, #{c}) = #{z(x, n, c)}"
      x += step
    end
end

def task3(n, c)
    step = (c - 2).to_f / (2 * n)
    x = 2
    (2 * n).times do
      if 2 < x and x < n
        puts "f=y: y(#{x}, #{n}, #{c}) = #{y(x, n, c)}"
      elsif n < x and x < 2 * n
        puts "f=z: z(#{x}, #{n}, #{c}) = #{z(x, n, c)}"
      else
        puts "f=y+z : y(#{x}, #{n}) + z(#{x}, #{n}, #{c}) = #{y(x, n, c) + z(x, n, c)}"
      end
      x += step
    end
end


task1(4,5)
task2(4,5)
task3(4,5)
puts "y= #{y(7,3,5)}"
puts "z= #{z(7,3,5)}"