package com.alexstudy.java8.misused.optional;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;
import static com.alexstudy.java8.misused.Annotations.Ugly;
import static com.alexstudy.java8.misused.Annotations.Good;
import static com.alexstudy.java8.misused.Annotations.Bad;

public class HundredAndOneApproach {
    @Ugly
    class SameOldImperativeStyle {
        public String getPersonCarInsuranceName(Person person) {
            String name = "Unknown";
            if (ofNullable(person).isPresent()) {
                if (person.getCar().isPresent()) {
                    if (person.getCar().get().getInsurance().isPresent()) {
                        name = person.getCar().get().getInsurance().get().getName();
                    }
                }
            }
            return name;
        }
    }

    @Ugly
    class UsingIfPresentInSameImperativeWayWithDirtyHack {
        public String getPersonCarInsuranceName(Person person) {
            final StringBuilder builder = new StringBuilder();
            ofNullable(person).ifPresent(
                    p -> p.getCar().ifPresent(
                            c -> c.getInsurance().ifPresent(
                                    i -> builder.append(i.getName())
                            )
                    )
            );
            return builder.toString();
        }
    }

    @Bad
    class UsingMapWithUncheckedGet {
        public String getPersonCarInsuranceName(Person person) {
            return ofNullable(person)
                    .map(Person::getCar)
                    .map(car -> car.get().getInsurance())
                    .map(insurance -> insurance.get().getName())
                    .orElse("Unknown");
        }
    }

    @Ugly
    class UsingMapWithOrElseEmptyObjectToFixUncheckedGet {
        public String getPersonCarInsuranceName(Person person) {
            return ofNullable(person)
                    .map(Person::getCar)
                    .map(car -> car.orElseGet(Car::new).getInsurance())
                    .map(insurance -> insurance.orElseGet(Insurance::new).getName())
                    .orElse("Unknown");
        }
    }

    @Good
    class UsingFlatMap {
        public String getCarInsuranceNameFromPersonUsingFlatMap(Person person) {
            return ofNullable(person)
                    .flatMap(Person::getCar)
                    .flatMap(Car::getInsurance)
                    .map(Insurance::getName)
                    .orElse("Unknown");
        }
    }

    class Person {
        public Optional<Car> getCar() {
            return empty(); //stub
        }
    }

    class Car {
        public Optional<Insurance> getInsurance() {
            return empty(); //stub
        }
    }

    class Insurance {
        public String getName() {
            return ""; //stub
        }
    }
}