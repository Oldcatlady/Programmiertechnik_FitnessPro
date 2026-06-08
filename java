/*
Aufgabe FitnessPro 
Hinweise: Teambildung und nutzen von Google erwünscht!!! 
Aufgabe: 
Erstellen Sie ein Fitnessprogramm mit dem Namen „FitnessPro“. 
Vorbereitung: 
1. Erstellen Sie ein neues Projekt in Eclipse. 
2. Erstellen Sie eine neue Klasse mit der statischen main-Methode. 
Anforderung: 
1. Das Programm soll nach dem Start ein Hauptmenü anzeigen. 
Es soll folgende Auswahl möglich sein: Radfahren, Laufen, Walken und Programm verlassen. 
Entwickeln Sie für dieses Menü ein Struktogramm und den entsprechenden Quellcode. 
2. Nach Auswahl der Sportart sollen folgende Daten eingegeben werden: 
a.) Wie lange wollen Sie laufen? ( 15 min, 30 min, 45 min oder 60 min) 
b.) Gewicht 
3. Schreiben Sie eine Methode, die als Übergabeparameter das eingegebene Gewicht und die 
ausgewählte Sportart hat und je nach Gewicht und Sportart den entsprechenden 
Kalorienwert pro 15 min zurückgibt. Die entsprechenden Werte entnehmen Sie der Tabelle. 
Erstellen Sie für diese Methode nicht nur den entsprechenden Quellcode, sondern auch ein 
Strukturgramm. 
55-64 kg 65-74 kg 75-84 kg 85-94 kg 95-104 kg 105-114 
Jogging  
113 
132 
152 
165 
kg 
195 
115-124 
kg 
Radfahren 
226 
83 
98 
113 
128 
145 
258 
Walken  
161 
62 
73 
84 
96 
178 
Tabelle 1: Kalorienverbrauch einzelner Sportarten pro 15 Minuten 
108 
121 
Hinweis: Welche Sportart wurde gewählt und welches Gewicht wurde angegeben. 
134 
Wenn Sportart =  „Laufen“ denn … , sonst wenn Sportart = „Walken“ usw. und denn mit dem 
Gewicht  genauso vorgehen. 
4. Berechnen Sie die Gesamtkalorien für die angegebene Zeit (P.s. Die Werte in der Tabelle 
gelten nur für 15 Minuten, nicht 30, 45 oder 60 Minuten). 
5. Geben Sie die Gesamtkalorien auf der Konsole aus. 
Zusatzaufgabe: 
1.) 
Wenn Sie im Menü sind und eine Zahl eingeben, die nicht vorgegeben ist, soll ein Hinweistext 
ausgegeben werden und das Menü erneut angezeigt werden. 
2.)  
Was passiert, wenn Sie eine Taste drücken im Menü, die keine Zahl ist? Überlegen Sie erst und testen 
Sie es denn. Versuchen Sie dafür einen Workaround(Lösung) zu finden.import java.util.Scanner;
public class FitnessPro {
	// Mein Scanner ist static und außerhalb von main, damit er überall funktioniert.
	/*
	 *  "static" bedeutet: gehört zur Klasse selbst, nicht zu einem einzelnen Objekt.
     * Dadurch können alle statischen Methoden (main, starteTraining, getKalorien)
     * direkt darauf zugreifen — ohne ihn als Parameter weiterzureichen.
	 */
	 static Scanner sc = new Scanner(System.in);
	    public static void main(String[] args) {
	    	// Hier gehts los mit der Methode "Hauptmenü".
	        hauptMenue();
	    }
	    // Hier ist jetzt meine Hauptmenü-Methode. Hier wird beschrieben, 
	    // wie alles funktioniert.
	    static void hauptMenue() {
	    	//Erstellen Sie ein Fitnessprogramm mit dem Namen „FitnessPro“. 
	        while (true) {
	        	// Zeigt dem User nur, was er tun muss.
	            System.out.println("=== FitnessPro ===");
	            System.out.println("Jogging (1)");
	            System.out.println("Radfahren (2)");
	            System.out.println("Walken (3)");
	            System.out.println("Programm beenden (4)");
	            System.out.println("Deine Eingabe: ");
	            // Ließt die Eingabe.
	            String eingabe = sc.nextLine();
/*
 * Der Stringvergleich stürtzt niemals ab! Bei einer Falschen Eingabe, 
 * landet der User im else-Block und wird zur korrekten Eingabe 
 * aufegfordert.
 */
	            //1. Das Programm soll nach dem Start ein Hauptmenü anzeigen. 
	            //Es soll folgende Auswahl möglich sein: Radfahren, Laufen, Walken und Programm verlassen. 
	            //Entwickeln Sie für dieses Menü ein Struktogramm und den entsprechenden Quellcode. 
	            if (eingabe.equals("1")) {
	            	starteTraining("Jogging");
	            } else if (eingabe.equals("2")) {
	            	starteTraining("Radfahren");
	            } else if (eingabe.equals("3")) {
	            	starteTraining("Walken");
	            } else if (eingabe.equals("4")) {
	                System.out.println("Auf Wiedersehen!");
	                System.exit(0);
	            } else {
	                System.out.println("Ungültige Eingabe, bitte nochmal!");
	            }
	        }
	    }
	
