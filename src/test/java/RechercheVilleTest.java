import jdk.jshell.spi.ExecutionControl;
import org.example.RechercheVille;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class RechercheVilleTest {
    private RechercheVille rechercheVille;

    private List<String> villes = Arrays.asList(
            "Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver",
            "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok",
            "Hong Kong", "Dubaï", "Rome", "Istanbul");

    @Before
    public void setUp() {
        rechercheVille = new RechercheVille(villes);
    }
    @Test
    public void When_recherche_contient_moins_2_caracteres() throws ExecutionControl.NotImplementedException {

        Assert.assertThrows(RechercheVille.NotFoundException.class, () -> {
            rechercheVille.rechercher("a");
        });
    }

    @Test
    public void When_recherche_egal_superieur_2_caracteres() throws ExecutionControl.NotImplementedException {
        rechercheVille = new RechercheVille(villes);
        List<String> result = rechercheVille.rechercher("Va");
        Assert.assertEquals(List.of("Valence", "Vancouver"), result);
    }

    @Test
    public void When_recherche_insensible_casse() throws ExecutionControl.NotImplementedException {
        rechercheVille = new RechercheVille(villes);
        String motRecherche = "Va";
        List<String> result = rechercheVille.rechercher(motRecherche.toLowerCase());
        Assert.assertEquals(List.of("Valence", "Vancouver"), result);
    }


    @Test
    public void When_recherche_partie_de_nom_ape() throws ExecutionControl.NotImplementedException {
        rechercheVille = new RechercheVille(villes);
        List<String> result = rechercheVille.rechercher("ape");
        Assert.assertEquals(List.of("Budapest"), result);
    }

    @Test
    public void When_recherche_est_un_asterix_renvoi_liste_complete() throws ExecutionControl.NotImplementedException {
        rechercheVille = new RechercheVille(villes);
        List<String> result = rechercheVille.rechercher("*");
        Assert.assertEquals(16, result.size());

    }
}
