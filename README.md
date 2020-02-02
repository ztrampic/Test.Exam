# Test.Exam
test project form course

Задатак 1. Направити програм који омогућава евиденцију учешћа запослених на пројеку.
   Приликом покретања програма неопходно је учитати податке о запосленима односно пројектима из датотека.  
Напомена: На крају програма уписати све податке у датотеке 
 
   Након тога кориснику приказати мени следеће садржине GLAVNI MENI 
1. Rad sa Zaposlenima 
2. Rad sa Projektima 
3. Kraj 

Vas izbor: 
 
   Уколико се корисник одлучи за опцију 1 приказати му мени следеће садржине: 
    Rad sa Zaposlenima 
    
1. Unos novog zaposlenog i. Unose se podaci o novom zaposlenom. 
2. Izmena podataka o zaposlenom i. Korisnik unosi sifru zaposlenog  ii. Sistem vraća i prikazuje podatke o zaposlenom iii.
   Korisnik menja podatke(Ukoliko ne unese ništa već samo pritisne enter podatak ostaje isti) 
3. Brisanje podataka o zaposlenom i. Korisnik unosi šifru zaposlenog. Prilikom brisanja ne treba se fizički obrisati zaposleni već je 
neophodno uraditi SOFT delete.(Samo mu promeniti status). Ukoliko korisnik sa takvom šifrom ne postoji samo prikazati poruku o tome.  
4. Prikaz svih zaposlenih
5. Povratak u glavni meni i. Ponovo se prikazuje glavni meni 

Rad sa Projektima 
   Уколико се корисник одлучи за опцију 2 главног менија приказати му мени следеће садржине: 
Rad sa projektima 
1. Unos novog projekta o Korisnik prvo unosi podatke o projektu (sifra, naziv, datumOd, datumDo) o Nakon toga unosi podatke
   o angažovanju 
   
   Unosi prvo sifru radnika(ukoliko sifra nije validna prekinuti unosi vratiti se na meni) 
   Nakon toga korisnik unosi broj radnih sati dnevno(double)  Datum pocetka rada na projektu 
   Datum zavrsetka rada na projektu 
   Kada zavrsi unos korisnika treba pitati da li zeli da nastavi sa unosom angazovanja. 
    Ukoliko odgovori potvrdno ponoviti unos
 
2. Kreiranje izveštaja o projektu i. Kreirati tekstualni izveštaj sa kompletnim podacima o projektu(ispisati rukovodioca) i 
   svim angažovanim zaposlenim na projektu. Izvestaj treba da sadrži naziv projekta i datum kada je izvestaj napravljen. 
3. Povratak u glavni meni 
 
 
Napomena: Приликом чувања пројекта урадити следећу валидацију: 
 На пројекту може радити само један радник као руководилац
 Број радних сати ангажовања једног радника на пројекту мора већи од 0 i мањи 8 радних сати 
 Један запослени може бити додат у оквиру пројекта само једном  Ангажовање радника не сме бити дуже од трајања пројекта 
 
