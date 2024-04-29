SELECT *
FROM "esercizio"."Clienti"
WHERE "Nome" = 'Mario';

SELECT *
FROM "esercizio"."Clienti"
WHERE "Nome" = 'Simone';


SELECT "Nome", "Cognome"
FROM "esercizio"."Clienti"
WHERE EXTRACT (YEAR FROM "AnnoNascita") = 1982;


SELECT *
FROM "esercizio"."Fatture"
WHERE "Iva" = 20;

SELECT *
FROM "esercizio"."Prodotti"
WHERE EXTRACT (YEAR FROM "DataAttivazione") = 2017
AND ("InCommercio" = TRUE OR "InProduzione" = TRUE);

SELECT *
FROM "esercizio"."Fatture"
INNER JOIN "esercizio"."Clienti"
ON "esercizio"."Fatture"."IdCliente" = "esercizio"."Clienti"."NumeroCliente"
WHERE "esercizio"."Fatture"."Importo" <= 1000;

SELECT 
    "Fatture"."NumeroFattura" AS "Numero Fattura",
    "Fatture"."Importo" AS "Importo",
    "Fatture"."Iva" AS "IVA",
    "Fatture"."DataFattura" AS "Data Fattura",
    "Fornitori"."Denominazione" AS "Nome Fornitore"
FROM 
    "esercizio"."Fatture"
INNER JOIN 
    "esercizio"."Fornitori" 
ON 
    "Fatture"."NumeroFornitore" = "Fornitori"."NumeroFornitore";







