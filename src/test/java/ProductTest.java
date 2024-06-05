import jdk.jshell.spi.ExecutionControl;
import org.example.Product;
import org.example.Shop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {
    private Product product;
    private Shop shop;

    @Before
    public void setUp() {
        product = new Product();
        shop = new Shop();
    }
    @Test
    public void When_datePeremptionEstAZero_QualitéProduitDegradee() throws ExecutionControl.NotImplementedException {
        shop.update(product);
        Assert.assertEquals(8, product.getQuality());
    }
    @Test
    public void When_QualiteProduitNePeuxEtreNegative() throws ExecutionControl.NotImplementedException {
        shop.update(product);
        product.setQuality(-1);
        Assert.assertTrue(product.getQuality() >= 0);
    }
    @Test
    public void When_QualiteProduitNePeuxEtreSuperieurAZero() throws ExecutionControl.NotImplementedException {
        shop.update(product);
        product.setQuality(51);
        Assert.assertTrue(product.getQuality() <= 50);
    }

    @Test
    public void When_QualiteBrieVieilliAugmenteLorsquIlVieilli() throws ExecutionControl.NotImplementedException {
        Product brie = new Product("Brie Vieilli", "Brie", 5, 10);
        shop.update(brie);
        Assert.assertEquals(11, brie.getQuality());
    }

    @Test
    public void When_QualiteProduitLaitierBaisseDeuxFoisPlusViteQueLesProduitsNormaux() throws ExecutionControl.NotImplementedException {
        Product LaitierProduct = new Product("Produit Laitier", "Yaourt", 5, 10);
        shop.update(LaitierProduct);
        Assert.assertEquals(6, LaitierProduct.getQuality());
    }
}
