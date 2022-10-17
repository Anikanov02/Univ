
PI = 3.14.to_f

def prm(a, b, n)
    dx = (b - a) / n
    x = a + dx / 2
    sum = 0
    (1..n).each {
      y = yield(x)
      sum += dx * y
      x += dx
    }
    return sum
  end
  
  def trp(a, b, n)
    dx = (b - a) / n
    x = a + dx
    sum = dx * (yield(a) / 2 - yield(b) / 2)
    loop {
      y = yield(x)
      sum += dx * y
      x += dx
      break if x >= b
    }
    return sum
  end
  
  def f1(x)
    return (1.0 / ((x+1)*Math.sqrt(x**2+1)))
  end
  
  def f2(x)
    return (Math.tan(x/2 + PI/4)**3)
  end

  print "first func: \n"
  res = prm(0.3, 0.3, 100000.0) {|x| f1(x)}
  puts res, "\n"
  res = trp(0.3, 0.3, 100000.0) {|x| f1(x)}
  puts res, "\n"
  
  print "second func:\n"
  res = prm(0.0, PI/4, 10000.0) {|x| f2(x)}
  puts res, "\n"
  res = trp(0.0, PI/4, 10000.0) {|x| f2(x)}
  puts res, "\n"