package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracoursix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	@BeforeEach
	void setUp() {
		System.out.println("Initialisation");
		village = new Village("le village des irréuctibles",10,5);
		abraracoursix = new Chef("Abraracoursix",10,village);
		village.setChef(abraracoursix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal,"Constructeur ne renvoies pas null");		
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertFalse(controlLibererEtal.isVendeur("Bonemine"));
		Gaulois bonemine = new Gaulois("Bonemine", 5);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		assertTrue(controlLibererEtal.isVendeur("Bonemine"));
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNull(controlLibererEtal.libererEtal("Bonemine"));
		Gaulois bonemine = new Gaulois("Bonemine", 5);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleurs", 10);
		assertNotNull(controlLibererEtal.libererEtal("Bonemine"));
	}

}
