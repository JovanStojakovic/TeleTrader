# TeleTrader Project

## Opis
Ovaj projekat je backend aplikacija za obradu i čuvanje naloga na tržištu, sa funkcionalnostima za dodavanje novih naloga i prikaz top 10 Buy i Sell naloga.
Projekat koristi Spring Boot i Maven za upravljanje zavisnostima i pokretanje aplikacije. Aplikacija takođe koristi H2 bazu podataka za skladištenje podataka o nalozima.
Za testiranje ove aplikacije krošćen je Postman

## Funkcionalnosti
1. Dodavanje naloga (Order) 
   Omogućava korisnicima da pošalju nove naloge unoseći potrebne vrednosti.

2. Prikaz Top 10 Buy naloga
   Prikazuje 10 najboljih naloga za kupovinu, sortirane po ceni opadajuće (veća cena je bolja).

3. Prikaz Top 10 Sell naloga
   Prikazuje 10 najboljih naloga za prodaju, sortirane po ceni rastuće (manja cena je bolja).

## Pokretanje aplikacije

### Opcija 1: Pokretanje putem terminala

Ako imate Maven instaliran, možete pokrenuti aplikaciju putem terminala koristeći Maven Wrapper:

1. Otvorite terminal (PowerShell ili Command Prompt) u root folderu projekta.
2. Pokrenite sledeću komandu:

   Za Windows:
   ```sh
   .\mvnw spring-boot:run

### Opcija 2: Pokretanje putem IDE-a (npr. IntelliJ IDEA ili Eclipse)
1. Otvorite projekat u svom IDE-u.
2. Pronađite klasu TeleTraderProjectApplication u src direktorijumu.
3. Desnim klikom na klasu TeleTraderProjectApplication i odaberite opciju Run 'TeleTraderProjectApplication'.
4. Aplikacija će se pokrenuti kao Spring Boot aplikacija.

## API zahtevi
1. Dodavanje novog naloga:

   Metoda: POST
   URL: localhost:8080/order
   Telo zahteva:
   {
   "orderType": 0,  //0 = BUY, 1 = SELL 
   "price":27500764,  // Cena naloga
   "amount": 20,  // Količina
   "stockSymbol": 1,  // 0 = AAPL, 1 = GOOGL, 2 = MSFT, 3 = AMZN, 4 = TSLA, 5 = NFLX
   "traderName": "Nikola"  // Ime trgovca
   }

2. Prikaz top 10 Buy naloga:
   Metoda: GET
   URL: localhost:8080/order/top10?orderType=BUY

3. Prikaz top 10 Sell naloga:
   Metoda: GET
   URL: localhost:8080/order/top10?orderType=SELL
   