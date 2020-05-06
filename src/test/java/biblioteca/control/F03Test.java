package biblioteca.control;

import biblioteca.model.Carte;
import biblioteca.repository.repoMock.CartiRepoMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F03Test {
    private CartiRepoMock cartiRepo;

    private List<Carte> cartiGasite;

    @Before
    public void setUp() {
        this.cartiRepo = new CartiRepoMock();
        this.cartiGasite = new ArrayList<>();
    }


    @Test
    public void getCartiOrdonateDinAnulValid() {
        cartiGasite = cartiRepo.getCartiOrdonateDinAnul("1948");
        Assert.assertEquals(3,cartiGasite.size());
        Assert.assertEquals("Caragiale Ion",cartiGasite.get(0).getReferenti().get(0));
        Assert.assertEquals("George Calinescu",cartiGasite.get(1).getReferenti().get(0));
        Assert.assertEquals("Mateiu Caragiale", cartiGasite.get(2).getReferenti().get(0));
    }

    @Test
    public void getCartiOrdonateDinAnulInvalid(){
        cartiGasite = cartiRepo.getCartiOrdonateDinAnul("abcd");
        Assert.assertEquals(0,cartiGasite.size());

    }
}
