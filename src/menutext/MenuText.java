package menutext;

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
}
