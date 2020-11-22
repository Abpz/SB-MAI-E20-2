package Joala09.BDD;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class ActionsTest extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {

    @Test
    public void pressing_delete_will_remove_the_selected_figure() {
        given().a_figure_exists();
        when().pressing_the_delete_key();
        then().the_figure_is_deleted();
    }
}

