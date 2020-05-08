package FirstLesson

import groovy.lang.Binding



FirstClass example1 = new FirstClass( "exz1",  567)

Binding binding = new Binding()
binding.setVariable("name","exz2")
binding.setVariable("count","2222")
FirstClass example2 = new FirstClass(binding)

example2.setProperty("count",333)

println example2.getProperty("name")
println example2.getProperty("count")

println "${example2.getInt()} - method without return"



