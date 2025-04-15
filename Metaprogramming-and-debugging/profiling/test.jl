using BenchmarkTools
using Random

function f()
  lst = rand(50000)
  for i in lst
    
    if i > 0.99
      s = "List entry $(i)\r" # The \r makes it so the terminal isn't filled
      print(s)
    end
  end
end

f()
@time f()
x = @benchmark f()
println()
println(x)
