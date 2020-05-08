package FirstLesson

class FirstClass {
    private String name;
    private Integer count;

    FirstClass(String name, count) {
        this.name = name
        this.count = count
    }


    FirstClass(Binding binding) {
        if (binding.hasVariable("name") ||
                binding.hasVariable("count")){
            this.name = binding.getVariable("name") as String;
            this.count = binding.getVariable("count") as int;
        }
    }

    def Integer getInt(){
        this.count
    }
}
