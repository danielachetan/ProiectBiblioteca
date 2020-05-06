package biblioteca.control;

import biblioteca.model.Carte;
import biblioteca.repository.repoMock.CartiRepoMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(JUnit4.class)
public class BigBang {
    private CartiRepoMock MyRepo;
    private BibliotecaCtrl bibliotecaCtrl;
    private List<Carte> listaCarti;

    @Before
    public void init() {
        MyRepo = new CartiRepoMock();
        bibliotecaCtrl = new BibliotecaCtrl(MyRepo);
        listaCarti = new ArrayList<Carte>();
    }

    @Test
    public void ECPTestTitlu4() throws Exception {
        /**
         * Modul A - adaugaCarte
         */
        Carte carteTest = new Carte();
        carteTest.setCuvinteCheie(Collections.singletonList("CuvantValid"));
        carteTest.setReferenti(Collections.singletonList("AutorValid"));
        carteTest.setAnAparitie("2000");
        carteTest.setTitlu("Titlutest");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

    @Test
    public void Test_01() {
        /**
         * Modul B - cautaCarte
         */
        ArrayList<Carte> Carti = new ArrayList<>();
        Carti.add(Carte.getCarteFromString("Povesti;Mihai Eminescu,Ion Caragiale,Ion Creanga;1973;Corint;povesti,povestiri"));
        Carti.add(Carte.getCarteFromString("Poezii;Sadoveanu;1973;Corint;poezii"));
        Carti.add(Carte.getCarteFromString("Enigma Otiliei;George Calinescu;1948;Litera;enigma,otilia"));
        Carti.add(Carte.getCarteFromString("D'ale carnavalului;Caragiale Ion;1948;Litera;caragiale,carnaval"));
        Carti.add(Carte.getCarteFromString("Intampinarea crailor;Mateiu Caragiale;1948;Litera;mateiu,crailor"));
        Carti.add(Carte.getCarteFromString("Test;Calinescu,Tetica;1992;Pipa;am,casa"));
        MyRepo = new CartiRepoMock();
        List<Carte> rezultat = new ArrayList<>();
        rezultat = MyRepo.cautaCarte("Caragiale");
        assert (rezultat.size() == 3);
    }

    @Test
    public void getCartiOrdonateDinAnulValid() {
        /**
         * Modul C - getCartiOrdonateDinAnul
         */
        listaCarti = MyRepo.getCartiOrdonateDinAnul("1948");
        Assert.assertEquals(3, listaCarti.size());
        Assert.assertEquals("Caragiale Ion", listaCarti.get(0).getReferenti().get(0));
        Assert.assertEquals("George Calinescu", listaCarti.get(1).getReferenti().get(0));
        Assert.assertEquals("Mateiu Caragiale", listaCarti.get(2).getReferenti().get(0));
    }

    @Test
    public void bigBangIntegration() throws Exception {
        //A
        Assert.assertEquals(6, MyRepo.getCarti().size());
        Carte carte1 = Carte.getCarteFromString("A;abc;2020;One;abc");
        Carte carte2 = Carte.getCarteFromString("B;abc;2019;One;abc");
        bibliotecaCtrl.adaugaCarte(carte1);
        bibliotecaCtrl.adaugaCarte(carte2);
        Assert.assertEquals(8, MyRepo.getCarti().size());

        //B
        listaCarti = MyRepo.cautaCarte("abc");
        Assert.assertEquals(2, listaCarti.size());
        Assert.assertEquals("A", listaCarti.get(0).getTitlu());
        Assert.assertEquals("B",listaCarti.get(1).getTitlu());

        //C
        listaCarti = MyRepo.getCartiOrdonateDinAnul("2020");
        Assert.assertEquals(1, listaCarti.size());
        Assert.assertEquals("A", listaCarti.get(0).getTitlu());
    }
}
