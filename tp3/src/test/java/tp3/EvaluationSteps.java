package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EvaluationSteps {

    private Map<String, Boolean> revisions;
    private List<String> revisedNotions;

    @Given("une liste de révisions vide")
    public void uneListeDeRevisionsVide() {
        if (revisions == null) {
            revisions = new HashMap<>();
        } else {
            revisions.clear();
        }
    }

    @Given("une liste de révisions contenant {string}")
    public void uneListeDeRevisionsContenant(String notion) {
        if (revisions == null) {
            revisions = new HashMap<>();
        }
        revisions.put(notion, false);
    }

    @Given("une liste de révisions contenant {string} et {string}")
    public void uneListeDeRevisionsContenantDeuxNotions(String notion1, String notion2) {
        if (revisions == null) {
            revisions = new HashMap<>();
        }
        revisions.put(notion1, false);
        revisions.put(notion2, false);
    }

    @When("j'ajoute la notion {string}")
    public void jAjouteLaNotion(String notion) {
        revisions.put(notion, false);
    }

    @When("je marque la notion {string} comme révisée")
    public void jeMarqueLaNotionCommeRevisée(String notion) {
        if (revisions.containsKey(notion)) {
            revisions.put(notion, true);
        } else {
            throw new IllegalArgumentException("La notion " + notion + " n'existe pas dans la liste des révisions.");
        }
    }

    @When("je vérifie les notions révisées")
    public void jeVerifieLesNotionsRevisées() {
        revisedNotions = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : revisions.entrySet()) {
            if (entry.getValue()) {
                revisedNotions.add(entry.getKey());
            }
        }
        System.out.println("Notions révisées : " + revisedNotions);
    }

    @Then("la notion {string} est dans la liste des révisions")
    public void laNotionEstDansLaListeDesRevisions(String notion) {
        assertTrue(revisions.containsKey(notion), "La notion " + notion + " n'est pas dans la liste des révisions.");
    }

    @Then("la notion {string} est marquée comme révisée")
    public void laNotionEstMarqueeCommeRevisée(String notion) {
        assertTrue(revisions.get(notion), "La notion " + notion + " n'est pas marquée comme révisée.");
    }

    @Then("je dois voir {string} dans la liste des notions révisées")
    public void jeDoisVoirDansLaListeDesNotionsRevisées(String notion) {
        assertTrue(revisedNotions.contains(notion), "La notion " + notion + " n'est pas dans la liste des notions révisées.");
    }

    @Then("je ne dois pas voir {string} dans la liste des notions révisées")
    public void jeNeDoisPasVoirDansLaListeDesNotionsRevisées(String notion) {
        assertFalse(revisedNotions.contains(notion), "La notion " + notion + " est dans la liste des notions révisées.");
    }
}
