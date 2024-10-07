import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class main{
	private static Scanner teklatua = new Scanner(System.in);
	public static BigDecimal C = new BigDecimal("299792458");
	private static BigDecimal C2 = C.multiply(C);
	private static BigDecimal G2M;
	private static BigDecimal erantzuna;
	private static BigDecimal masa;
	private static String b = "";
	private static String c = "";
	private static BigDecimal radiototal;
	private static BigDecimal prerantzuna;
	private static BigDecimal erantzunafinala;
	private static BigDecimal ametros;
	private static BigDecimal distantzia;
	private static BigDecimal Temp;
	private static BigDecimal Tempraiz;
	private static BigDecimal Temperantzuna;
	private static BigDecimal asegundos;
	
	public static void main(String[] args) {
		System.out.println("Hau, masa zehatz bat, zulo beltz bat izango bazen eukiko zuen diametroa kalkulatzeko da.");
		System.out.println("Gure sistema solarreko planetak, pluton edo eguzkia minuskulas idazten badituzu, zulo beltz bat izango baziren eukiko zuen diametroa kalkulatuko du.");
		System.out.println("Bestela (masa solarra) idatzi masa solarretan kalkulatzeko. Enter tekla sakatzen baduzu, orduan kilogramotan kalkulatuko da. ");
		System.out.print("Optzio bat aukeratu: ");
		String aukera = teklatua.nextLine();
		
		radioa(aukera);
		
		System.out.println("Zein da, egin nahi duzun hurrengo operazioa? eskape abiadura atera nahi duzu?");
		System.out.println("Optzio bat aukeratu(eskape abiadura, dilatazio temporala): ");
		String aukera2 = teklatua.nextLine();
		
		if (aukera2.contains("eskape abiadura")) {
			System.out.print("Erabili nahi duzun distantzia unitatea sartu(LY, UA, km, m): ");
			String unitateaukera = teklatua.nextLine();
			
			eskapeabiadura(unitateaukera);
			if (erantzunafinala.compareTo(BigDecimal.valueOf(1000)) >= 0) {
				System.out.println(erantzunafinala.divide(BigDecimal.valueOf(1000), 10, RoundingMode.HALF_UP) + " Km/s");
			}
			else {
				System.out.println(erantzunafinala + " m/s");
			}
		}
		else if (aukera2.contains("dilatazio temporala")) {
			System.out.print("Erabili nahi duzun denbora neurria sartu (segunduak, minutuak, orduak, egunak, hilabeteak, urteak): ");
			String denboraneurria = teklatua.nextLine();
			dilataciontemporal(denboraneurria);
			if (Temperantzuna.compareTo(BigDecimal.valueOf(3.156 * Math.pow(10, 7))) >= 0) {
				System.out.println(Temperantzuna.divide(BigDecimal.valueOf((3.156 * Math.pow(10, 7))), 10, RoundingMode.HALF_UP) + " urteak");
			}
			else if (Temperantzuna.compareTo(BigDecimal.valueOf(2.628 * Math.pow(10, 6))) >= 0) {
				System.out.println(Temperantzuna.divide(BigDecimal.valueOf((2.628 * Math.pow(10, 6))), 10, RoundingMode.HALF_UP) + " hilabeteak");
			}
			else if (Temperantzuna.compareTo(BigDecimal.valueOf(86400)) >= 0) {
				System.out.println(Temperantzuna.divide(BigDecimal.valueOf(86400), 10, RoundingMode.HALF_UP) + " egunak");
			}
			else if (Temperantzuna.compareTo(BigDecimal.valueOf(3600)) >= 0) {
				System.out.println(Temperantzuna.divide(BigDecimal.valueOf(3600), 10, RoundingMode.HALF_UP) + " orduak");
			}
			else if (Temperantzuna.compareTo(BigDecimal.valueOf(60)) >= 0) {
				System.out.println(Temperantzuna.divide(BigDecimal.valueOf(60), 10, RoundingMode.HALF_UP) + " minutuak");
			}
			else {
				System.out.println(Temperantzuna + " segunduak");
			}
		}
			
		teklatua.close();
	}
	
	private static void radioa (String aukera) {
		BigDecimal masasolar = new BigDecimal(1.989 * Math.pow(10, 30));
		BigDecimal masamercurio = new BigDecimal(3.285 * Math.pow(10, 23));
		BigDecimal masavenus = new BigDecimal(4.867 * Math.pow(10, 24));
		BigDecimal masatierra = new BigDecimal(5.972 * Math.pow(10, 24));
		BigDecimal masamarte = new BigDecimal(6.39 * Math.pow(10, 23));
		BigDecimal masajupiter = new BigDecimal(1.898 * Math.pow(10, 27));
		BigDecimal masasaturno = new BigDecimal(5.683 * Math.pow(10, 26));
		BigDecimal masaurano = new BigDecimal(8.681 * Math.pow(10, 25));
		BigDecimal masaneptuno = new BigDecimal(1.024 * Math.pow(10, 26));
		BigDecimal masapluton = new BigDecimal(1.30 * Math.pow(10, 2));
		BigDecimal G2 = new BigDecimal(2 * 6.67430 * Math.pow(10, -11));
		switch (aukera) {
		// R = 2 * G * M / c^2	
		case "merkurio":
			G2M = G2.multiply(masamercurio);
			erantzuna = G2M.divide(C2, 10, RoundingMode.HALF_UP);
			System.out.println(erantzuna + " metroak.");
			System.out.println((erantzuna.multiply(BigDecimal.valueOf(2))) + " metroak.");
			break;
		case "venus":
			G2M = G2.multiply(masavenus);
			erantzuna = G2M.divide(C2, 10, RoundingMode.HALF_UP);
			System.out.println(erantzuna + " metroak.");
			System.out.println((erantzuna.multiply(BigDecimal.valueOf(2))) + " metroak.");
			break;
		case "lurra":
			G2M = G2.multiply(masatierra);
			erantzuna = G2M.divide(C2, 10, RoundingMode.HALF_UP);
			System.out.println(erantzuna + " metroak.");
			System.out.println((erantzuna.multiply(BigDecimal.valueOf(2))) + " metroak.");
			break;
		case "marte":
			G2M = G2.multiply(masamarte);
			erantzuna = G2M.divide(C2, 10, RoundingMode.HALF_UP);
			System.out.println(erantzuna + " metroak.");
			System.out.println((erantzuna.multiply(BigDecimal.valueOf(2))) + " metroak.");
			break;
		case "jupiter":
			G2M = G2.multiply(masajupiter);
			erantzuna = G2M.divide(C2, 10, RoundingMode.HALF_UP);
			System.out.println(erantzuna + " metroak.");
			System.out.println((erantzuna.multiply(BigDecimal.valueOf(2))) + " metroak.");
			break;
		case "saturno":
			G2M = G2.multiply(masasaturno);
			erantzuna = G2M.divide(C2, 10, RoundingMode.HALF_UP);
			System.out.println(erantzuna + " metroak.");
			System.out.println((erantzuna.multiply(BigDecimal.valueOf(2))) + " metroak.");
			break;
		case "urano":
			G2M = G2.multiply(masaurano);
			erantzuna = G2M.divide(C2, 10, RoundingMode.HALF_UP);
			System.out.println(erantzuna + " metroak.");
			System.out.println((erantzuna.multiply(BigDecimal.valueOf(2))) + " metroak.");
			break;
		case "neptuno":
			G2M = G2.multiply(masaneptuno);
			erantzuna = G2M.divide(C2, 10, RoundingMode.HALF_UP);
			System.out.println(erantzuna + " metroak.");
			System.out.println((erantzuna.multiply(BigDecimal.valueOf(2))) + " metroak.");
			break;
		case "pluton":
			G2M = G2.multiply(masapluton);
			erantzuna = G2M.divide(C2, 10, RoundingMode.HALF_UP);
			System.out.println(erantzuna + " metroak.");
			System.out.println((erantzuna.multiply(BigDecimal.valueOf(2))) + " metroak.");
			break;
		case "eguzkia":
			G2M = G2.multiply(masasolar);
			erantzuna = G2M.divide(C2, 10, RoundingMode.HALF_UP);
			System.out.println(erantzuna + " metroak.");
			System.out.println((erantzuna.multiply(BigDecimal.valueOf(2))) + " metroak.");
			break;
		case "masasolar":
			System.out.print("Zenbat masa solarreko zulo beltza da: ");
			masa = new BigDecimal(teklatua.nextBigInteger());
			BigDecimal neurrialdaketa = masa.multiply(masasolar);
			G2M = G2.multiply(neurrialdaketa);
			teklatua.nextLine();
			erantzuna = G2M.divide(C2, 10, RoundingMode.HALF_UP);
			if (erantzuna.compareTo(BigDecimal.valueOf(149597870700.0)) >= 0) {
				System.out.println(erantzuna.divide((BigDecimal.valueOf(149597870700.0)), 10, RoundingMode.HALF_UP) + " UA");
				System.out.println(erantzuna.divide(BigDecimal.valueOf(149597870700.0).multiply(BigDecimal.valueOf(2)), 10, RoundingMode.HALF_UP) + " UA");
				break;
			}
			else {
				System.out.println(erantzuna + " metroak.");
				System.out.println((erantzuna.multiply(BigDecimal.valueOf(2))) + " metroak.");
				break;
			}
			default: 
				System.out.print("Zulo beltzaren masa sartu: ");;
				masa = new BigDecimal(teklatua.nextBigInteger());
				G2M = G2.multiply(masa);
				erantzuna = G2M.divide(C2, 10, RoundingMode.HALF_UP);
				if (erantzuna.compareTo(BigDecimal.valueOf(149597870700.0)) >= 0) {
					System.out.println(erantzuna.divide((BigDecimal.valueOf(149597870700.0)), 10, RoundingMode.HALF_UP) + " UA");
					System.out.println(erantzuna.divide(BigDecimal.valueOf(149597870700.0).multiply(BigDecimal.valueOf(2)), 10, RoundingMode.HALF_UP) + " UA");
					break;
				}
				else {
					System.out.println(erantzuna + " metroak.");
					System.out.println((erantzuna.multiply(BigDecimal.valueOf(2))) + " metroak.");
					break;
				}
		}
	}
	
	private static void eskapeabiadura(String unitateaukera) {
		System.out.print("Zulo beltzetik zauden distantziara sartu: ");
		distantzia = new BigDecimal(teklatua.nextBigInteger());
		switch (unitateaukera) {
		case "m":
			radiototal = erantzuna.add(distantzia);
			prerantzuna = G2M.divide((radiototal), 10, RoundingMode.HALF_UP);
			erantzunafinala = raizcuadrada(prerantzuna);
			break;
		case "km":
			ametros = distantzia.multiply(BigDecimal.valueOf(1000));
			radiototal = erantzuna.add(ametros);
			prerantzuna = G2M.divide((radiototal), 10, RoundingMode.HALF_UP);
			erantzunafinala = raizcuadrada(prerantzuna);
			break;
		case "UA":
			ametros = distantzia.multiply(BigDecimal.valueOf(149597870700.0));
			radiototal = erantzuna.add(ametros);
			prerantzuna = G2M.divide((radiototal), 10, RoundingMode.HALF_UP);
			erantzunafinala = raizcuadrada(prerantzuna);
			break;
		case "LY":
			ametros = distantzia.multiply(BigDecimal.valueOf(9.461*Math.pow(10, 15)));
			radiototal = erantzuna.add(ametros);
			prerantzuna = G2M.divide((radiototal), 10, RoundingMode.HALF_UP);
			erantzunafinala = raizcuadrada(prerantzuna);
			break;
		}
	}
	
	private static void dilataciontemporal(String denboraneurria) {
		System.out.print("Zulo beltzaren alboan egongo saren denbora kopurua sartu: ");
		BigDecimal denbora = new BigDecimal(teklatua.nextBigInteger());
		teklatua.nextLine();
		switch (denboraneurria) {
		case "segunduak":
			calculodilataciontemporal(denbora);
			break;
		case "minutuak":
			asegundos = denbora.multiply(BigDecimal.valueOf(60));
			calculodilataciontemporal(asegundos);
			break;
		case "orduak":
			asegundos = denbora.multiply(BigDecimal.valueOf(3600));
			calculodilataciontemporal(asegundos);
			break;
		case "egunak":
			asegundos = denbora.multiply(BigDecimal.valueOf(86400));
			calculodilataciontemporal(asegundos);
			break;
		case "hilabeteak":
			asegundos = denbora.multiply(BigDecimal.valueOf(2.628 * Math.pow(10, 6)));
			calculodilataciontemporal(asegundos);
			break;
		case "urteak":
			asegundos = denbora.multiply(BigDecimal.valueOf(3.154 * Math.pow(10, 7)));
			calculodilataciontemporal(asegundos);
			break;
		}
	}
	
	private static void calculodilataciontemporal(BigDecimal denbora) {
		System.out.print("Erabili nahi duzun distantzia neurria sartu(LY, UA, km, m): ");
		String unitatemota = teklatua.nextLine();
		System.out.print("Zulo beltzaren gertaera horizontetik zauden distantzia kopurua sartu: ");
		distantzia = new BigDecimal(teklatua.nextBigInteger());
		
		switch (unitatemota) {
		case "m":
			radiototal = erantzuna.add(distantzia);
			BigDecimal Temp3 = radiototal.multiply(BigDecimal.valueOf(Math.pow(299792458, 2)));
			Temp = G2M.divide((Temp3), 10, RoundingMode.HALF_UP);
			prerantzuna = BigDecimal.valueOf(1).subtract((Temp));
			Tempraiz = raizcuadrada(prerantzuna);
			Temperantzuna = denbora.multiply(Tempraiz);
			break;
		case "km":
			ametros = distantzia.multiply(BigDecimal.valueOf(1000));
			radiototal = erantzuna.add(ametros);
			Temp3 = radiototal.multiply(BigDecimal.valueOf(Math.pow(299792458, 2)));
			Temp = G2M.divide((Temp3), 10, RoundingMode.HALF_UP);
			prerantzuna = BigDecimal.valueOf(1).subtract((Temp));
			Tempraiz = raizcuadrada(prerantzuna);
			Temperantzuna = denbora.multiply(Tempraiz);
			break;
		case "UA":
			ametros = distantzia.multiply(BigDecimal.valueOf(149597870700.0));
			radiototal = erantzuna.add(ametros);
			Temp3 = radiototal.multiply(BigDecimal.valueOf(Math.pow(299792458, 2)));
			Temp = G2M.divide((Temp3), 10, RoundingMode.HALF_UP);
			prerantzuna = BigDecimal.valueOf(1).subtract((Temp));
			Tempraiz = raizcuadrada(prerantzuna);
			Temperantzuna = denbora.multiply(Tempraiz);
			break;
		case "LY":
			ametros = distantzia.multiply(BigDecimal.valueOf(9.461*Math.pow(10, 15)));
			radiototal = erantzuna.add(ametros);
			Temp3 = radiototal.multiply(BigDecimal.valueOf(Math.pow(299792458, 2)));
			Temp = G2M.divide((Temp3), 10, RoundingMode.HALF_UP);
			prerantzuna = BigDecimal.valueOf(1).subtract((Temp));
			Tempraiz = raizcuadrada(prerantzuna);
			Temperantzuna = denbora.multiply(Tempraiz);
			break;
		}
	}
	
	private static BigDecimal raizcuadrada(BigDecimal prerantzuna) {
		BigDecimal zatiketa = prerantzuna.divide(BigDecimal.valueOf(2), 10, RoundingMode.HALF_UP);
		int f = 1;
		int y = 0;
		String[] a;
		while (f<100) {
			BigDecimal erantzuna2 = ((zatiketa.add((prerantzuna.divide((zatiketa), 10, RoundingMode.HALF_UP)))).divide(BigDecimal.valueOf(2), 10, RoundingMode.HALF_UP));
			zatiketa = erantzuna2;
			a = erantzuna2.toString().split("\\.");
			if (b.isEmpty()) {
				b=a[1];
			}
			else {
				if (y%2==0) {
					b = a[1];
				}
				else {
					c = a[1];
				}
				if (b.contains(c)) {
					f=100;
				}
			}
			f++;
			y++;
		}
		return zatiketa;
	}
}