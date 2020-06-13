package api.com.google.common.base;

import com.google.common.base.MoreObjects;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MoreObjectsTest {

    public class User {

        private final long id;
        private final String name;

        public User(final long id, final String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            // toStringHelper(this) will display the name of the parent class or the name of the subclass
            // if toStringHelper(User.class) or toStringHelper("User") are used then the name of the class that is displayed is hardcoded
            return MoreObjects.toStringHelper(this)
                    .add("id", id)
                    .add("name", name)
                    .toString();
        }
    }

    public class Player extends User {

        final int money;

        public Player(long id, String name, int money) {
            super(id, name);
            this.money = money;
        }

    }

    @Test
    public void givenUser_whentoStringHelperThis() {
        Assertions.assertThat(new User(1, "name_of_the_user").toString()).isEqualTo("User{id=1, name=name_of_the_user}");
    }

    @Test
    public void givenPlayer_whentoStringHelperThisInParent() {
        Assertions.assertThat(new Player(1, "name_of_the_user", 10).toString()).isEqualTo("Player{id=1, name=name_of_the_user}");
    }
}
