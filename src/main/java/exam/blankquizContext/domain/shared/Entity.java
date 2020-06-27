package exam.blankquizContext.domain.shared;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
