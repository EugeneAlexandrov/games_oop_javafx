package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void position() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.position(), is(Cell.C8));
    }

    @Test
    public void copy() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        bishopBlack = bishopBlack.copy(Cell.A1);
        assertThat(bishopBlack.position(), is(Cell.A1));
    }

    @Test
    public void way() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] way = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(bishopBlack.way(Cell.C1, Cell.G5), way);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void illegalway() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.C1, Cell.G6);
    }
}