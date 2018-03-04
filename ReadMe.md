#Login

Pentru login se foloseste un sistem standard de logare,in care pentru salvarea parolei si a username-ului sunt salvate local in subdirectorul /temp.
Pentru logare se tine cont ca UserName si Password sunt case sensitive de maxim 12 caractere.

#Functionalitate de baza

Pentru oferte si cereri mecanismul este unul destul de simplu: mai intai se selecteaza clientul dorit din baza apoi se da click pe o anumita actiune de inserare.
Acestea au anumite field-uri required,caz in care acestea nu sunt completate,campurile corespunzatoare vor fi completate cu rosu.
De asemenea pentru extragerea hartii se foloseste API-ul de localizare de la google.maps,mai intai extraganduse coordonatele in functie de adresa si apoi
o imagine corezpunazatoare coordonatelor.
Pentru filtre s-a mers pe construirea de Selecturi in care se regaseste intotdeauna conditia Where Id >1 pentru a evita cazul in care nu este nici o conditie selectata.


#Tehnologii folosite

Java SWING(Netbeans)
MySQL
Biblioteca JDBC pentru conexiunea cu baza de date
XAMPP pentru sustinerea bazei de date