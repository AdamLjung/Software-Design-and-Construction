macro doWhile(block, cond)
  println("__source__ ", __source__)
  println("cond ", cond)
  println("block ", block)
  res = quote
    $block
    while $cond
      $block
    end
    #error("TODO: Your code here")
  end |> esc
  println(res) # For debugging; should not print any lines referencing dowhile.jl if doing the optional part
  res
end
