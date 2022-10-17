def fun(x, i)
  ((Math.log(3)**i)/(factorial(i))*(x**i))
end

def factorial(n)
  if n < 0
    return nil 
  end
  value = 1
  while n > 0
    value = value * n 
    n -= 1 
  end
  return value 
 end

def series(f, x, n)
  x_rage = 0.1..1
  n_range = 10..58
  error = 0.001

  unless x_rage.include? x
    raise "'x' is out of range"
  end

  res, i, cur = 0.0, n, error
  if n_range.include? n
    (1..n).each do |i|
      cur = f.call(x, i)
      res += cur
    end
  else
    i = 0
    while cur.abs >= error
      cur = f.call(x, i)
      res += cur
      i += 1
    end
  end
  [res, i, cur]
end

sum, iter, error = series(method(:fun), 0.5, 10)

puts "Sum: #{sum}"