package com.drozda.learning;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by GFH on 17.04.2016.
 */
@RunWith(JUnitParamsRunner.class)
public class CitizenTest {

    private static final Object[] getCitizen() {
        return new Object[]{
                new Object[]{12, "Ben"}
                , new Object[]{32, "John"}
        };
    }

    @Test
    @Parameters(method = "getCitizen")
    public void constructorParamsTest(int age, String name) {
        Citizen citizen = new Citizen(age, name);
        assertEquals(age, citizen.getAge());
        assertEquals(name, citizen.getName());
    }

    @Test
    @Parameters(source = CitizenPrivider.class)
    public void complexConstructorParamsTest(Citizen citizenToTest, int ageToTest, String nameToTest, boolean
            isEquals) {
        assertThat(citizenToTest.getAge() == ageToTest, is(isEquals));
        assertThat(citizenToTest.getName().equals(nameToTest), is(isEquals));
    }


    public static class CitizenPrivider {
        public static Object[] provideEquals() {
            return new Object[]{
                    new Object[]{new Citizen(12, "Ben"), 12, "Ben", true},
                    new Object[]{new Citizen(32, "John"), 32, "John", true}
            };
        }

        public static Object[] provideNotEquals() {
            return new Object[]{
                    new Object[]{new Citizen(12, "Ben"), 32, "John", false},
                    new Object[]{new Citizen(32, "John"), 12, "Ben", false}
            };
        }
    }
}