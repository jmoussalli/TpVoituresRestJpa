package com.example.demo;

import com.example.demo.model.Voiture;
import com.example.demo.service.CatalogueDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	CatalogueDatabase catalogueDatabase;
	@Test
	void testCatalogueVoiture() {
		Voiture voiture1 = new Voiture("Peugeot", "208", "2020", "Rouge", "01/01/2020", "AB-123-CD");
		catalogueDatabase.add(voiture1);

		Voiture voiture2 = new Voiture("Renault", "Clio", "2019", "Bleu", "02/02/2019", "BC-234-DE");
		catalogueDatabase.add(voiture2);

		Voiture voiture3 = new Voiture("Citroen", "C3", "2018", "Vert", "03/03/2018", "CD-345-EF");
		catalogueDatabase.add(voiture3);

		Voiture voiture4 = new Voiture("Ford", "Fiesta", "2021", "Jaune", "04/04/2021", "DE-456-FG");
		catalogueDatabase.add(voiture4);

		Voiture voiture5 = new Voiture("Toyota", "Yaris", "2017", "Noir", "05/05/2017", "EF-567-GH");
		catalogueDatabase.add(voiture5);

		Voiture voiture6 = new Voiture("Volkswagen", "Polo", "2016", "Blanc", "06/06/2016", "FG-678-HI");
		catalogueDatabase.add(voiture6);

		Voiture voiture7 = new Voiture("BMW", "Série 1", "2022", "Gris", "07/07/2022", "GH-789-IJ");
		catalogueDatabase.add(voiture7);

		Voiture voiture8 = new Voiture("Audi", "A3", "2020", "Marron", "08/08/2020", "HI-890-JK");
		catalogueDatabase.add(voiture8);

		Voiture voiture9 = new Voiture("Mercedes", "Classe A", "2019", "Violet", "09/09/2019", "IJ-901-KL");
		catalogueDatabase.add(voiture9);

		Voiture voiture10 = new Voiture("Opel", "Corsa", "2018", "Orange", "10/10/2018", "JK-012-LM");
		catalogueDatabase.add(voiture10);
	}

	@Test
	void testDelete() {
		catalogueDatabase.delete(1);
	}

	@Test
	void testFindById() {
		Optional<Voiture> op = catalogueDatabase.findById(6);
		if(op.isEmpty())
			System.out.println("id non trouvée");
		else {
			Voiture voiture = op.get();
			System.out.println(voiture);
		}
	}

	@Test
	void testUpdate() {
		Optional<Voiture> op = catalogueDatabase.findById(5);
		if(op.isPresent()) {
			Voiture voiture = op.get();
			voiture.setMarque("Citroen");
			catalogueDatabase.update(voiture);
		}

	}

}
