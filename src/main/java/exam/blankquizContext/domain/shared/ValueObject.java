package exam.blankquizContext.domain.shared;

public interface ValueObject<T> {
    boolean sameValueAs(T other);
}
