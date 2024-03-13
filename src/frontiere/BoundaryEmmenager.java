package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenu villageois " + nomVisiteur + ".\n");
					question.setLength(0);
					question.append(" Quelle est votre force ?\n");
					int force = Clavier.entrerEntier(question.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		System.out.println("Bienvenu druide " + nomVisiteur + ".\n");
		question.append(" Quelle est votre force ?\n");
		int force = Clavier.entrerEntier(question.toString());
		int effetPotionMin = -1;
		int effetPotionMax = -1;
		
		do {
			question.setLength(0);
			question.append(" Quelle est la potion la plus faible que vous produisez ?\n");
			effetPotionMin = Clavier.entrerEntier(question.toString());
			question.setLength(0);
			question.append(" Quelle est la potion la plus forte que vous produisez ?\n");
			effetPotionMax = Clavier.entrerEntier(question.toString());
			if (effetPotionMax < effetPotionMin) {
				System.out.println("Attention druide , vous vous êtes trompé entre le minimum et le maximum.\n");
			}
		} while (effetPotionMax < effetPotionMin);
		
		controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
}
