package uaslp.objetos.list.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

public class ArrayListTest {
    public ArrayListTest() {
    }

    @Test
    public void givenANewList_thenSizeisZero() {
        ArrayList<String> lista = new ArrayList();
        int size = lista.getSize();
        Assertions.assertEquals(0, size);
    }

    @Test
    public void givenANewList_whenAddAtTail_thenSizeisOne() throws NullNotAllowedException {
        ArrayList<String> lista = new ArrayList();
        lista.addAtTail("Uno");
        int size = lista.getSize();
        Assertions.assertEquals(1, size);
        Assertions.assertEquals("Uno", lista.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtTail_thenSizeisIncreased() throws NullNotAllowedException {
        ArrayList<String> lista = new ArrayList();
        lista.addAtTail("Uno");
        lista.addAtTail("Dos");
        int size = lista.getSize();
        Assertions.assertEquals(2, size);
        Assertions.assertEquals("Uno", lista.getAt(0));
        Assertions.assertEquals("Dos", lista.getAt(1));
    }

    @Test
    public void givenAlistWithTwoElements_whenAddAtFront_thenArrayIsIncreased() throws NullNotAllowedException {
        ArrayList<String> lista = new ArrayList(2);
        lista.addAtFront("Uno");
        lista.addAtFront("Dos");
        lista.addAtFront("Tres");
        int size = lista.getSize();
        Assertions.assertEquals(3, size);
        Assertions.assertEquals(lista.getAt(0), "Tres");
        Assertions.assertEquals(lista.getAt(1), "Dos");
        Assertions.assertEquals(lista.getAt(2), "Uno");
    }

    @Test
    public void givenAlistWithTwoElements_whenAddAtTail_thenArrayIsIncreased() throws NullNotAllowedException {
        ArrayList<String> lista = new ArrayList(2);
        lista.addAtTail("Uno");
        lista.addAtTail("Dos");
        lista.addAtTail("Tres");
        int size = lista.getSize();
        Assertions.assertEquals(3, size);
        Assertions.assertEquals(lista.getAt(0), "Uno");
        Assertions.assertEquals(lista.getAt(1), "Dos");
        Assertions.assertEquals(lista.getAt(2), "Tres");
    }

    @Test
    public void givenAList_whenRemoveLessThanZero_thenReturnFalse() throws NullNotAllowedException {
        ArrayList<String> lista = new ArrayList();
        lista.addAtFront("Uno");
        boolean result = lista.remove(-1);
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAListWith3Elements_whenSetAt1_thenElementIsModified() throws NullNotAllowedException {
        ArrayList<String> lista = new ArrayList();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        lista.setAt(1, "Cuatro");
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Cuatro", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenRemoveMid_thenReturnTrue() throws NullNotAllowedException {
        ArrayList<String> lista = new ArrayList();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");
        boolean result = lista.remove(1);
        Assertions.assertTrue(result);
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Dos");
        Assertions.assertEquals(lista.getAt(1), "Tres");
    }

    @Test
    public void givenAListWithThreeElements_whenRemoveAll_thenSizeIsZero() throws NullNotAllowedException {
        ArrayList<String> lista = new ArrayList();
        lista.addAtFront("Uno");
        lista.addAtTail("Dos");
        lista.addAtTail("Tres");
        lista.removeAll();
        int size = lista.getSize();
        Assertions.assertEquals(0, size);
    }

    @Test
    public void givenAListWithThreeElements_whenGetIterator_thenIteratorWorksOverThreeElements() throws NullNotAllowedException, WrongIndexException {
        ArrayList<String> lista = new ArrayList();
        lista.addAtFront("Uno");
        lista.addAtTail("Dos");
        lista.addAtTail("Tres");
        Iterator<String> iterator = lista.getIterator();
        int sizeOfList = lista.getSize();
        Assertions.assertEquals(3, sizeOfList);
        Assertions.assertNotNull(iterator);
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Uno", iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Dos", iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Tres", iterator.next());
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    public void givenAListWithTwoElements_whenSetAtNullValue_thenNullNotAllowedExceptionIsThrown() throws NullNotAllowedException {
        ArrayList<String> lista = new ArrayList();
        lista.addAtFront("Uno");
        lista.addAtTail("Dos");
        Assertions.assertThrows(NullNotAllowedException.class, () -> {
            lista.setAt(0, (Object)null);
        });
    }

    @Test
    public void givenAListWithTwoElements_whenAddAtFrontNullValue_thenNullNotAllowedExceptionIsThrown() throws NullNotAllowedException {
        ArrayList<String> lista = new ArrayList();
        lista.addAtFront("Uno");
        lista.addAtTail("Dos");
        Assertions.assertThrows(NullNotAllowedException.class, () -> {
            lista.addAtFront((Object)null);
        });
    }

    @Test
    public void givenAListWithTwoElements_whenAddAtTailNullValue_thenNullNotAllowedExceptionIsThrown() throws NullNotAllowedException {
        ArrayList<String> lista = new ArrayList();
        lista.addAtFront("Uno");
        lista.addAtTail("Dos");
        Assertions.assertThrows(NullNotAllowedException.class, () -> {
            lista.addAtTail((Object)null);
        });
    }
}