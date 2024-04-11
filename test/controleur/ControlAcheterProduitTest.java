package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Chef abraracoursix;

	@BeforeEach
	void setUp(){
		System.out.println("Initialisation");
		village = new Village("le village des irréuctibles",10,5);
		abraracoursix = new Chef("Abraracoursix",10,village);
		village.setChef(abraracoursix);
	}

	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit,"Constructeur ne renvoies pas null");
	}

	@Test
	void testVerifierIdentite() {
		fail("Not yet implemented");
	}

	@Test
	void testRechercherVendeursProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);		
		assertNull(controlAcheterProduit.rechercherVendeursProduit("fleurs"));
		Gaulois bonemine = new Gaulois("Bonemine", 5);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs",10);
		Gaulois[] vendeur = controlAcheterProduit.rechercherVendeursProduit("fleurs");
		assertEquals(bonemine,vendeur[0]);
	}

	@Test
	void testAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);		
		Gaulois bonemine = new Gaulois("Bonemine", 5);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs",10);
		System.out.println(controlAcheterProduit.acheterProduit("Bonemine", 5));
	}

}
