package com.alex.login.utils.mapper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alejandro on 3/20/17.
 */
public interface Mapper<F, T extends Serializable> {

    T map(final F from);
    F map(final T from);
    List<T> mapList(final List<F> from);
    List<F> mapListReverse(final List<T> from);

}
