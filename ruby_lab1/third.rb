print "Enter x: \n"
$x = gets.chomp.to_f

print "Enter a,b,c,fi: \n"
$a = gets.chomp.to_f
$b = gets.chomp.to_f
$c = gets.chomp.to_f
$fi = gets.chomp.to_f

$D = $b**2 - 4*$a*$c
if $D >= 0 
    print "Prevented division by 0"
    return
end

$result = (Math.sin(3*$x)**3 + Math.atan($fi) - 6*(10**3.1)) / (Math.sqrt($a*($x**2)+$b*$x+$c)) + Math.exp($x) * (Math.tan($x+2)).abs

print "Result = " + $result.to_s, "\n"