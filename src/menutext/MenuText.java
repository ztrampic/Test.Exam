package menutext;

import exception.MyInputMismatchException;
import helper.Helper;

import java.util.Scanner;

public class MenuText {

	public static void showMainMenu() {
		System.out.println("1.Rad sa zaposlenima.");
		System.out.println("2.Rad sa projektima.");
		System.out.println("3.Kraj.");
	}

	public static void showMenuOptionsZaposleni() {
		System.out.println("1.Unos zaposlenog u bazu.");
		System.out.println("2.Izmena zaposlenog iz baze.");
		System.out.println("3.Soft delete zaposlenog.");
		System.out.println("4.Prikaz svih zaposlenih");
		System.out.println("5.Povratak na glavni meni");
	}

	public static void showMenuOptionsProjekat() {
		System.out.println("1.Kreiranje novog projekta i dodela angazovanja.");
		System.out.println("2.Kreiranje izvestaja o projektu.");
		System.out.println("3.Pregled svih projekata");
		System.out.println("4.Povratak na glavni meni.");

	}

    public static int closeApp() {
		System.out.println("Hvala sto ste koristili nasu aplikaciju");
		return 0;
	}

    public static void showUlogaMenu() {
		System.out.println("Izaberite Ulogu zaposlenog na projektu.");
		System.out.println("1. Rukovodilac.");
		System.out.println("2. Developer.");
    }

	public static void choseNextStep() {
		System.out.println("Da li zelite da unesete novo angazovanje na projectu.");
		System.out.println("1. Da.");
		System.out.println("2. Ne.");
	}

    public static int showMenuNewProjectOrUpdate(Helper helper) {
		int numberOfTrys = 3;
		Scanner sc;
		while (numberOfTrys > 0){
			try {
				System.out.println("Izaberite opciju");
				System.out.println("1. Kreiranje novog projekta");
				System.out.println("2. Kreiranje novih angazovanja na postojecem projektu.");
				sc = new Scanner(System.in);
				int choice = helper.validateInput(sc);
				return choice;
			}catch (MyInputMismatchException e){
				numberOfTrys--;
				System.err.println(e.getMessage());
			}
		}
		return 0;
	}
}
