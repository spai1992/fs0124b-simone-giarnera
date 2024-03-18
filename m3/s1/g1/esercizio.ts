interface Smartphone {
  credito: number;
  numeroChiamate: number;
}

class User implements Smartphone {
  name: string;
  lastName: string;
  credito: number = 0;
  numeroChiamate: number = 0;
  minutiChiamata: number = 0;

  constructor(name: string, lastName: string) {
    this.name = name;
    this.lastName = lastName;
  }

  ricarica(totale: number): void {
    this.credito += totale;
  }

  chiamata(minuti: number): void {
    const costoChiamata = minuti * 0.2;
    if (this.credito >= costoChiamata) {
      this.credito -= costoChiamata;
      this.numeroChiamate += 1;
      this.minutiChiamata += minuti;
    } else {
      console.log("Credito insufficiente per effettuare la chiamata.");
    }
  }

  get chiama404() {
    return this.credito;
  }

  get getNumeroChiamata() {
    return this.numeroChiamate;
  }

  azzeraChiamate(): void {
    this.numeroChiamate = 0;
  }
}

const cliente = new User("Mario", "Rossi");

cliente.ricarica(10);
cliente.chiamata(5);
cliente.chiamata(3);
cliente.chiamata(2);
console.log(cliente.chiama404);
console.log(cliente.getNumeroChiamata);
console.log(cliente.minutiChiamata);
cliente.azzeraChiamate();
