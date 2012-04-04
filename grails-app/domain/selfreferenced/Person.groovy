package selfreferenced

class Person {
    String name

    static belongsTo = [ supervisor: Person ]

    Person parent

    static constraints = { supervisor nullable: true }
}
