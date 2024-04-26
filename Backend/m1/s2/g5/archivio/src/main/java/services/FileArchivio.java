package services;

import data.Catalogo;

import java.util.ArrayList;

public class FileArchivio implements Archivio {

    private final ArrayList<Catalogo> Listacatalogo = new ArrayList<>();

    @Override
    public void addCatalogo(Catalogo c) {

    Listacatalogo.add(c);
    }

    @Override
    public void deleteISBN(int ISBN) {



    }

    @Override
    public Catalogo getISBN(int ISBN) {

        Listacatalogo.stream()
                .filter(catalogo -> catalogo.getISBN().equals()

    }



    @Override
    public void getAnno(int anno) {

    }

    @Override
    public void getAutore(String autore) {

    }
}
