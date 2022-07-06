package fichier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

public class AppFile {
	public static void main(String[] args) {
//		File file = new File("src/main/resources/mon_fichier");
//		if (!file.exists()) {
//			try {
//				file.createNewFile();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		try {
//			FileOutputStream fos = new FileOutputStream("src/main/resources/mon_fichier");
//			fos.write("hello worledddd".getBytes());
//			fos.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		AppFile appFile = new AppFile();
//		appFile.load();
//		demoPrintWriter();
//		lectureTexte();
//		ajoutLigneAPartirDuClavier();
//		savePersonne();
//		loadPersonne();
		fenetre();
	}

	private static void fenetre() {
		JFrame frame = new JFrame("ma fenetre");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(150, 150);
		// frame.pack();
		frame.setVisible(true);
	}

	private static void loadPersonne() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/olivier"));
			Object obj = ois.readObject();
			System.out.println(obj);
			((List<Personne>) obj).forEach(p -> {
				System.out.println(p.getId() + " " + p.getPrenom());
			});
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void savePersonne() {
		Personne olivier = new Personne("olivier", "gozlan");

		List<Personne> list = Arrays.asList(olivier, new Personne("yassine", "omarah"));
		// serialisation
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("src/main/resources/" + olivier.getPrenom()));
			oos.writeObject(list);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void ajoutLigneAPartirDuClavier() {
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(new File("src/main/resources/toto.txt"), true));
			Scanner scanner = new Scanner(System.in);
			String ligne = scanner.nextLine();
			out.println(ligne);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void demoPrintWriter() {
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(new File("src/main/resources/toto.txt"), true));
			out.println("hello world");
			out.println("il fait beau, on a du soleil");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void lectureTexte() {

		Scanner scanner;
		try {
			scanner = new Scanner(new FileInputStream(new File("src/main/resources/toto.txt")));

			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void load() {
		// InputStream is = this.getClass().getResourceAsStream("/toto.txt");
		int byteLu;
		try {
			FileInputStream is = new FileInputStream("src/main/resources/mon_fichier");

			while ((byteLu = is.read()) != -1) {
				System.out.print((char) byteLu);
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
