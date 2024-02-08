//Creazione tombola e bottone generatore random

const tombolaContainer = document.querySelector(".tombola-container");
const tabellinaContainer = document.querySelector(".tabellina-container");

// Creazione celle della Tombola

for (let i = 1; i <= 90; i++) {
  const cella = document.createElement("div");
  cella.classList.add("casella");
  cella.innerText = i;
  tombolaContainer.append(cella);
}

//-----------------------------------------------------------

// Creazione celle della tabellina

for (let i = 1; i <= 24; i++) {
  const cellaTabellina = document.createElement("div");
  cellaTabellina.classList.add("tabellina");
  cellaTabellina.innerText = Math.floor(Math.random() * 90) + 1;
  tabellinaContainer.append(cellaTabellina);
}

// Creazione dei numeri casuali al click del bottone

document.querySelector(".bottone").addEventListener("click", function () {
  const numeroCasuale = Math.floor(Math.random() * 90) + 1;

  //ciclo la tombola e se al valore numerico della cella ciclata corrispond il numero random, coloro il bg di giallo

  const caselle = document.querySelectorAll(".casella");

  caselle.forEach(function (casella, i) {
    if (i + 1 === numeroCasuale) {
      casella.style.backgroundColor = "yellow";
    }
  });

  //ciclo la tabellina, creo una costante e le do il valore contenuto nella cella ciclata (il numero random) e se al valore assegnato corrisponde il numero random, coloro il bg di giallo
  const caselleTabellina = document.querySelectorAll(".tabellina");

  caselleTabellina.forEach(function (casellaTab) {
    const numeroCasellaTab = parseInt(casellaTab.innerText);
    if (numeroCasellaTab === numeroCasuale) {
      casellaTab.style.backgroundColor = "yellow";
    }
  });
});
