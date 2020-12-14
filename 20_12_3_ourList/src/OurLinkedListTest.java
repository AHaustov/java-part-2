import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class OurLinkedListTest extends OurListTest {

    @BeforeEach
    public void init(){
        list=new OurLinkedList();
        stringList = new OurLinkedList<>();
    }
}