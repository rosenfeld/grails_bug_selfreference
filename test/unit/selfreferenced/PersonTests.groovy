package selfreferenced



import grails.test.mixin.*
import org.junit.*

@Mock(Person)
class PersonTests {
    private parentId

    void setUp() {
        parentId = new Person(name: 'Rodrigo').save(flush: true).id
    }

    void testSupervisorIsNotSet() {
        def rodrigo = Person.get(parentId)
        def rosa = new Person(name: 'Rosa', parent: rodrigo).save(flush: true)
        rodrigo.refresh()
        assert rodrigo.supervisor == null
    }
}
