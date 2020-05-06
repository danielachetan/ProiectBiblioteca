package biblioteca.control;

import biblioteca.model.Carte;
import biblioteca.repository.repoMock.CartiRepoMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class WhiteBoxTesting {
    private CartiRepoMock MyRepo;

    @Test
    public void Test_01()
    {
        /*Autor Corect - Intra in toate while si if*/
        /*2 Fail uri (assertion error,NullPointerException)*/
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
        assert(rezultat.size() == 3);

    }
    @Test
    public void Test_02()
    {
        /*Autor neexistent- Intra in toate while si primul if, al doilea if nu este niciodata True*/
        /*Bug - String : ""*/
        ArrayList<Carte> Carti = new ArrayList<>();
        Carti.add(Carte.getCarteFromString("Povesti;Mihai Eminescu,Ion Caragiale,Ion Creanga;1973;Corint;povesti,povestiri"));
        Carti.add(Carte.getCarteFromString("Poezii;Sadoveanu;1973;Corint;poezii"));
        Carti.add(Carte.getCarteFromString("Enigma Otiliei;George Calinescu;1948;Litera;enigma,otilia"));
        Carti.add(Carte.getCarteFromString("Dale carnavalului;Caragiale Ion;1948;Litera;caragiale,carnaval"));
        Carti.add(Carte.getCarteFromString("Intampinarea crailor;Mateiu Caragiale;1948;Litera;mateiu,crailor"));
        Carti.add(Carte.getCarteFromString("Test;Calinescu,Tetica;1992;Pipa;am,casa"));
        MyRepo = new CartiRepoMock();
        List<Carte> rezultat = new ArrayList<>();
        rezultat = MyRepo.cautaCarte("Paul");
        assert(rezultat.size() == 0);

    }

    @Test
    public void Test_03()
    {
        /*Nu exista nici o carte in care sa caute - Nu intra in nici un while sau if,returneaza lista goala*/
        ArrayList<Carte> Carti = new ArrayList<>();
        MyRepo = new CartiRepoMock();
        List<Carte> rezultat = new ArrayList<>();
        rezultat = MyRepo.cautaCarte("Paul");
        assert(rezultat.size() == 0);

    }


}
