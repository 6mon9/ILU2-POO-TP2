package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)){
			System.out.println("Je suis désolée " + nomVendeur+ " mais il faut être habitant de notre village pour commercer ici.\\n");
		} else {
			System.out.println("Bonjour  " + nomVendeur+ " , je vais regarder si je peux trouver un étal.\n");
			if(!controlPrendreEtal.resteEtals()){
				System.out.println("Désolée " + nomVendeur+ " je n'ai plus d'étal qui ne soit pas déjà occupé .\n");
			}else {
				installerVendeur(nomVendeur);
			}
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder question = new StringBuilder();
		System.out.println("C'est parfait, il me reste un étal pour vous !\n"
				+ "il me faudrait quelques renseignement : \n");
		System.out.println(" Quel produit souhaitez-vous vendre ?\n");	
		String produit = scan.next();

		question.append(" Combien souhaitez-vous en vendre ?\n");
		int nbProduit = Clavier.entrerEntier(question.toString());
		
		int numEtal =controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numEtal != -1) {
			System.out.println("Le vendeur "
					+nomVendeur+ " s'est installé à l'étal n°"
							+ (numEtal)+".\n");
		}
	}
}
