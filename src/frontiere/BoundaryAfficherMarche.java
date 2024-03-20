package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		if((controlAfficherMarche.donnerInfosMarche().length) = 0) {
			System.out.println("Le marché est vide, revenez plus tard.");
			
		}
	}
}
