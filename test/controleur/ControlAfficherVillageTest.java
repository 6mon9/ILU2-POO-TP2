package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracoursix;

	@BeforeEach
	void setUp(){
		System.out.println("Initialisation");
		village = new Village("le village des irréuctibles",10,5);
		abraracoursix = new Chef("Abraracoursix",10,village);
		village.setChef(abraracoursix);
	}

	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage,"Constructeur ne renvoies pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		Gaulois bonemine = new Gaulois("Bonemine", 5);
		village.ajouterHabitant(bonemine);
		String[] habitants = controlAfficherVillage.donnerNomsVillageois();
		assertEquals("Abraracoursix",habitants[0]);
		assertEquals("Bonemine",habitants[1]);
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		String nomVillage = controlAfficherVillage.donnerNomVillage();
		assertEquals("le village des irréuctibles",nomVillage);
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		int nbEtal = controlAfficherVillage.donnerNbEtals();
		assertEquals( 5, nbEtal);
	}

}
