# Dental Clinic System (Softverski sistem za upravljanje zubarskom ordinacijom)

Sveobuhvatno softversko rešenje za upravljanje poslovanjem zubarske ordinacije, razvijeno kao višeslojna klijent-server aplikacija u Java okruženju. Sistem omogućava efikasno vođenje evidencije pacijenata, zakazivanje i praćenje stomatoloških pregleda, evidentiranje pruženh usluga, kao i rad sa stomatološkim kartonima i timom lekara.

---

## 🏗 Arhitektura sistema

Projektovan je po standardnoj 3-tier arhitekturi sa jasnim odvajanjem logike i klijent-server komunikacijom putem Socket-a:

* **`common`** – Zajednička biblioteka koja sadrži domenske klase (model), komunikacione objekte (`Request`, `Response`), operacije/konstante i interfejse za prenos podataka.
* **`server`** – Bekend aplikacija sa višenitnom obradom zahteva (multithreading), poslovnom logikom (Controller/SO), pristupom bazi podataka (JDBC/DAO) i upravljanjem konekcijama.
* **`client`** – Klijentska desktop aplikacija sa grafičkim korisničkim interfejsom (Java Swing) zasnovana na MVC/Controller šablonu.

---

## 🛠 Tehnologije i alati

* **Jezik:** Java (JDK 17+)
* **GUI Framework:** Java Swing
* **Komunikacija:** TCP/IP Sockets (Custom serialization protocol)
* **Baza podataka:** MySQL / MariaDB
* **Pristup bazi:** JDBC (Java Database Connectivity)
* **Arhitektonski šabloni:** MVC, System Operation (SO), DAO, Factory, Singleton
* **Jedinično testiranje:** JUnit 5

---

## ✨ Ključne funkcionalnosti

* **Autentifikacija i autorizacija:**
  * Sigurna prijava stomatologa/administratora na sistem.
* **Upravljanje pacijentima:**
  * Unos, pretraga, izmena i brisanje kartona pacijenata.
  * Praćenje istorije bolesti i kontakt informacija.
* **Zakazivanje i evidencija pregleda:**
  * Zakazivanje termina za stomatološke preglede.
  * Dodeljivanje lekara i odabir stomatoloških usluga.
* **Evidencija usluga i cenovnik:**
  * Pregled i vođenje cenovnika stomatoloških usluga.
  * Izračunavanje ukupnih troškova pregleda.
* **Konfiguracija i nadzor servera:**
  * Podesivi parametri konekcije (port, baza, korisničko ime i lozinka).
  * Praćenje aktivnih korisnika u realnom vremenu na serveru.

---

## 🚀 Uputstvo za pokretanje

### 1. Preduslovi
* Instaliran **Java Development Kit (JDK 17+)**
* Instaliran **MySQL Server**
* IDE po izboru (IntelliJ IDEA, Eclipse, NetBeans)

### 2. Podešavanje baze podataka
1. Pokrenite vaš MySQL server (npr. preko XAMPP-a ili MySQL Workbench-a).
2. Domaći skript za bazu podataka možete naći u folderu `server/db` ili ga kreirati ručno.
3. Kreirajte bazu npr. `dental_clinic` i uvezite strukturu i početne podatke.

### 3. Konfiguracija i pokretanje Servera
1. Otvorite projekat u vašem IDE-u.
2. Unutar `server` modula podesite fajl `dbconfig.properties` sa vašim parametrima baze:
   ```properties
   url=jdbc:mysql://localhost:3306/dental_clinic
   username=root
   password=your_password
   ```
3. Pokrenite glavnu klasu servera: `ServerForm` ili `MainServer`.
4. Kliknite na dugme za pokretanje servera.

### 4. Pokretanje Klijenta
1. Nakon što je server uspešno pokrenut, pokrenite klijentsku aplikaciju iz `client` modula (`LoginForm` ili `MainClient`).
2. Prijavite se sa validnim korisničkim nalogom stomatologa.

---

## 📂 Struktura projekta

```text
dental-clinic-system/
├── common/                # Zajednički domen i DTO objekti
│   └── src/main/java/rs/ac/bg/fon/common/
├── server/                # Bekend logika i server konekcija
│   └── src/main/java/rs/ac/bg/fon/server/
├── client/                # Swing korisnički interfejs
│   └── src/main/java/rs/ac/bg/fon/client/
└── README.md
```

---

## 📝 Autor

* **Ognjen** ([@ogi87](https://github.com/ogi87))