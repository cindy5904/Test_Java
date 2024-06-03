import org.example.DiceScore;
import org.example.Ide;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class DireScoreTest {
    private DiceScore diceScore;
    private Ide de = Mockito.mock(Ide.class);

    @Test
    public void When_both_dice_are_identical_value_16() {
        diceScore = new DiceScore();
        Mockito.when(de.getRoll()).thenReturn(3,3);

        boolean result = diceScore.getScore() == 16;

        Assert.assertTrue(result);

    }
    @Test
    public void When_both_dice_are_identical_value_30() {
        diceScore = new DiceScore();
        Mockito.when(de.getRoll()).thenReturn(6,6);

        boolean result = diceScore.getScore() == 30;

        Assert.assertTrue(result);

    }

    @Test
    public void When_both_dice_are_identical_value_great() {
        diceScore = new DiceScore();
        Mockito.when(de.getRoll()).thenReturn(1,5);
        boolean result = diceScore.getScore() == 5;
        Assert.assertTrue(result);
    }
}
