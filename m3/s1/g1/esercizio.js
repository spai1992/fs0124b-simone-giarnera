"use strict";
class User {
    constructor(name, lastName) {
        this.credito = 0;
        this.numeroChiamate = 0;
        this.name = name;
        this.lastName = lastName;
    }
    ricarica(totale) {
        this.credito += totale;
    }
    chiamata(minuti) {
        const costoChiamata = minuti * 0.2;
        if (this.credito >= costoChiamata) {
            this.credito -= costoChiamata;
            this.numeroChiamate += minuti;
        }
        else {
            console.log("Credito insufficiente per effettuare la chiamata.");
        }
    }
    get chiama404() {
        return this.credito;
    }
    get getNumeroChiamata() {
        return this.numeroChiamate;
    }
    azzeraChiamate() {
        this.numeroChiamate = 0;
    }
}
const cliente = new User("Mario", "Rossi");
cliente.ricarica(2);
cliente.chiamata(5);
cliente.chiamata(3);
cliente.chiamata(2);
console.log(cliente.chiama404);
console.log(cliente.getNumeroChiamata);
cliente.azzeraChiamate();
//# sourceMappingURL=esercizio.js.map