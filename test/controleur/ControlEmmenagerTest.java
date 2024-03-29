package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlEmmenagerTest {
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
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager,"Constructeur ne renvoies pas null");
	}

	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine",10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("xxxx"));
		controlEmmenager.ajouterDruide("Panoramix",10,1,5);
		assertNotNull(village.trouverHabitant("Panoramix"));
			
	}

	@Test
	void testAjouterDruide() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Druide1",10,1,5);
		assertNotNull(village.trouverHabitant("Druide1"));	
		assertTrue(controlEmmenager.isHabitant("Druide1"));
	}

	@Test
	void testAjouterGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine",10);
		
		Gaulois bonemine = village.trouverHabitant("Bonemine");
		
		assertEquals( "Bonemine",bonemine.getNom());
		assertEquals( 10,bonemine.getForce());
		
		
		
	}

}







