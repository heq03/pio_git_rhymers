package edu.kis.vh.nursery;

/**
 * Klasa HanoiRhymer rozszerza podstawową wyliczankę o mechanizm
 * sprawdzania poprawności kolejności (wartość nie może być większa od poprzedniej).
 */
public class HanoiRhymer extends DefaultCountingOutRhymer {

    /** Licznik odrzuconych elementów, które nie spełniały warunku Hanoi. */
    private int totalRejected = 0;

    /**
     * Metoda zwracająca liczbę elementów, które zostały odrzucone podczas wyliczanki.
     * @return całkowita liczba odrzuconych elementów.
     */
    public int reportRejected() {
        return totalRejected;
    }

    /**
     * Dodaje element do wyliczanki. Jeżeli nowa wartość jest większa niż
     * obecny szczyt stosu, element jest odrzucany.
     * @param in wartość do dodania do wyliczanki.
     */
    @Override
    public void countIn(int in) {
        if (!callCheck() && in > peekaboo())
            totalRejected++;
        else
            super.countIn(in);
    }
}
