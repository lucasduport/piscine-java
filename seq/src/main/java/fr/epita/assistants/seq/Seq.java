package fr.epita.assistants.seq;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public interface Seq<ElementType> extends ExtendedStream<ElementType> {
    Stream<ElementType> giveStream();

    static <TYPE> Seq<TYPE> of(List<TYPE> values) {
        return values::stream;
    }

    static <TYPE> Seq<TYPE> of(TYPE... values) {
        return () -> Stream.of(values);
    }

    static <TYPE> Seq<TYPE> of(Stream<TYPE> values) {
        return () -> values;
    }

    @Override
    default <KEY_TYPE> Map<KEY_TYPE, ElementType> toMap(Function<ElementType, KEY_TYPE> keyMapper) {
        Map<KEY_TYPE, ElementType> m = new HashMap<>();
        giveStream().forEach(
                i -> m.put(keyMapper.apply(i),i )
        );
        return m;
    }

    @Override
    default <KEY_TYPE, VALUE_TYPE, MAP_TYPE extends Map<KEY_TYPE, VALUE_TYPE>> MAP_TYPE toMap(MAP_TYPE map, Function<ElementType, KEY_TYPE> keyMapper, Function<ElementType, VALUE_TYPE> valueMapper) {
        giveStream().forEach(
                i -> map.put(keyMapper.apply(i),valueMapper.apply(i) )
        );
        return map;
    }

    @Override
    default <KEY_TYPE, VALUE_TYPE> Map<KEY_TYPE, VALUE_TYPE> toMap(Function<ElementType, KEY_TYPE> keyMapper, Function<ElementType, VALUE_TYPE> valueMapper) {
        Map<KEY_TYPE, VALUE_TYPE> m = new HashMap<>();
        giveStream().forEach(
                i -> m.put(keyMapper.apply(i) ,valueMapper.apply(i) )
        );
        return m;
    }

    @Override
    default Stream<ElementType> filter(Predicate<? super ElementType> predicate) {
        return giveStream().filter(predicate);
    }

    @Override
    default <R> Stream<R> map(Function<? super ElementType, ? extends R> mapper) {
        return giveStream().map(mapper);
    }

    @Override
    default IntStream mapToInt(ToIntFunction<? super ElementType> mapper) {
        return giveStream().mapToInt(mapper);
    }

    @Override
    default LongStream mapToLong(ToLongFunction<? super ElementType> mapper) {
        return giveStream().mapToLong(mapper);
    }

    @Override
    default DoubleStream mapToDouble(ToDoubleFunction<? super ElementType> mapper) {
        return giveStream().mapToDouble(mapper);
    }

    @Override
    default <R> Stream<R> flatMap(Function<? super ElementType, ? extends Stream<? extends R>> mapper) {
        return giveStream().flatMap(mapper);
    }

    @Override
    default IntStream flatMapToInt(Function<? super ElementType, ? extends IntStream> mapper) {
        return giveStream().flatMapToInt(mapper);
    }

    @Override
    default LongStream flatMapToLong(Function<? super ElementType, ? extends LongStream> mapper) {
        return giveStream().flatMapToLong(mapper);
    }

    @Override
    default DoubleStream flatMapToDouble(Function<? super ElementType, ? extends DoubleStream> mapper) {
        return giveStream().flatMapToDouble(mapper);
    }

    @Override
    default Stream<ElementType> distinct() {
        return giveStream().distinct();
    }

    @Override
    default Stream<ElementType> sorted() {
        return giveStream().sorted();
    }

    @Override
    default Stream<ElementType> sorted(Comparator<? super ElementType> comparator) {
        return giveStream().sorted(comparator);
    }

    @Override
    default Stream<ElementType> peek(Consumer<? super ElementType> action) {
        return giveStream().peek(action);
    }

    @Override
    default Stream<ElementType> limit(long maxSize) {
        return giveStream().limit(maxSize);
    }

    @Override
    default Stream<ElementType> skip(long n) {
        return giveStream().skip(n);
    }

    @Override
    default void forEach(Consumer<? super ElementType> action) {
        giveStream().forEach(action);
    }

    @Override
    default void forEachOrdered(Consumer<? super ElementType> action) {
        giveStream().forEachOrdered(action);
    }

    @Override
    default Object[] toArray() {
        return giveStream().toArray();
    }

    @Override
    default <A> A[] toArray(IntFunction<A[]> generator) {
        return giveStream().toArray(generator);
    }

    @Override
    default ElementType reduce(ElementType identity, BinaryOperator<ElementType> accumulator) {
        return giveStream().reduce(identity,accumulator);
    }

    @Override
    default Optional<ElementType> reduce(BinaryOperator<ElementType> accumulator) {
        return giveStream().reduce(accumulator);
    }

    @Override
    default <U> U reduce(U identity, BiFunction<U, ? super ElementType, U> accumulator, BinaryOperator<U> combiner) {
        return giveStream().reduce(identity, accumulator, combiner);
    }

    @Override
    default <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super ElementType> accumulator, BiConsumer<R, R> combiner) {
        return giveStream().collect(supplier, accumulator, combiner);
    }

    @Override
    default <R, A> R collect(Collector<? super ElementType, A, R> collector) {
        return giveStream().collect(collector);
    }

    @Override
    default List<ElementType> toList() {
        return giveStream().toList();
    }

    @Override
    default Optional<ElementType> min(Comparator<? super ElementType> comparator) {
        return giveStream().min(comparator);
    }

    @Override
    default Optional<ElementType> max(Comparator<? super ElementType> comparator) {
        return giveStream().max(comparator);
    }

    @Override
    default long count() {
        return giveStream().count();
    }

    @Override
    default boolean anyMatch(Predicate<? super ElementType> predicate) {
        return giveStream().anyMatch(predicate);
    }

    @Override
    default boolean allMatch(Predicate<? super ElementType> predicate) {
        return giveStream().allMatch(predicate);
    }

    @Override
    default boolean noneMatch(Predicate<? super ElementType> predicate) {
        return giveStream().noneMatch(predicate);
    }

    @Override
    default Optional<ElementType> findFirst() {
        return giveStream().findFirst();
    }

    @Override
    default Optional<ElementType> findAny() {
        return giveStream().findAny();
    }

    @Override
    default <LIST extends List<ElementType>> LIST toList(LIST list) {
        return giveStream().collect(Collectors.toCollection(new Supplier<LIST>() {
            @Override
            public LIST get() {
                return list;
            }
        }));
    }

    @Override
    default Set<ElementType> toSet() {
        return giveStream().collect(Collectors.toSet());
    }

    @Override
    default <SET extends Set<ElementType>> SET toSet(SET set) {
        return giveStream().collect(Collectors.toCollection(new Supplier<SET>() {
            @Override
            public SET get() {
                return set;
            }
        }));
    }

    @Override
    default <ASSOCIATED_TYPE> ExtendedStream<Pair<ElementType, ASSOCIATED_TYPE>> associate(Supplier<ASSOCIATED_TYPE> supplier) {
        return Seq.of(giveStream().map(
                o -> new Pair<ElementType, ASSOCIATED_TYPE>(o, supplier.get())
        ));
    }

    @Override
    default <ASSOCIATED_TYPE> ExtendedStream<Pair<ElementType, ASSOCIATED_TYPE>> associate(Stream<ASSOCIATED_TYPE> supplier) {
        List<ElementType> l = giveStream().toList();
        List<ASSOCIATED_TYPE> s = supplier.toList();
        List<Pair<ElementType, ASSOCIATED_TYPE>> n = new ArrayList<>();
        for (int i = 0; i < l.size() && i < s.size(); i++) {
            n.add(new Pair<>(l.get(i), s.get(i)));
        }
        return Seq.of(n);
    }

    @Override
    default ExtendedStream<ElementType> print() {
        giveStream().forEach(System.out::println);
        return Seq.of(giveStream());
    }

    @Override
    default ExtendedStream<ElementType> plus(Stream<ElementType> stream) {
        return Seq.of(Stream.concat(giveStream(), stream));
    }

    @Override
    default String join(String delimiter) {
        StringBuilder b = new StringBuilder();
        var l = giveStream().toList();
        if (l.size() == 0)
            return "";
        for (int i = 0; i < l.size() -1; i++) {
            b.append(l.get(i)).append(delimiter);
        }
        b.append(l.get(l.size() - 1));
        return b.toString();
    }

    @Override
    default String join() {
        StringBuilder b = new StringBuilder();
        giveStream().forEach(
                b::append
        );
        return b.toString();
    }

    @Override
    default <KEY_TYPE> ExtendedStream<Pair<KEY_TYPE, ExtendedStream<ElementType>>> partition(Function<ElementType, KEY_TYPE> pivot) {
        return Seq.of(giveStream().map(
                i -> new Pair<KEY_TYPE, ExtendedStream<ElementType>>(pivot.apply(i), Seq.of(giveStream().filter(
                        j -> pivot.apply(j) == pivot.apply(i))
                ))
        ));
    }

    @Override
    default Iterator<ElementType> iterator() {
        return giveStream().iterator();
    }

    @Override
    default Spliterator<ElementType> spliterator() {
        return giveStream().spliterator();
    }

    @Override
    default boolean isParallel() {
        return giveStream().isParallel();
    }

    @Override
    default Stream<ElementType> sequential() {
        return giveStream().sequential();
    }

    @Override
    default Stream<ElementType> parallel() {
        return giveStream().parallel();
    }

    @Override
    default Stream<ElementType> unordered() {
        return giveStream().unordered();
    }

    @Override
    default Stream<ElementType> onClose(Runnable closeHandler) {
        return giveStream().onClose(closeHandler);
    }

    @Override
    default void close() {
        giveStream().close();
    }
}
