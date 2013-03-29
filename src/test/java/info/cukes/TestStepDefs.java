package info.cukes;

import cucumber.api.java.en.Given;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import info.cukes.model.Parent;
import info.cukes.model.Child;
import info.cukes.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

/**
 * User: Jeffrey
 * Date: 29/03/13
 * Time: 2:53 PM
 */
public class TestStepDefs {

    private ParentRepository repository;

    private Long parentId;

    @Autowired
    public void setRepository(ParentRepository repository) {
        this.repository = repository;
    }

    @Given("^I have something$")
    public void I_have_something() throws Throwable {
        Parent dad = new Parent();
        dad.setFirstName("John");
        dad.setLastName("Smith");

        Child billy = new Child();
        billy.setFirstName("Billy");
        billy.setLastName("Smith");
        billy.setAge(5);
        billy.setParent(dad);

        Child sally = new Child();
        sally.setFirstName("Sally");
        sally.setLastName("Smith");
        sally.setAge(3);
        sally.setParent(dad);

        Set<Child> children = new HashSet<Child>();
        children.add(billy);
        children.add(sally);
        dad.setChildren(children);

        Parent persistedDad = repository.save(dad);

        parentId = persistedDad.getId();
    }

    @When("^something happens$")
    public void something_happens() throws Throwable {

    }

    @Then("^I have something else$")
    public void I_have_something_else() throws Throwable {
        final Parent retrievedDad = repository.findByFirstName("John");

        assertEquals("John", retrievedDad.getFirstName());
        assertEquals("Smith", retrievedDad.getLastName());
        assertEquals(2, retrievedDad.getChildren().size());
    }
}
