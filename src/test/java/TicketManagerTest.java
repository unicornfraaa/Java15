import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {
    Repository repo = new Repository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 1599, "ZIA", "KZN", 95);

    @BeforeEach
    public void addedTickets() {
        manager = new TicketManager(new Repository());
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
    }

    @Test
    void shouldShow() {
        Ticket[] expected = new Ticket[]{ticket1, ticket3, ticket2};
        assertArrayEquals(expected, manager.show());
    }

    @Test
    void shouldSearchSucessfully() {
        Ticket[] expected = new Ticket[]{ticket3};
        assertArrayEquals(expected, manager.findAll("ZIA", "KZN"));
    }

    @Test
    void shouldSearchUnSucessfully() {
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, manager.findAll("KZN", "ZIA"));
    }
}

