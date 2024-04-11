package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracoursix;
	private Etal etal;

	@BeforeEach
	void setUp() {
		System.out.println("Initialisation");
		village = new Village("le village des irréuctibles",10,1);
		abraracoursix = new Chef("Abraracoursix",10,village);
		village.setChef(abraracoursix);
	}


	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur,"Constructeur ne renvoies pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("test"));
		Gaulois bonemine = new Gaulois("Bonemine", 5);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		Etal test = village.rechercherEtal(bonemine);
		Etal test2 = controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine");
		assertEquals(test,test2);
	}

}
