package com.alex.login.utils.mapper;

import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alejandro on 3/20/17.
 */
public abstract class MapperImpl<F, T extends Serializable> implements Mapper<F, T> {

    private final Class<F> from;
    private final Class<T> to;

    public MapperImpl(final Class<F> from, final Class<T> to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public T map(final F from) {

        final ModelMapper mapper = new ModelMapper();
        T to = mapper.map(from,this.to);
        return to;

    }

    @Override
    public F map(final T from) {

        final ModelMapper mapper = new ModelMapper();
        F to = mapper.map(from,this.from);
        return to;

    }

    @Override
    public List<T> mapList(final List<F> from) {

        List<T> list = new ArrayList<T>();
        final ModelMapper mapper = new ModelMapper();

        for(F item : from){
            list.add(mapper.map(item,this.to));
        }

        return list;
    }

    @Override
    public List<F> mapListReverse(final List<T> from) {

        List<F> list = new ArrayList<F>();
        final ModelMapper mapper = new ModelMapper();

        for(T item : from){
            list.add(mapper.map(item,this.from));
        }

        return list;
    }
}
