package org.example.Hamcrest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hamcrest {
//https://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/Matchers.html
    @Test
    public void conhecendoHamcrest(){
        assertThat("Maria", Matchers.is("maria"));
        assertThat(128, Matchers.is(128d));
        assertThat(128,Matchers.isA(Integer.class));
        assertThat(128d,Matchers.isA(Double.class));
        assertThat(128d,Matchers.greaterThan(120d));
        assertThat(128d,Matchers.lessThan(130d));

        List<Integer> impares = Arrays.asList(1,2,3,4,5);
        assertThat(impares,Matchers.hasSize(5));
        assertThat(impares,Matchers.contains(1,3,5));
        assertThat(impares,Matchers.containsInAnyOrder(1,5,3));
        assertThat(impares,Matchers.hasItem(1));
        assertThat(impares,Matchers.hasItems(1,5));

        assertThat("Maria", Matchers.is(not("joao")));
        assertThat("maria", not("joao"));
        assertThat("joaquin",anyOf(is("Maria"),is("joao")));

    }
}
