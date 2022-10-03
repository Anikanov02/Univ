$square = 0

dots = [[150,49], [221,78], [219,212], [208,158], [167,182],
[108,192], [72,171], [59,133], [76,115], [91,97],
[75,78], [67,58], [79,49], [98,30], [118,22],
[136,30], [143,37]]

for i in 0..dots.size-1 do
  if i == dots.size-1
    $square += (dots[i][0] + dots[0][0]) * (dots[0][1] - dots[i][1])
  else
    $square += (dots[i][0] + dots[i+1][0]) * (dots[i + 1][1]-dots[i][1])
  end
end

$result = $square.abs / 2
print "Result = " + $result.to_s, "\n"