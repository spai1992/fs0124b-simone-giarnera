/* ESERCIZIO 1
 Scrivi una funzione di nome "area", che riceve due parametri (l1, l2) e calcola l'area del rettangolo associato.
*/

function area(l1, l2) {
  return l1 * l2;
}

console.log(area(6, 5));

/* ESERCIZIO 2
 Scrivi una funzione di nome "crazySum", che riceve due numeri interi come parametri.
 La funzione deve ritornare la somma dei due parametri, ma se il valore dei due parametri è il medesimo deve invece tornare
 la loro somma moltiplicata per tre.
*/

function crazySum(l1, l2) {
  if (l1 !== l2) {
    return l1 + l2;
  } else {
    return (l1 + l2) * 3;
  }
}

console.log(crazySum(20, 20));

/* ESERCIZIO 3
 Scrivi una funzione di nome "crazyDiff" che calcola la differenza assoluta tra un numero fornito come parametro e 19.
 Deve inoltre tornare la differenza assoluta moltiplicata per tre qualora il numero fornito sia maggiore di 19.
*/

function crazyDiff(l1, l2 = 19) {
  if (l1 > l2) {
    return (l1 - l2) * 3;
  } else {
    return l1 - l2;
  }
}

console.log(crazyDiff(21));

/* ESERCIZIO 4
 Scrivi una funzione di nome "boundary" che accetta un numero intero n come parametro, e ritorna true se n è compreso tra 20 e 100 (incluso) oppure
 se n è uguale a 400.
*/

function boundary(n) {
  if ((n > 20 && n <= 100) || n == 400) {
    return true;
  }
}

console.log(boundary(400));

/* ESERCIZIO 5
 Scrivi una funzione di nome "epify" che accetta una stringa come parametro.
 La funzione deve aggiungere la parola "EPICODE" all'inizio della stringa fornita, ma se la stringa fornita comincia già con "EPICODE" allora deve
 ritornare la stringa originale senza alterarla.
*/

function epify(frase) {
  if (frase.indexOf("EPICODE") === 0) {
    return frase;
  } else {
    return "EPICODE " + frase;
  }
}

console.log(epify(",la scuola in cui sto imparando il JS"));
console.log(epify("EPICODE ,la scuola in cui sto studiando il JS"));

/* ESERCIZIO 6
 Scrivi una funzione di nome "check3and7" che accetta un numero positivo come parametro. La funzione deve controllare che il parametro sia un multiplo
 di 3 o di 7. (Suggerimento: usa l'operatore modulo)
*/

function check3and7(x) {
  if (x < 0) {
    return "il numero è negativo";
  }

  if (x % 3 == 0 || x % 7 == 0) {
    return "il numero è divisibile per 3 o per 7";
  } else {
    return "il numero non è divisibile";
  }
}

console.log(check3and7(13));

/* ESERCIZIO 7
 Scrivi una funzione di nome "reverseString", il cui scopo è invertire una stringa fornita come parametro (es. "EPICODE" --> "EDOCIPE")
*/

function reverseStrings(stringa) {
  let splitString = stringa.split("");
  let reverseArray = splitString.reverse();
  let joinArray = reverseArray.join("");
  return joinArray;
}

console.log(reverseStrings("ciao mi chiamo simone"));

/* ESERCIZIO 8
 Scrivi una funzione di nome "upperFirst", che riceve come parametro una stringa formata da diverse parole.
 La funzione deve rendere maiuscola la prima lettera di ogni parola contenuta nella stringa.
*/

function upperFirst(stringa) {
  return stringa
    .split(" ")
    .map(function (parola) {
      return parola.charAt(0).toUpperCase() + parola.slice(1);
    })
    .join(" ");
}

console.log(
  upperFirst("esempio di una frase senza nessuna minuscola inserita")
);

/* ESERCIZIO 9
 Scrivi una funzione di nome "cutString", che riceve come parametro una stringa. La funzione deve creare una nuova stringa senza il primo e l'ultimo carattere
 della stringa originale.
*/

function cutString(stringa) {
  if (stringa.length < 2) {
    return "hai inserito una parola con meno di 2 caratteri";
  }

  let nuovaStringa = stringa.slice(1, -1);
  return nuovaStringa;
}

console.log(cutString("mi chiamo simone"));

/* ESERCIZIO 10
 Scrivi una funzione di nome "giveMeRandom", che accetta come parametro un numero n e ritorna un'array contenente n numeri casuali inclusi tra 0 e 10.
*/

function giveMeRandom(x) {
  let arr = [];
  for (let i = 1; i <= x; i++) {
    arr.push(Math.floor(Math.random() * 11));
  }

  return arr;
}

console.log(giveMeRandom(12));
