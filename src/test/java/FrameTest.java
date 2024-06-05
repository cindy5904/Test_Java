import org.example.Frame;
import org.example.IGenerateur;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class FrameTest {
    private Frame frame;
    private IGenerateur iGenerateur = Mockito.mock(IGenerateur.class);


    @Test
    public void Roll_SimpleFrame_FirstRoll_CheckScore() {
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(5);
        frame = new Frame(iGenerateur, false);
        frame.makeRoll();
        Assert.assertEquals(5, frame.getScore());
    }

    @Test
    public void Roll_SimpleFrame_SecondRoll_CheckScore() {
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(5).thenReturn(4);
        frame = new Frame(iGenerateur, false);
        frame.makeRoll();
        frame.makeRoll();
        Assert.assertEquals(9, frame.getScore());
    }

    @Test
    public void Roll_SimpleFrame_SecondRoll_FirstRollStrick_ReturnFalse() {
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(10);
        frame = new Frame(iGenerateur, false);
        frame.makeRoll();
        Assert.assertFalse(frame.makeRoll());
    }

    @Test
    public void Roll_SimpleFrame_MoreRolls_ReturnFalse() {
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(5).thenReturn(4);
        frame = new Frame(iGenerateur, false);
        frame.makeRoll();
        frame.makeRoll();
        Assert.assertFalse(frame.makeRoll());
    }

    @Test
    public void Roll_LastFrame_SecondRoll_FirstRollStrick_ReturnTrue() {
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(10).thenReturn(5);
        frame = new Frame(iGenerateur, true);
        frame.makeRoll();
        Assert.assertTrue(frame.makeRoll());
    }

    @Test
    public void Roll_LastFrame_SecondRoll_FirstRollStrick_CheckScore() {
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(10).thenReturn(5);
        frame = new Frame(iGenerateur, true);
        frame.makeRoll();
        frame.makeRoll();
        Assert.assertEquals(15, frame.getScore());

    }

    @Test
    public void Roll_LastFrame_ThirdRoll_FirstRollStrick_ReturnTrue() {
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(10).thenReturn(5).thenReturn(3);
        frame = new Frame(iGenerateur, true);
        frame.makeRoll();
        frame.makeRoll();
        Assert.assertTrue(frame.makeRoll());
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_FirstRollStrick_CheckScore() {
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(10).thenReturn(5).thenReturn(3);
        frame = new Frame(iGenerateur, true);
        frame.makeRoll();
        frame.makeRoll();
        frame.makeRoll();
        Assert.assertEquals(18, frame.getScore());
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_Spare_ReturnTrue() {
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(5).thenReturn(5).thenReturn(3);
        frame = new Frame(iGenerateur, true);
        frame.makeRoll();
        frame.makeRoll();
        Assert.assertTrue(frame.makeRoll());
    }

    @Test
    public void Roll_LastFrame_ThirdRoll_Spare_CheckScore() {
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(5).thenReturn(5).thenReturn(3);
        frame = new Frame(iGenerateur, true);
        frame.makeRoll();
        frame.makeRoll();
        frame.makeRoll();
        Assert.assertEquals(13, frame.getScore());
    }

    @Test
    public void Roll_LastFrame_FourthRoll_ReturnFalse() {
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(5).thenReturn(5).thenReturn(3).thenReturn(2);
        frame = new Frame(iGenerateur, true);

        frame.makeRoll();
        frame.makeRoll();
        frame.makeRoll();
        Assert.assertFalse(frame.makeRoll());
    }
}