/*
 * starteTraining() fragt nach Zeit und Gewicht,
 * berechnet die Kalorien und gibt das Ergebnis aus.
 * Sie wird aufgerufen mit dem Namen der Sportart als Parameter.
 */
static void starteTraining(String sportart) {
    System.out.println("\n--- " + sportart + " ---");

    // ---- Trainingszeit abfragen ----
    // Wir nutzen wieder String-Vergleich, kein parseInt nötig.
    String zeitEingabe = "";
    int zeitMinuten = 0;

    while (zeitMinuten == 0) {
        System.out.println("Wie lange möchten Sie trainieren?");
        System.out.println("15 Minuten (1)");
        System.out.println("30 Minuten (2)");
        System.out.println("45 Minuten (3)");
        System.out.println("60 Minuten (4)");
        System.out.print("Deine Eingabe: ");
        zeitEingabe = sc.nextLine();

        if      (zeitEingabe.equals("1")) zeitMinuten = 15;
        else if (zeitEingabe.equals("2")) zeitMinuten = 30;
        else if (zeitEingabe.equals("3")) zeitMinuten = 45;
        else if (zeitEingabe.equals("4")) zeitMinuten = 60;
        else System.out.println("Ungültige Eingabe, bitte nochmal!");
    }

    // ---- Gewicht abfragen ----
    /*
     * Die Eingabe erfolgt innerhalb der Schleife. 
     * Und die Variable kurz davor ist der Speicherplatz, 
     * damit die Variable damit arbeiten kann.
     */
    int gewicht = 0;
    while (gewicht == 0) { // Meine Schleife läuft solange, bis sie nicht mehr Null ist. Dann passiert etwas.
        System.out.print("Dein Gewicht in kg (55-124): ");
        // Ich lese String ein und Parse, weil andersherum Datenmüll entstehen kann, der 
        // Mist machen kann in weiteren Durchläufen.
        String gewichtEingabe = sc.nextLine();
        try {//Mit parseInt wird die StringZahl zur Zahl mit der man rechnen kann.
        	//Hier erstelle ich auch direkt meine Variable um mit der Gewichtseingabe weiter zu rechnen.
            int eingabeGewicht = Integer.parseInt(gewichtEingabe);
            // Hier wird der gültige Bereich festgelegt, wie viel eine wiegen darf.
            if (eingabeGewicht >= 55 && eingabeGewicht <= 124) {
                gewicht = eingabeGewicht;
            } else {
                System.out.println("Entschuldige bitte, dein Gewicht ist mit unserem System inkompatible.");
            }
            // Das ist jetzt so etwas wie mein Filter, der Falsche Eingaben abfängt.
        } catch (NumberFormatException e) {
            System.out.println("Ungültige Eingabe, bitte eine Zahl eingeben!");
        }
    }
    // ---- Kalorien berechnen und ausgeben ----
    int kalorienPro15Min = getKalorien(sportart, gewicht);
    int einheiten = zeitMinuten / 15;
    int gesamtKalorien = kalorienPro15Min * einheiten;

    System.out.println("\n===== Ergebnis =====");
    System.out.println("Sportart:          " + sportart);
    System.out.println("Dauer:             " + zeitMinuten + " Minuten");
    System.out.println("Gewicht:           " + gewicht + " kg");
    System.out.println("Kalorienverbrauch: " + gesamtKalorien + " kcal");
}

/*
 * getKalorien() gibt den Kalorienverbrauch pro 15 Minuten zurück.
 * Erst wird die Sportart geprüft, dann die Gewichtsklasse.
 * Erst ab diesem Bereich erfolgt eine Differenzierung zwischen den unterschiedlichen Sportarten.
 */
static int getKalorien(String sportart, int gewicht) {

    if (sportart.equals("Jogging")) {
        if      (gewicht >= 55  && gewicht <= 64)  return 113;
        else if (gewicht >= 65  && gewicht <= 74)  return 132;
        else if (gewicht >= 75  && gewicht <= 84)  return 152;
        else if (gewicht >= 85  && gewicht <= 94)  return 165;
        else if (gewicht >= 95  && gewicht <= 104) return 195;
        else if (gewicht >= 105 && gewicht <= 114) return 226;
        else if (gewicht >= 115 && gewicht <= 124) return 258;

    } else if (sportart.equals("Radfahren")) {
        if      (gewicht >= 55  && gewicht <= 64)  return 83;
        else if (gewicht >= 65  && gewicht <= 74)  return 98;
        else if (gewicht >= 75  && gewicht <= 84)  return 113;
        else if (gewicht >= 85  && gewicht <= 94)  return 128;
        else if (gewicht >= 95  && gewicht <= 104) return 145;
        else if (gewicht >= 105 && gewicht <= 114) return 161;
        else if (gewicht >= 115 && gewicht <= 124) return 178;

    } else if (sportart.equals("Walken")) {
        if      (gewicht >= 55  && gewicht <= 64)  return 62;
        else if (gewicht >= 65  && gewicht <= 74)  return 73;
        else if (gewicht >= 75  && gewicht <= 84)  return 84;
        else if (gewicht >= 85  && gewicht <= 94)  return 96;
        else if (gewicht >= 95  && gewicht <= 104) return 108;
        else if (gewicht >= 105 && gewicht <= 114) return 121;
        else if (gewicht >= 115 && gewicht <= 124) return 134;
    }

    return 0;
}
}
