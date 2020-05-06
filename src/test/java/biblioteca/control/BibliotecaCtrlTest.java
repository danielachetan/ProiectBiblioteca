package biblioteca.control;

import biblioteca.model.Carte;
import biblioteca.repository.repoMock.CartiRepoMock;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class BibliotecaCtrlTest {
    private BibliotecaCtrl bibliotecaCtrl;
    private CartiRepoMock cartiRepoMock;

    @Before
    public void setUp() throws Exception {
        cartiRepoMock = new CartiRepoMock();
        bibliotecaCtrl = new BibliotecaCtrl(cartiRepoMock);
    }

    /**
     * Metoda ajutatoare, returneaza o instanta a clasei Carte cu valori valide petru CuvinteCheie,
     * Referenti, AnAparitie. Atributul titlu nu este setat
     */
    private Carte getCarteECPTest() {
        Carte carteTest = new Carte();
        carteTest.setCuvinteCheie(Collections.singletonList("CuvantValid"));
        carteTest.setReferenti(Collections.singletonList("AutorValid"));
        carteTest.setAnAparitie("2000");
        return carteTest;
    }

    /**
     * Test ECP Titlu vid. Partitie 1
     * INVALID
     */
    @Test(expected = Exception.class)
    public void ECPTestTitlu1() throws Exception {
        Carte carteTest = getCarteECPTest();
        carteTest.setTitlu("");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

    /**
     * Test ECP Titlu format dintrun numar. Partitie 2
     * INVALID
     */
    @Test(expected = Exception.class)
    public void ECPTestTitlu2() throws Exception {
        Carte carteTest = getCarteECPTest();
        carteTest.setTitlu("1958");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

    /**
     * Test ECP Titlu format dintrun String si un numar. Partitie 3
     * INVALID
     */
    @Test(expected = Exception.class)
    public void ECPTestTitlu3() throws Exception {
        Carte carteTest = getCarteECPTest();
        carteTest.setTitlu("Titlu 1234");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

    /**
     * Test ECP Titlu format dintrun String. Partitie 4
     * VALID
     */
    @Test
    public void ECPTestTitlu4() throws Exception {
        Carte carteTest = getCarteECPTest();
        carteTest.setTitlu("Titlutest");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

    /**
     * Test ECP Titlu format din doua String - uri. Partitie 5
     * VALID
     */
    @Test
    public void ECPTestTitlu5() throws Exception {
        Carte carteTest = getCarteECPTest();
        carteTest.setTitlu("Titlu test");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

    /**
     * Metoda ajutatoare, returneaza o instanta a clasei Carte cu valori valide petru CuvinteCheie,
     * Referenti, Titlu. Atributul AnAparitie nu este setat.
     */
    private Carte getCarteBVATest() {
        Carte carteTest = new Carte();
        carteTest.setCuvinteCheie(Collections.singletonList("CuvantValid"));
        carteTest.setReferenti(Collections.singletonList("AutorValid"));
        carteTest.setTitlu("Titlu test");
        return carteTest;
    }

    /**
     * Test BVA AnAparitie minim
     * VALID
     */
    @Test
    public void BVATestAnAparitie1() throws Exception {
        Carte carteTest = getCarteBVATest();
        carteTest.setAnAparitie("0");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

    /**
     * Test BVA AnAparitie sub minimul acceptat
     * INVALID
     */
    @Test(expected = Exception.class)
    public void BVATestAnAparitie2() throws Exception {
        Carte carteTest = getCarteBVATest();
        carteTest.setAnAparitie("-1");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

    /**
     * Test BVA AnAparitie Numar normal/oarecare
     * VALID
     */
    @Test
    public void BVATestAnAparitie3() throws Exception {
        Carte carteTest = getCarteBVATest();
        carteTest.setAnAparitie("1868");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

    /**
     * Test BVA AnAparitie maxim
     * VALID
     */
    @Test
    public void BVATestAnAparitie4() throws Exception {
        Carte carteTest = getCarteBVATest();
        carteTest.setAnAparitie("2020");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

    /**
     * Test BVA AnAparitie peste maxim
     * INVALID
     */
    @Test(expected = Exception.class)
    public void BVATestAnAparitie5() throws Exception {
        Carte carteTest = getCarteBVATest();
        carteTest.setAnAparitie("2021");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

    /**
     * Test BVA AnAparitie peste maxim
     * INVALID
     */
    @Test(expected = Exception.class)
    public void BVATestAnAparitie6() throws Exception {
        Carte carteTest = getCarteBVATest();
        carteTest.setAnAparitie("100000");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

    /**
     * Test ECP AnAparitie notatie + (numere pozitive). Partitia 1
     * INVALID
     */
    @Test(expected = Exception.class)
    public void ECPTestAnAparitie1() throws Exception {
        Carte carteTest = getCarteBVATest();
        carteTest.setAnAparitie("+1");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

    /**
     * Test ECP AnAparitie numere reale/float/double. Partitia 2
     * INVALID
     */
    @Test(expected = Exception.class)
    public void ECPTestAnAparitie2() throws Exception {
        Carte carteTest = getCarteBVATest();
        carteTest.setAnAparitie("1.1");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

    /**
     * Test ECP AnAparitie numere negative. Partitia 3
     * INVALID
     */
    @Test(expected = Exception.class)
    public void ECPTestAnAparitie3() throws Exception {
        Carte carteTest = getCarteBVATest();
        carteTest.setAnAparitie("-1");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

    /**
     * Test ECP AnAparitie numere naturale. Partitia 4
     * Valid
     */
    @Test
    public void ECPTestAnAparitie4() throws Exception {
        Carte carteTest = getCarteBVATest();
        carteTest.setAnAparitie("1614");
        bibliotecaCtrl.adaugaCarte(carteTest);
    }

}