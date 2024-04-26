package services;

import data.Catalogo;

public interface Archivio {
    void addCatalogo(Catalogo c);
    void deleteISBN(int ISBN);
    Catalogo getISBN(int ISBN);
    void getAnno(int anno);
    void getAutore(String autore);



}
