package com.cod3hulk;

import org.hamcrest.Matchers;
import org.hamcrest.beans.HasPropertyWithValue;
import org.hamcrest.collection.IsMapContaining;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

/**
 * Sample tests with hamcrest collection matcher
 */
public class CollectionMatcherTest {

    @Test
    public void test_map_has_entry() {
        // GIVEN
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        // THEN
        assertThat(map, hasEntry(is(1), is("one")));
    }

    @Test
    public void test_list_has_entry_with_property() {
        // GIVEN
        List<Foo> list = new ArrayList<Foo>();
        list.add(new Foo("foobar"));

        // THEN
        assertThat(list, hasItem(HasPropertyWithValue.<Foo>hasProperty("bar", is("foobar"))));
    }

    @Test
    public void test_map_has_entry_with_property() {
        // GIVEN
        Map<Integer, Foo> map = new HashMap<Integer, Foo>();
        map.put(1, new Foo("foobar"));

        // THEN
        assertThat(map, hasEntry(
                is(1), hasProperty("bar", is("foobar"))
        ));
    }

    public static class Foo {
        private String bar;

        public Foo(String bar) {
            this.bar = bar;
        }

        public String getBar() {
            return bar;
        }
    }
}
