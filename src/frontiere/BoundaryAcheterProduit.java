package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		StringBuilder question = new StringBuilder();
		if(!controlAcheterProduit.verifierIdentite(nomAcheteur)){
			System.out.println("Je suis désolée " + nomAcheteur+ " mais il faut être habitant de notre village pour commercer ici.\\n");
		} else {
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.next();
			if (controlAcheterProduit.rechercherVendeursProduit(produit) == null) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}else {
				question.append("Chez quel commerçant voulez-vous acheter des " + produit+ " ? \n");
				for(int i =0 ; i < (controlAcheterProduit.rechercherVendeursProduit(produit).length);i++) {
					question.append(""+(i+1)+" - "+ (controlAcheterProduit.rechercherVendeursProduit(produit)[i]).getNom());
				}
				int vendeur = Clavier.entrerEntier(question.toString());
				String nomVendeur = (controlAcheterProduit.rechercherVendeursProduit(produit)[vendeur-1]).getNom();
				System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+nomVendeur);
				question.setLength(0);
				question.append("Combien de "+produit+" voulez-vous acheter ?");
				int nbProduit = Clavier.entrerEntier(question.toString());
				int possible = controlAcheterProduit.acheterProduit(nomVendeur, nbProduit);
				if (possible == 0) {
					System.out.println(nomAcheteur +" veut acheter "+ nbProduit+" "+produit+", malheureusement il n’y en a plus !");
				}
				else if (possible < nbProduit) {
					System.out.println(nomAcheteur+" veut acheter "+ nbProduit+" "+produit+ " malheureusement Bonemine n’en a plus que "+possible+". "+nomAcheteur+" achète tout le stock de "+nomVendeur+".");
				}
				else {
					System.out.println(nomAcheteur+" achète "+ nbProduit+" "+produit+" à "+nomVendeur+".");
				}
				
			}
		}
		
		
	}

}
