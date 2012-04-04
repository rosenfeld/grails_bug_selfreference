package selfreferenced

class Person {
    String name

    static belongsTo = [ supervisor: Person ]

    Person parent

    static constraints = { supervisor nullable: true }

    void setSupervisor(supervisor) {
      try {1/0} catch(e) { log.error "setSupervisor shouldn't be called", e }
      this.supervisor = supervisor
    }
}
