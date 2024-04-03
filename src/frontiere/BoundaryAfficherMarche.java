package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		if((controlAfficherMarche.donnerInfosMarche().length) == 0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		}else {
			int nb = controlAfficherMarche.donnerInfosMarche().length;
			for(int i =0;i<nb;i++) {
				System.out.println("Etal n°"+((i/3)+1)+" : "+controlAfficherMarche.donnerInfosMarche()[i]);
			}
		}
	}
}
