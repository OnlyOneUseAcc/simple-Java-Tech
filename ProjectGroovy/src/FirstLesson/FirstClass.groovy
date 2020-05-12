package FirstLesson

/**
 * Class which demonstrate work with constructors
 */
class FirstClass {
    /**
     * default string field
     */
    private String name;
    /**
     * default int field
     */
    private Integer count;

    /**
     * Simple constructor
     * @param name any string for test
     * @param count any int for test
     */
    FirstClass(String name, count) {
        this.name = name
        this.count = count
    }

    /**
     * Constructor with binding parametr
     * @param binding should contains string-name, int-count
     */
    FirstClass(Binding binding) {
        if (binding.hasVariable("name") ||
                binding.hasVariable("count")) {
            this.name = binding.getVariable("name") as String;
            this.count = binding.getVariable("count") as int;
        }
    }

    /**
     * new type of creating functions
     * @return field count
     */
    Integer getInt() {
        this.count
    }
}
