package selfreferenced

import static org.junit.Assert.*
import org.junit.*

class PersonTests {
    private parentId

    @Before
    void setUp() {
        parentId = new Person(name: 'Rodrigo').save(flush: true).id
    }

    @Test
    void supervisorIsNotSet() {
        def rodrigo = Person.get(parentId)
        def rosa = new Person(name: 'Rosa', parent: rodrigo).save(flush: true)
        rodrigo.refresh()
        assert rodrigo.supervisor == null
    }
}
