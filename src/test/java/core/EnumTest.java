package core;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumTest {

    @Test
    public void givenEnumNotInitialized_whenEqualSign_thenEqualitytIsSafe() {
        PizzaV1 testPz = new PizzaV1();
        // enum PizzaStatus is NOT initialized
        assertThat(testPz.getStatus() != PizzaV1.PizzaStatus.DELIVERED).isTrue();
    }

    @Test(expected = NullPointerException.class)
    public void givenEnumNotInitialized_whenEqualMethod_thenEqualitytIsNotSafe() {
        PizzaV1 testPz = new PizzaV1();
        // enum PizzaStatus is NOT initialized
        assertThat(!testPz.getStatus().equals(PizzaV1.PizzaStatus.DELIVERED));
    }

    @Test
    public void givenEnum_whenEqualSign_thenCompileTimeSafety() {
        PizzaV1 testPz = new PizzaV1();
        testPz.setStatus(PizzaV1.PizzaStatus.ORDERED);
        // comparison apples and oranges
        if (testPz.getStatus().equals(Color.GREEN)) ; // compile time safety not achieved
        // comparison apples and oranges
        // uncomment the following line to see the effect
//         if(testPz.getStatus() == TestColor.GREEN); // does not compile
    }

    @Test
    public void givenEnum_whenSwitch_thenOK() {
        int status = 0;
        PizzaV1 testPz = new PizzaV1();
        testPz.setStatus(PizzaV1.PizzaStatus.ORDERED);
        switch (testPz.getStatus()) {
            case ORDERED:
                status = 5;
                break;
            case READY:
                status = 2;
                break;
            case DELIVERED:
                status = 0;
        }
        assertThat(status).isEqualTo(5);
    }

    @Test
    public void givenMoreComplexEnum_thenOK() {
        PizzaV2 testPz = new PizzaV2();
        testPz.setStatus(PizzaV2.PizzaStatus.ORDERED);
        assertThat(testPz.getStatus().isOrdered()).isTrue();
        assertThat(testPz.getStatus().isReady()).isFalse();
        assertThat(testPz.getStatus().isDelivered()).isFalse();
        assertThat(testPz.getStatus().getTimeToDelivery()).isEqualTo(5);
        assertThat(testPz.isDeliverable()).isFalse();
    }

    @Test
    public void givenEnum_whenToString_thenOK() {
        PizzaV2 testPz = new PizzaV2();
        testPz.setStatus(PizzaV2.PizzaStatus.ORDERED);
        Assertions.assertThat(testPz.getStatus().toString()).isEqualTo("ORDERED");
        Assertions.assertThat(testPz.getStatus().name()).isEqualTo("ORDERED");
    }

    @Test
    public void givenEnumSetPizzaStatusUndelivered_whenRetrievingUnDeliveredPizzas_thenOK() {

        List<PizzaV2> pzList = new ArrayList<>();

        PizzaV2 pz1 = new PizzaV2();
        pz1.setStatus(PizzaV2.PizzaStatus.DELIVERED);

        PizzaV2 pz2 = new PizzaV2();
        pz2.setStatus(PizzaV2.PizzaStatus.ORDERED);

        PizzaV2 pz3 = new PizzaV2();
        pz3.setStatus(PizzaV2.PizzaStatus.ORDERED);

        PizzaV2 pz4 = new PizzaV2();
        pz4.setStatus(PizzaV2.PizzaStatus.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        List<PizzaV2> undeliveredPzs = PizzaV2.getAllUndeliveredPizzas(pzList);
        assertThat(undeliveredPzs.size()).isEqualTo(3);
        // 2 x ordered + 1 x ready
    }

    @Test
    public void givenPizzaOrders_whenGroupByStatusCalled_thenCorrectlyGrouped() {

        List<PizzaV2> pzList = new ArrayList<>();
        PizzaV2 pz1 = new PizzaV2();
        pz1.setStatus(PizzaV2.PizzaStatus.DELIVERED);

        PizzaV2 pz2 = new PizzaV2();
        pz2.setStatus(PizzaV2.PizzaStatus.ORDERED);

        PizzaV2 pz3 = new PizzaV2();
        pz3.setStatus(PizzaV2.PizzaStatus.ORDERED);

        PizzaV2 pz4 = new PizzaV2();
        pz4.setStatus(PizzaV2.PizzaStatus.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        EnumMap<PizzaV2.PizzaStatus, List<PizzaV2>> map = PizzaV2.groupPizzaByStatus(pzList);
        assertThat(map.get(PizzaV2.PizzaStatus.DELIVERED).size()).isEqualTo(1);
        assertThat(map.get(PizzaV2.PizzaStatus.ORDERED).size()).isEqualTo(2);
        assertThat(map.get(PizzaV2.PizzaStatus.READY).size()).isEqualTo(1);

        map = PizzaV2.groupPizzaByStatusJava8(pzList);
        assertThat(map.get(PizzaV2.PizzaStatus.DELIVERED).size()).isEqualTo(1);
        assertThat(map.get(PizzaV2.PizzaStatus.ORDERED).size()).isEqualTo(2);
        assertThat(map.get(PizzaV2.PizzaStatus.READY).size()).isEqualTo(1);
    }
}

class PizzaV1 {
    private PizzaStatus status;

    enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }

    boolean isDeliverable() {
        return getStatus() == PizzaStatus.READY;
    }

    PizzaStatus getStatus() {
        return status;
    }

    void setStatus(PizzaStatus status) {
        this.status = status;
    }
}

class PizzaV2 {

    private PizzaStatus status;

    private static EnumSet<PizzaStatus> undeliveredPizzaStatuses
            = EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);

    private EnumMap<PizzaStatus, PizzaV2> map;

    enum PizzaStatus {
        ORDERED(5) { // constructor

            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    boolean isDeliverable() {
        return this.status.isReady();
    }

    void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery());

    }

    static List<PizzaV2> getAllUndeliveredPizzas(List<PizzaV2> input) {
        return input.stream()
                .filter(
                        pizzaV2 -> undeliveredPizzaStatuses.contains(pizzaV2.getStatus()))
                .collect(Collectors.toList());
    }

    static EnumMap<PizzaStatus, List<PizzaV2>> groupPizzaByStatus(List<PizzaV2> pizzaList) {
        EnumMap<PizzaStatus, List<PizzaV2>> pzByStatus =
                new EnumMap<PizzaStatus, List<PizzaV2>>(PizzaStatus.class);

        for (PizzaV2 pz : pizzaList) {
            PizzaStatus status = pz.getStatus();
            if (pzByStatus.containsKey(status)) {
                pzByStatus.get(status).add(pz);
            } else {
                List<PizzaV2> newPzList = new ArrayList<PizzaV2>();
                newPzList.add(pz);
                pzByStatus.put(status, newPzList);
            }
        }
        return pzByStatus;
    }

    public static EnumMap<PizzaStatus, List<PizzaV2>> groupPizzaByStatusJava8(List<PizzaV2> pzList) {
        EnumMap<PizzaStatus, List<PizzaV2>> map
                = pzList.stream()
                .collect(
                        Collectors.groupingBy(
                                PizzaV2::getStatus, () -> new EnumMap<>(PizzaStatus.class), Collectors.toList()));
        return map;
    }

    PizzaStatus getStatus() {
        return status;
    }

    void setStatus(PizzaStatus status) {
        this.status = status;
    }

}

enum Color {
    GREEN;
}
